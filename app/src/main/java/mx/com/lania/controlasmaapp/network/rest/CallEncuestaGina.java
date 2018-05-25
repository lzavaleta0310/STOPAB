package mx.com.lania.controlasmaapp.network.rest;

import android.content.Context;

import mx.com.lania.controlasmaapp.model.ACT;
import mx.com.lania.controlasmaapp.model.Constantes;
import mx.com.lania.controlasmaapp.model.Gina;
import mx.com.lania.controlasmaapp.model.Mensaje;
import mx.com.lania.controlasmaapp.network.Api;
import mx.com.lania.controlasmaapp.network.Services;
import mx.com.lania.controlasmaapp.view.custom.ProgressLoading;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallEncuestaGina {
    private ProgressLoading progress;
    private Call<Mensaje> call;
    private CallEncuestaGina.Delegate delegate;
    private Gina gina;

    public CallEncuestaGina(Context context, Gina gina, CallEncuestaGina.Delegate delegate) {
        this.delegate = delegate;
        this.gina = gina;
        this.progress = new ProgressLoading(context);
    }

    public void execute(){
        progress.onShow();

        Services services = Api.getClient().create(Services.class);
        call = services.registrarGina(Constantes.AUTH, this.gina.id_paciente,
                this.gina.pregunta_uno,
                this.gina.pregunta_dos,
                this.gina.pregunta_tres,
                this.gina.pregunta_cuatro,
                this.gina.pregunta_cinco);

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
