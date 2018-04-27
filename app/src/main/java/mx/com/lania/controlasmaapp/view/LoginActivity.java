package mx.com.lania.controlasmaapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import mx.com.lania.controlasmaapp.R;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    EditText edit_usuario, edit_contrasena;
    AppCompatButton btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_usuario = (EditText)findViewById(R.id.input_usuario);
        edit_contrasena = (EditText)findViewById(R.id.input_contrasena);
        btn_login = (AppCompatButton)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, DesktopActivity.class);
                startActivity(i);
            }
        });
    }
}
