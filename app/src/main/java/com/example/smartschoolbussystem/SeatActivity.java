package com.example.smartschoolbussystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeatActivity extends AppCompatActivity implements View.OnClickListener{



    private Button btn_enter;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        btn_enter = findViewById(R.id.bEnter);
        btn_back = findViewById(R.id.bBackList1);
        btn_enter.setOnClickListener(this);
        btn_back.setOnClickListener(this);

    }

    @Override
    public void onClick (View v){

        switch (v.getId()) {
            case R.id.bEnter:
                Intent intent = new Intent(this, EmptySeatActivity.class);
                startActivity(intent);
                break;
            case R.id.bBackList1:
                Intent intent1 = new Intent(this, ListActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
