package com.example.youtubeme;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        link = findViewById(R.id.et_link);
    }
    public void play(View v){
        if(!link.getText().toString().equals("")){
            Intent intent = new Intent(this, YoutubePlayer.class);
            intent.putExtra("link", link.getText().toString());
            Log.d("MAINNN", "notnull " + link.getText().toString());
            startActivity(intent);
        }

    }
}