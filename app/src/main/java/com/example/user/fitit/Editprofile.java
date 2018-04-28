package com.example.user.fitit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Editprofile extends AppCompatActivity {
    Button mButton;
    EditText mEdit;
    EditText age;
    EditText height;
TextView displaay;
    String name;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);

        mButton = (Button)findViewById(R.id.button);
        mEdit   = (EditText)findViewById(R.id.nameID);
        age   = (EditText)findViewById(R.id.ageIN);
        height   = (EditText)findViewById(R.id.heightIN);
        displaay = (TextView) findViewById(R.id.displayinformation);

        mReference = FirebaseDatabase.getInstance().getReference("user");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();


            }
        });

    }
private void addUser(){
    name = mEdit.getText().toString().trim();
    String value= age.getText().toString();
    int AgeNo=Integer.parseInt(value);
    String h= height.getText().toString();
    int heiNo=Integer.parseInt(h);

    if(!TextUtils.isEmpty(name)&& AgeNo> 0 && heiNo>0){
        String id =mReference.push().getKey();

        User user = new User(id, name, AgeNo, heiNo);
        mReference.child(id).setValue(user);

        displaay.setText("Hello "+name+" your age is "+AgeNo+" Your height is "+heiNo);
        Toast.makeText(this,"Add successfully...........!!", Toast.LENGTH_LONG).show();

        profilePage();

    }else{
        Toast.makeText(this,"Please fill all fields", Toast.LENGTH_LONG).show();
    }
}

    public void profilePage(){
        Intent intent =new Intent(this,Profile.class);
        startActivity(intent);
    }

}
