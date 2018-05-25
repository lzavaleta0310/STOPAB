package mx.com.lania.controlasmaapp.model;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("mensaje") public Mensaje mensaje;
    @SerializedName("paciente") public Paciente paciente;

}
