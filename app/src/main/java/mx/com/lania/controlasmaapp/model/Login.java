package mx.com.lania.controlasmaapp.model;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("mensaje") public Mensaje mensaje;
    @SerializedName("paciente") public Paciente paciente;

    @Override
    public String toString() {
        return "Login{" +
                "mensaje=" + mensaje.mensaje +
                ", paciente=" + paciente.nombre +
                '}';
    }
}
