package mx.com.lania.controlasmaapp.network.rest;

import android.content.Context;

import mx.com.lania.controlasmaapp.model.Constantes;
import mx.com.lania.controlasmaapp.model.InformeCrisis;
import mx.com.lania.controlasmaapp.model.Mensaje;
import mx.com.lania.controlasmaapp.network.Api;
import mx.com.lania.controlasmaapp.network.Services;
import mx.com.lania.controlasmaapp.view.custom.ProgressLoading;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallRegistroCrisis {
    private ProgressLoading progress;
    private Call<Mensaje> call;
    private CallRegistroCrisis.Delegate delegate;
    private InformeCrisis informe;

    public CallRegistroCrisis(Context context, InformeCrisis informe, CallRegistroCrisis.Delegate delegate) {
        this.delegate = delegate;
        this.informe = informe;
        this.progress = new ProgressLoading(context);

    }

    public void execute(){
        progress.onShow();

        Services services = Api.getClient().create(Services.class);
        call = services.registrarCrisis(Constantes.AUTH, informe.fecha, informe.id_paciente, informe.hora,
                informe.fem, informe.posible_causa, informe.medicamento_emergencia, informe.dosis_medicamento,
                informe.comentario, informe.disnea, informe.hablar, informe.estado_concidencia, informe.frecuencia_repiratoria,
                informe.uso_musculos, informe.sibilancias, informe.pulsaciones_minuto);
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
