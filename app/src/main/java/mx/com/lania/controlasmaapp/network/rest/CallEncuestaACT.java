package mx.com.lania.controlasmaapp.network.rest;

import android.content.Context;

import mx.com.lania.controlasmaapp.model.ACT;
import mx.com.lania.controlasmaapp.model.Constantes;
import mx.com.lania.controlasmaapp.model.Login;
import mx.com.lania.controlasmaapp.model.Mensaje;
import mx.com.lania.controlasmaapp.network.Api;
import mx.com.lania.controlasmaapp.network.Services;
import mx.com.lania.controlasmaapp.view.custom.ProgressLoading;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallEncuestaACT {
    private ProgressLoading progress;
    private Call<Mensaje> call;
    private CallEncuestaACT.Delegate delegate;
    private ACT act;

    public CallEncuestaACT(Context context, ACT act, CallEncuestaACT.Delegate delegate) {
        this.delegate = delegate;
        this.act = act;
        this.progress = new ProgressLoading(context);
    }

    public void execute(){
        progress.onShow();

        Services services = Api.getClient().create(Services.class);
        call = services.registrarACT(Constantes.AUTH, this.act.id_paciente,
                this.act.pregunta_uno,
                this.act.pregunta_dos,
                this.act.pregunta_tres,
                this.act.pregunta_cuatro,
                this.act.pregunta_cinco);

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
