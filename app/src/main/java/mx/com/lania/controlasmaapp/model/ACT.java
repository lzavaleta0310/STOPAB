package mx.com.lania.controlasmaapp.model;

import com.google.gson.annotations.SerializedName;

public class ACT {
    @SerializedName("id_atc") public Integer id_atc;
    @SerializedName("id_paciente") public Integer id_paciente;
    @SerializedName("pregunta_uno") public String pregunta_uno;
    @SerializedName("pregunta_dos") public String pregunta_dos;
    @SerializedName("pregunta_tres") public String pregunta_tres;
    @SerializedName("pregunta_cuatro") public String pregunta_cuatro;
    @SerializedName("pregunta_cinco") public String pregunta_cinco;
}
