package mx.com.lania.controlasmaapp.view;

import android.content.Intent;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mx.com.lania.controlasmaapp.R;
import mx.com.lania.controlasmaapp.databinding.ActivityLoginBinding;
import mx.com.lania.controlasmaapp.model.Login;
import mx.com.lania.controlasmaapp.network.rest.CallLogin;
import mx.com.lania.controlasmaapp.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private static final String LOGTAG = "LoginActivity";
    private CallLogin call;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel model = new LoginViewModel("", "");
        binding.setModel(model);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call = new CallLogin(LoginActivity.this, binding.inputUsuario.getText().toString(), binding.inputContrasena.getText().toString(), new CallLogin.Delegate() {
                    @Override
                    public void onSuccess(Login login) {
                        Toast.makeText(getBaseContext(), login.mensaje.mensaje, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(LoginActivity.this, DesktopActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Object t) {
                        Log.e(LOGTAG, "onFailure :: " + t.toString());
                    }
                });
                call.execute();
            }
        });

        binding.inputUsuario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (binding.inputUsuario.getText().toString().matches(emailPattern) || binding.inputUsuario.getText().toString().length() == 0) {
                    binding.textInputCorreo.setError("");
                } else {
                    binding.textInputCorreo.setError("Correo no valido");
                }
            }
        });
    }
}
