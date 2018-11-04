package com.example.vimukthi.onlinepiza;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Sign_up extends AppCompatActivity {

    private MaterialEditText edtName,edtPassward,edtPhoneNumber;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtName=(MaterialEditText)findViewById(R.id.edtPhoneNumber);
        edtPassward=(MaterialEditText)findViewById(R.id.edtPassward);
        edtPhoneNumber=(MaterialEditText)findViewById(R.id.edtPhoneNumber);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(Sign_up.this);
                mDialog.setMessage("Please Waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(edtPhoneNumber.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(Sign_up.this,"Phone number already added",Toast.LENGTH_SHORT).show();

                        }else{
                            mDialog.dismiss();
                            User user=new User(edtName.getText().toString(),edtPassward.getText().toString(),edtPhoneNumber.getText().toString());
                            table_user.child(edtPhoneNumber.getText().toString()).setValue(user);
                            Toast.makeText(Sign_up.this,"Sign Up successful",Toast.LENGTH_SHORT).show();
                            finish();
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
