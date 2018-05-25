package mx.com.lania.controlasmaapp.network.rest;

import android.content.Context;

import mx.com.lania.controlasmaapp.model.Constantes;
import mx.com.lania.controlasmaapp.model.InformeCrisis;
import mx.com.lania.controlasmaapp.model.Mensaje;
import mx.com.lania.controlasmaapp.model.RegistroDiario;
import mx.com.lania.controlasmaapp.network.Api;
import mx.com.lania.controlasmaapp.network.Services;
import mx.com.lania.controlasmaapp.view.custom.ProgressLoading;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallRegistroDiario {
    private ProgressLoading progress;
    private Call<Mensaje> call;
    private CallRegistroDiario.Delegate delegate;
    private RegistroDiario registro;

    public CallRegistroDiario(Context context, RegistroDiario registro, CallRegistroDiario.Delegate delegate) {
        this.delegate = delegate;
        this.registro = registro;
        this.progress = new ProgressLoading(context);

    }

    public void execute(){
        progress.onShow();

        Services services = Api.getClient().create(Services.class);
        call = services.registroDiario(Constantes.AUTH, registro.disnea, registro.id_paciente, registro.sibilancias,
                registro.opresion_de_pecho,
                registro.comentario,
                registro.fem,
                registro.dosis_indicada,
                registro.otra_dosis);

        call.enqueue(new Callback<Mensaje>() {
            @Override
            public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
                int statusCode = response.code();
                if (statusCode == 200){
                    delegate.onSuccess(response.body());
                } else {
                    delegate.onFailure("Error - " + statusCode);
                }
                progress.dismiss();
            }

            @Override
            public void onFailure(Call<Mensaje> call, Throwable t) {
                delegate.onFailure(t.getMessage());
                progress.dismiss();
            }
        });
    }

    public interface Delegate {
        void onSuccess(Mensaje mensaje);
        void onFailure(Object t);
    }
}
