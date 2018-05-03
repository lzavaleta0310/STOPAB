package mx.com.lania.controlasmaapp.network.rest;

import android.content.Context;
import android.widget.Toast;

import mx.com.lania.controlasmaapp.model.Constantes;
import mx.com.lania.controlasmaapp.model.Login;
import mx.com.lania.controlasmaapp.model.Paciente;
import mx.com.lania.controlasmaapp.network.Api;
import mx.com.lania.controlasmaapp.network.Services;
import mx.com.lania.controlasmaapp.view.custom.ProgressLoading;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallLogin {
    private ProgressLoading progress;
    private Call<Login> call;
    private Delegate delegate;
    private String email, contrasenia;

    public CallLogin(Context context, String email, String contrasenia, Delegate delegate) {
        this.delegate = delegate;
        this.email = email;
        this.contrasenia = contrasenia;
        this.progress = new ProgressLoading(context);
    }

    public void execute(){
        progress.onShow();

        Services services = Api.getClient().create(Services.class);
        call = services.loginUsuario(Constantes.AUTH, this.email, this.contrasenia);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                int statusCode = response.code();
                if (statusCode == 200){
                    delegate.onSuccess(response.body());
                } else {
                    delegate.onFailure("Error - " + statusCode);
                }
                progress.dismiss();
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                delegate.onFailure(t.getMessage());
                progress.dismiss();
            }
        });
    }

    public interface Delegate {
        void onSuccess(Login login);
        void onFailure(Object t);
    }
}
