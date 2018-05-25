package mx.com.lania.controlasmaapp.network;

import mx.com.lania.controlasmaapp.model.Login;
import mx.com.lania.controlasmaapp.model.Mensaje;
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

    @FormUrlEncoded
    @POST("registrar_informe_crisis")
    Call<Mensaje> registrarCrisis(@Header("Authorization") String authKey,
                                  @Field("fecha") String fecha,
                                  @Field("id_paciente") Integer id_paciente,
                                  @Field("hora") String hora,
                                  @Field("fem") Integer fem,
                                  @Field("posible_causa") String posible_causa,
                                  @Field("medicamento_emergencia") String medicamento_emergencia,
                                  @Field("dosis_medicamento") String dosis_medicamento,
                                  @Field("comentario") String comentario,
                                  @Field("disnea") String disnea,
                                  @Field("hablar") String hablar,
                                  @Field("estado_coincidencia") String estado_coincidencia,
                                  @Field("frecuencia_respiratoria") String frecuencia_respiratoria,
                                  @Field("uso_musculos") String uso_musculos,
                                  @Field("sibilancias") String sibilancias,
                                  @Field("pulsaciones_minuto") String pulsaciones_minuto);

    @FormUrlEncoded
    @POST("registrar_act")
    Call<Mensaje> registrarACT(@Header("Authorization") String authKey,
                             @Field("id_paciente") Integer id_paciente,
                             @Field("pregunta_uno") String pregunta_uno,
                             @Field("pregunta_dos") String pregunta_dos,
                             @Field("pregunta_tres") String pregunta_tres,
                             @Field("pregunta_cuatro") String pregunta_cuatro,
                             @Field("pregunta_cinco") String pregunta_cinco);

    @FormUrlEncoded
    @POST("registrar_gina")
    Call<Mensaje> registrarGina(@Header("Authorization") String authKey,
                               @Field("id_paciente") Integer id_paciente,
                               @Field("pregunta_uno") Boolean pregunta_uno,
                               @Field("pregunta_dos") Boolean pregunta_dos,
                               @Field("pregunta_tres") Boolean pregunta_tres,
                               @Field("pregunta_cuatro") Boolean pregunta_cuatro,
                               @Field("pregunta_cinco") Boolean pregunta_cinco);

    @FormUrlEncoded
    @POST("registro_diario")
    Call<Mensaje> registroDiario(@Header("Authorization") String authKey,
                                 @Field("disnea") String disnea,
                                 @Field("id_paciente") Integer id_paciente,
                                 @Field("sibilancias") String sibilancias,
                                 @Field("opresion_de_pecho") String opresion_de_pecho,
                                 @Field("comentario") String comentario,
                                 @Field("fem") Integer fem,
                                 @Field("dosis_indicada") String dosis_indicada,
                                 @Field("otra_dosis") String otra_dosis);
}
