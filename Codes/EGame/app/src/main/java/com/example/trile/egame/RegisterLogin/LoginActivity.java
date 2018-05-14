package com.example.trile.egame.RegisterLogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trile.egame.MenuHome.HomeActivity;
import com.example.trile.egame.R;
import com.example.trile.egame.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    // DESIGN
    private TextView tvREGISTER;
    private EditText edtMail;
    private EditText edtPass;
    private Button btnLOGIN;
    // FIREBASE
    private FirebaseAuth mAuth;
    private DatabaseReference mData;
    private DatabaseReference mDataUser;
    // SUGGEST
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initView();

        //Get FireBasae
        mAuth = FirebaseAuth.getInstance();
        mDataUser = FirebaseDatabase.getInstance().getReference().child("Users");
        mData = FirebaseDatabase.getInstance().getReference();


        mProgress = new ProgressDialog(this);
        mProgress.setTitle("Đang kết nối");
        mProgress.setMessage("Vui lòng chờ");

        if (mAuth.getCurrentUser() != null) {
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }

        mProgress.dismiss();

        tvREGISTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intentRegister);
            }
        });
        btnLOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acceptLogin();
            }
        });

    }

    // Button login
    private void acceptLogin() {

        final String email = edtMail.getText().toString();
        final String password = edtPass.getText().toString();

        if (TextUtils.isEmpty(email)) {
            edtMail.setError("Không bỏ trống");
            return;
        } else if (TextUtils.isEmpty(password)) {
            edtPass.setError("Không bỏ trống");
            return;
        } else {
            mProgress.show();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {
                        if (password.length() < 10 || password.length() > 30) {
                            edtPass.setError("Tối thiểu 10 ký tự");
                            mProgress.dismiss();
                        } else {
                            mProgress.dismiss();
                            Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intentLogin = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(intentLogin);
                    }
                }
            });
        }
    }

    private void initView() {
        tvREGISTER = (TextView) findViewById(R.id.tvREGISTER);
        btnLOGIN = (Button) findViewById(R.id.btnLOGIN);
        edtMail = (EditText) findViewById(R.id.edt_mail_login);
        edtPass = (EditText) findViewById(R.id.edt_pass_login);
    }


}
