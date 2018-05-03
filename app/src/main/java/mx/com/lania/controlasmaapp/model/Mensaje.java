package mx.com.lania.controlasmaapp.model;

import com.google.gson.annotations.SerializedName;

public class Mensaje {
    @SerializedName("error") public String error;
    @SerializedName("mensaje") public String mensaje;
}
