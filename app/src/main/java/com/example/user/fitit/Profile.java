package com.example.user.fitit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    Button edit;
    TextView name;
    TextView age;
    TextView height;

    Button graph;
    Button video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        edit = (Button)findViewById(R.id.edit);
        graph = (Button)findViewById(R.id.btn_graph);
        video =(Button)findViewById(R.id.btn_video);
        name   = (TextView) findViewById(R.id.nameID);
        age   = (TextView) findViewById(R.id.ageIN);
        height   = (TextView) findViewById(R.id.heightIN);




        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPage();
            }
        });


        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchGraph();
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchVideo();
            }
        });
    }
    public void editPage(){
        Intent intent =new Intent(this,Editprofile.class);
        startActivity(intent);
    }

    public void launchGraph(){
        Intent intent =new Intent(this,GraphActivity.class);
        startActivity(intent);
    }

    public void launchVideo(){
        Intent intent =new Intent(this,VideoActivity.class);
        startActivity(intent);
    }
}
