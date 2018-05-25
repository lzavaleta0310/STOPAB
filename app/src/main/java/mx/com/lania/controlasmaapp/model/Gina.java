package mx.com.lania.controlasmaapp.model;

import com.google.gson.annotations.SerializedName;

public class Gina {
    @SerializedName("id_gina") public Integer id_gina;
    @SerializedName("id_paciente") public Integer id_paciente;
    @SerializedName("pregunta_uno") public Boolean pregunta_uno;
    @SerializedName("pregunta_dos") public Boolean pregunta_dos;
    @SerializedName("pregunta_tres") public Boolean pregunta_tres;
    @SerializedName("pregunta_cuatro") public Boolean pregunta_cuatro;
    @SerializedName("pregunta_cinco") public Boolean pregunta_cinco;
}
