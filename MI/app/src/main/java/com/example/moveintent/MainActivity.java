package com.example.moveintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMove;
    private Button btnMove2;
    private Button btnMove3;
    private Button btnMove4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove = findViewById(R.id.btn_move_intent);
        btnMove.setOnClickListener(this);

        btnMove2 = findViewById(R.id.btn_move_intent2);
        btnMove2.setOnClickListener(this);

        btnMove3 = findViewById(R.id.btn_move_intent3);
        btnMove3.setOnClickListener(this);

        btnMove4 = findViewById(R.id.btn_move_intent4);
        btnMove4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_intent:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn_move_intent2:
                startActivity(new Intent(this, Activity3.class));
                break;
            case R.id.btn_move_intent3:
                startActivity(new Intent(this, Activity4.class));
                break;
            case R.id.btn_move_intent4:
                startActivity(new Intent(this, Activity5.class));
                break;

        }
    }
}
