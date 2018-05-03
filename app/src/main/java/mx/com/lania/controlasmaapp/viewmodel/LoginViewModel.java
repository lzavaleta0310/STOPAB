package mx.com.lania.controlasmaapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import mx.com.lania.controlasmaapp.BR;

public class LoginViewModel extends BaseObservable{
    private String email;
    private String contrasenia;

    public LoginViewModel(String email, String contrasenia) {
        this.email = email;
        this.contrasenia = contrasenia;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
        notifyPropertyChanged(BR.errorEmail);
    }

    @Bindable
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Bindable
    public String getErrorEmail() {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailPattern) && email.length() > 0) {
            return null;
        } else {
            return "Correo invalido";
        }
    }

    @Bindable
    public TextWatcher getEmailWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing.
            }
        };
    }

    @Bindable
    public TextWatcher getContrasenaWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setContrasenia(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing.
            }
        };
    }
}
