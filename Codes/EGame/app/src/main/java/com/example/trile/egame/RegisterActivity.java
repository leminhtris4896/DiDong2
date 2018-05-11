package com.example.trile.egame;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trile.egame.Models.mdUsers;
import com.example.trile.egame.RegisterLogin.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    // DESIGN
    private EditText edtMail;
    private EditText edtPass;
    private EditText edtName;
    private Button btnRegister;
    private TextView tvCLOSEREGISTER;
    private RadioGroup rdbG;
    private RadioButton rdb1;
    private RadioButton rdb2;
    private RadioButton rdb3;
    private RadioButton rdb4;
    private RadioButton rdb5;
    private RadioButton rdb6;
    // FIREBASE
    private FirebaseAuth mAuth;
    private DatabaseReference mData;
    // SUGGEST
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        // Write a message to the database
        initView();
        mAuth = FirebaseAuth.getInstance();
        mData = FirebaseDatabase.getInstance().getReference().child("Users");
        //
        mProgress = new ProgressDialog(this);
        mProgress.setTitle("Đang tạo tài khoản");
        mProgress.setMessage("Xin vui lòng chờ");

        // SET CLICK
        tvCLOSEREGISTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentClose = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intentClose);
            }
        });
        // CREATE
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = edtMail.getText().toString().trim();
                final String password = edtPass.getText().toString().trim();
                final String name = edtName.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    edtPass.setError("Không để trống");
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    edtPass.setError("Không để trống");
                    return;
                } else if (password.length() < 10 || password.length() > 30) {
                    edtPass.setError("Mật khẩu 10 - 30 kí tự");
                    return;
                } else if (name.length() < 5 || name.length() > 15) {
                    edtName.setError("Tên nhân vật 5 - 15 kí tự");
                    return;
                }else {
                    mProgress.show();
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                mProgress.dismiss();
                                Toast.makeText(RegisterActivity.this, "Tạo tài khoản thất bại",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                                mData.addChildEventListener(new ChildEventListener() {
                                    @Override
                                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                        mdUsers user = dataSnapshot.getValue(mdUsers.class);
                                        final String userID = mAuth.getCurrentUser().getUid();
                                        if (rdb1.isSelected() == true) {
                                            mData.child(userID).setValue(new mdUsers(email,password,name,0,"https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/img1.png?alt=media&token=b2d752ac-4761-4ba3-8334-51349f998c00"));
                                        }else if (rdb2.isSelected() == true){
                                            mData.child(userID).setValue(new mdUsers(email,password,name,0,"https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/img2.png?alt=media&token=60623f7a-9c5d-46ab-8505-86dbdde8da81"));
                                        }else if (rdb3.isSelected() == true){
                                            mData.child(userID).setValue(new mdUsers(email,password,name,0,"https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/img3.png?alt=media&token=153d44a8-d602-4893-92e2-1e59e7d533e3"));
                                        }else if (rdb4.isSelected() == true){
                                            mData.child(userID).setValue(new mdUsers(email,password,name,0,"https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/img4.png?alt=media&token=b9542527-ebdd-4491-931b-686db35e915a"));
                                        }else if (rdb5.isSelected() == true){
                                            mData.child(userID).setValue(new mdUsers(email,password,name,0,"https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/img5.png?alt=media&token=5ce256ef-b766-4b84-8fdf-042c57157e7e"));
                                        }else {
                                            mData.child(userID).setValue(new mdUsers(email,password,name,0,"https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/img6.png?alt=media&token=bbc37c17-4217-425e-9248-b58a1a9a6134"));
                                        }
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    }

                                    @Override
                                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                                    }

                                    @Override
                                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                                    }

                                    @Override
                                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }

    private void initView() {
        tvCLOSEREGISTER = (TextView) findViewById(R.id.tvCLOSEREGISTER);
        edtMail = (EditText) findViewById(R.id.edt_mail_register);
        edtPass = (EditText) findViewById(R.id.edt_pass_register);
        edtName = (EditText) findViewById(R.id.edt_name_register);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        rdbG = (RadioGroup) findViewById(R.id.group);
        rdb1 = (RadioButton) findViewById(R.id.img1);
        rdb2 = (RadioButton) findViewById(R.id.img2);
        rdb3 = (RadioButton) findViewById(R.id.img3);
        rdb4 = (RadioButton) findViewById(R.id.img4);
        rdb5 = (RadioButton) findViewById(R.id.img5);
        rdb6 = (RadioButton) findViewById(R.id.img6);
    }
}
