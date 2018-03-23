package com.example.milan.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.milan.getcontent.GetContent;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://jsonplaceholder.typicode.com/posts";
        GetContent.fromURL(url).setOnResultListener(new GetContent.Result() {
            @Override
            public void Result(Boolean b, String result)
            {
                if(b)
                {
                    //success
                    Log.d("Result",result);
                }
                else {
                    //error
                    Log.d("EROOR",result);
                }
            }
        });
    }
}
