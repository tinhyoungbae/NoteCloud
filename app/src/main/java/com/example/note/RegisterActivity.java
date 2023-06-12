package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.note.API.ApiService;
import com.example.note.API.UserAPI;
import com.example.note.Model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private EditText getUserID, getPassword, getRepeatPassword;
    private Button registerButton;

    public void Register(){
        String getUserIDText = getUserID.getText().toString();
        String getPasswordText = getPassword.getText().toString();
        String getRepeatPasswordText = getRepeatPassword.getText().toString();
        if(getPasswordText.contains(getRepeatPasswordText) && !getPasswordText.isEmpty() && !getRepeatPasswordText.isEmpty()) {
            UserAPI.userAPI.addUser(new User(getUserIDText, getPasswordText))
                    .enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if(response.body() == true){
                                try {
                                    int i = 1, n = 3;
                                    int sleepTime = 6000;
                                    for(i = 1; i <= 3;  i++){
                                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công.\nTrở về màn hình đăng nhập sau: " +n, Toast.LENGTH_SHORT).show();
                                        n--;
                                    }
                                    Thread.sleep((long) sleepTime);
                                    finish();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                Toast.makeText(RegisterActivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Toast.makeText(RegisterActivity.this, "Lỗi Server!\nVui lòng thử lại sau.", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else{
            Toast.makeText(RegisterActivity.this, "Dữ liệu không được bỏ trống", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getUserID = findViewById(R.id.userID);
        getPassword = findViewById(R.id.password);
        getRepeatPassword = findViewById(R.id.repeatPassword);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

    }
}