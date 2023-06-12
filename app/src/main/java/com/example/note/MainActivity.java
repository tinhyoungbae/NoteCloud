package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.note.API.ApiService;
import com.example.note.API.UserAPI;
import com.example.note.Fragment.NoteFragment;
import com.example.note.Model.News;
import com.example.note.Model.ResponseAPI;
import com.example.note.Model.User;
import com.example.note.Session.SessionManager;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView getRegister, getForget;
    Button getLoginButton;
    EditText getUserID, getUserPassword;
    CheckBox getRememberCheckBox;
    SessionManager sessionManager;

    public void setOnClickRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void setOnClickForget(){
        Intent intent = new Intent(this, ForgetActivity.class);
        startActivity(intent);
    }

    public void setOnClickLogin(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getUserAPI();
        // getNewsList();
        // addNews();
        // deleteNews();

        getRegister = findViewById(R.id.register);
        getForget = findViewById(R.id.passwordForget);
        getLoginButton = findViewById(R.id.loginButton);
        getUserID = findViewById(R.id.userID);
        getUserPassword = findViewById(R.id.userPassword);
        getRememberCheckBox = findViewById(R.id.rememberCheckBox);

        sessionManager = new SessionManager(MainActivity.this);

        getRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickRegister();
            }
        });

        getForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClickForget();
            }
        });

        getLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });

        CheckLogin();
    }

    public void checkUser(){
        String getUserIDText = getUserID.getText().toString();
        String getUserIDPasswordText = getUserPassword.getText().toString();
        if(!getUserIDText.isEmpty() && !getUserIDPasswordText.isEmpty()) {
            UserAPI.userAPI.checkUser(new User(getUserIDText, getUserIDPasswordText))
                    .enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if(response.body() == true){
                                checkCheckBoxState();
                                finish();
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Không thể kết nối đến Server\nVui lòng kiểm tra lại Internet hoặc thử lại sau", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            Toast.makeText(MainActivity.this, "Tên đăng nhập hoặc mật khẩu không được trống", Toast.LENGTH_SHORT).show();
        }
    }

    public void CheckLogin(){
        if(!sessionManager.Check()){
        }else {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void checkCheckBoxState(){
        if(getRememberCheckBox.isChecked() == true){
            sessionManager.SetLogin(true);
        } else {
            sessionManager.SetLogin(false);
        }
    }
    /*

    public void getUserAPI(){
        ApiService.apiService.getNews(3)
                .enqueue(new Callback<ResponseAPI>() {
                    @Override
                    public void onResponse(Call<ResponseAPI> call, Response<ResponseAPI> response) {
                        //JSONObject jsonObject = response.body().getData();
                    }

                    @Override
                    public void onFailure(Call<ResponseAPI> call, Throwable t) {

                    }
                });
    }

    public void getNewsList(){
        ApiService.apiService.getNewsList()
                .enqueue(new Callback<List<News>>() {
                    @Override
                    public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                        getNewsArrayList = response.body();
                        Toast.makeText(MainActivity.this, "Loaded News list", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<News>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Load News list error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void addNews(){
        News m = new News();
        m.setNewsContent("uihfiusd");
        m.setNewsTitle("kwdjw");
        ApiService.apiService.addNews(m).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                news = response.body();
                Toast.makeText(MainActivity.this, "INSERTED", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteNews(){
        ApiService.apiService.deleteNews(5)
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        System.out.println("DELETED");
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                        System.out.println("DELETE FAIL");
                    }
                });
    }
     */
}