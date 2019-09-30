package com.example.smartschoolbussystem;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.net.URLEncoder;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edID;
    private EditText edName;
    private Button bLogIn;

    private Handler handler = new Handler() {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edID = findViewById(R.id.tID);
        edName = findViewById(R.id.tName);
        bLogIn = findViewById(R.id.bLogIn);
        bLogIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogIn:
                String id = edID.getText().toString();
                String name = edName.getText().toString();
                if (TextUtils.isEmpty(id)) {
                    //提示用户输入ID
                    Toast.makeText(getApplicationContext(), "Enter ID please !", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    //提示用户输name
                    Toast.makeText(getApplicationContext(), "Enter Name please !", Toast.LENGTH_LONG).show();
                    return;
                }
//                Intent intent=new Intent(this,ListActivity.class);
//                startActivity(intent);
                login(id, name);
                break;
        }

    }

    private void login(final String id, final String name) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                HttpClient httpClient = new DefaultHttpClient();
                String host = "http://192.168.1.202:8080/api/";
                String path = "auth/login";

                Map<String, String> querys = new HashMap<String, String>();
                querys.put("userIdentification",id+"");
                querys.put("name",name);






                String url = "http://192.168.1.202:8080/api/auth/login?name=David&userIdentification=51142245";

                HttpPost httpPost = new HttpPost(url);

                List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();

                for (String key : querys.keySet()) {
                    nameValuePairList.add(new BasicNameValuePair(key, querys.get(key)));
                }


                try {
                    StringEntity requestEntity = new UrlEncodedFormEntity(nameValuePairList);
                    requestEntity.setContentType("application/json; charset=UTF-8");
                    httpPost.setEntity(requestEntity);
                    try {
                        HttpResponse response = httpClient.execute(httpPost);
                        System.out.println(".....test");
                        System.out.println(response.toString());

                        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity()
                                .getContent()));
                        StringBuffer sb = new StringBuffer("");
                        String line = "";
                        String NL = System.getProperty("line.separator");
                        while ((line = in.readLine()) != null) {
                            sb.append(line + NL);
                        }
                        in.close();
                        String content = sb.toString();
                        JSONObject jsonObject = new JSONObject(content);
                        Message message = new Message();
                        message.what = 1;
                        message.obj = jsonObject;
                        System.out.println(message+"shuchu");
                        handler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
}
