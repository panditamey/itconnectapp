package com.ameypandit.itconnect;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button Login;
    TextView goToRegister;

    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;


    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences= this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.getString("isLogin","false").equals("yes")){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();

        }


            email = findViewById(R.id.atharvaemailverify);
        password = findViewById(R.id.et_password_login);
        Login = findViewById(R.id.btn_login);
        goToRegister = findViewById(R.id.goToRegister);

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtxt = email.getText().toString();
                String passtxt = password.getText().toString();
                if(email.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Kindly Enter Email", Toast.LENGTH_SHORT).show();
                }else{
                    verify(emailtxt,passtxt);
                }
            }
        });

    }


    public void LoginUser( final String email, final String password) {
        StringRequest request = new StringRequest(Request.Method.POST, "https://it-connect-v1.herokuapp.com/login", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Integer resStr = Integer.valueOf(response);

                if(resStr!=0){
                    Toast.makeText(getApplicationContext(), "Login Successful 😇", Toast.LENGTH_LONG).show();


                    editor.putString("isLogin","yes");
                    editor.commit();

                    Intent intent = new Intent (LoginActivity.this, HomeActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "Login Failed 😅", Toast.LENGTH_LONG).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String, String>();
                map.put("email",email);
                map.put("password",password);
                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
    private boolean verify(String email,String password) {


        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "atharvacoe.ac.in";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        } else {
            boolean value = pat.matcher(email).matches();
            if (pat.matcher(email).matches() == true) {
//                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(intent);
//                finish();
                LoginUser(email,password);
            }else{
                Toast.makeText(LoginActivity.this, "Kindly Enter Atharva Email", Toast.LENGTH_SHORT).show();
            }
        }

        return pat.matcher(email).matches();
    }
}