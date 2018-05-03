package mx.com.lania.controlasmaapp.network;

import mx.com.lania.controlasmaapp.model.Login;
import mx.com.lania.controlasmaapp.model.Paciente;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Services {
    @FormUrlEncoded
    @POST("login")
    Call<Login> loginUsuario(@Header("Authorization") String authKey, @Field("email") String email, @Field("contrasenia") String contrasenia);
}
