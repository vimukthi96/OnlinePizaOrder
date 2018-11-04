package com.example.vimukthi.onlinepiza;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.vimukthi.onlinepiza.Common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Sign_in extends AppCompatActivity {

    private EditText edtPhone,edtPassward;
    private Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPhone=(MaterialEditText)findViewById(R.id.edtPhoneNumber);
        edtPassward=(MaterialEditText)findViewById(R.id.edtPassward);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=firebaseDatabase.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(Sign_in.this);
                mDialog.setMessage("Please Waiting...");
                mDialog.show();


                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                            mDialog.dismiss();

                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            user.setPhone(edtPhone.getText().toString());
                            if (user.getPassward().equals(edtPassward.getText().toString())) {
                                Toast.makeText(Sign_in.this, "Sign In sucessful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Sign_in.this,HomeActivity2.class);
                                Common.currentUser=user;
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Sign_in.this, "Wrong Passward", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            mDialog.dismiss();
                            Toast.makeText(Sign_in.this,"User is not exist",Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
