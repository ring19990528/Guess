package com.fju.guess;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int answer = 55;
    int low = 1;
    int high = 100;
    int time = 0;
    private EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        number = findViewById(R.id.number);
        TextView secret = findViewById(R.id.secret);
        secret.setText("55");
    }

    public void send(View view){
        int num = Integer.parseInt(number.getText().toString());
        if(num > answer){
            high = num;
            new AlertDialog.Builder(this)
                    .setMessage(low +" to "+ high )
                    .setTitle("guess")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            number.setText("");
                        }
                    })
                    .show();
            time++;
        }
        if(num < answer){
            low = num;
            new AlertDialog.Builder(this)
                    .setMessage(low + " to " + high)
                    .setTitle("guess")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            number.setText("");
                        }
                    })
                    .show();
            time++;
        }
        if(num == answer){
            new AlertDialog.Builder(this)
                    .setMessage("Yes,the number is 55")
                    .setTitle("guess")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
            time++;
            if (time <= 3){
                Intent intent = new Intent(this,ExcellentActivity.class);
                startActivity(intent);
                finish();
            }
        }

    }
}
