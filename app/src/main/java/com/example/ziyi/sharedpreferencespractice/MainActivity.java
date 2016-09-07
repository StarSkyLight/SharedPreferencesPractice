package com.example.ziyi.sharedpreferencespractice;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String fileName = "students";

    private final static String Key_Name = "姓名";
    private final static String Key_No = "学号";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(fileName,MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Button button_write = (Button)findViewById(R.id.write);
        Button button_read = (Button)findViewById(R.id.read);

        button_write.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editor.putString(Key_Name,"张三");
                        editor.putString(Key_No,"001");
                        editor.apply();
                    }
                }
        );


        button_read.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = sharedPreferences.getString(Key_Name,null);
                        String no = sharedPreferences.getString(Key_No,null);

                        Toast.makeText(MainActivity.this,Key_Name+":"+name+"  "+Key_No+":"+no,Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
