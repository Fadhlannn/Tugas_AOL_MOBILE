package com.example.sesi6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText UsernameIDLogin, PasswordLogin;
    Button ButtonLogin;
    CheckBox checkBox_login;
    SharedPreferences userPrefdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        UsernameIDLogin = findViewById(R.id.UsernameIDLogin);
        PasswordLogin = findViewById(R.id.PasswordLogin);
        ButtonLogin = findViewById(R.id.ButtonLogin);
        checkBox_login = findViewById(R.id.checkBox_login);
        userPrefdata = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);

        ButtonLogin.setOnClickListener(v -> {
            boolean isremember = checkBox_login.isChecked();
            String username = UsernameIDLogin.getText().toString();
            String password = PasswordLogin.getText().toString();

            if (isremember){
                SharedPreferences.Editor editor = userPrefdata.edit();
                editor.putString("user_name",username);
                editor.putString("user_password",password);
                editor.putBoolean("user_remember",isremember);
                editor.commit();
            }

        });

        private void toHome() {
            Intent toHome = new Intent(this,MainActivity2.class);
            startActivity(toHome);
            finish();
        }

        private void checkLogin(){
            boolean isremember = userPrefdata.getBoolean("user_remember",false);

            if (isremember){
                toHome();
            }

        }
    }
}