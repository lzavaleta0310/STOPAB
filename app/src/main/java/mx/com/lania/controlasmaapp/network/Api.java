package mx.com.lania.controlasmaapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static mx.com.lania.controlasmaapp.model.Constantes.BASE_URL;

public class Api {
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
