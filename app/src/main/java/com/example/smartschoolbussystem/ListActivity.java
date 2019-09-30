package com.example.smartschoolbussystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_history;
    private Button btn_studentinfo;
    private Button btn_checkseat;
    private Button btn_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        btn_history=findViewById(R.id.button_history);
        btn_studentinfo=findViewById(R.id.button_stu_info);
        btn_checkseat=findViewById(R.id.button_check_seat);
        btn_exit=findViewById(R.id.button_exit);
        btn_history.setOnClickListener(this);
        btn_studentinfo.setOnClickListener(this);
        btn_checkseat.setOnClickListener(this);
        btn_exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.button_history:

                Intent intent=new Intent(this,HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.button_stu_info:
                Intent intent1=new Intent(this,StudentinfoActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_check_seat:
                Intent intent2=new Intent(this,SeatActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_exit:
                Intent intent3=new Intent(this,LoginActivity.class);
                startActivity(intent3);
                break;
        }

    }
}
