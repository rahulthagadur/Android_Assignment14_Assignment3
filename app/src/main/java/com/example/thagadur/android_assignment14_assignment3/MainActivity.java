package com.example.thagadur.android_assignment14_assignment3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    //Button ID are declared
    Button saveBtn;
    Button checkBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveBtn = (Button) findViewById(R.id.save_file);
        //On click of save Button the file is going to be stored in specific location
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = "Android Assignment";
                String content = "Example of the application";
                FileOutputStream outputStream = null;
                try {
                    outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(content.getBytes());
                    outputStream.close();
                    Toast.makeText(MainActivity.this, "File has been saved Successfully ", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //Check Button to check whether the file has been stored in mobile or not
        checkBtn= (Button) findViewById(R.id.check_file);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = getFilesDir().getAbsolutePath() + "/AndroidApplication";
                System.out.println("Path of the file =" + path);
                File file = new File(path);

                if (file.exists()) {
                    // Toast File is exists
                    Toast.makeText(MainActivity.this, "File exist !!", Toast.LENGTH_SHORT).show();
                } else {
                    // Toast File is not exists
                    Toast.makeText(MainActivity.this, "File not exist !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
