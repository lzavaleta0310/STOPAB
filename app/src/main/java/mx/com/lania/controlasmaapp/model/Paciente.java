package mx.com.lania.controlasmaapp.model;

import com.google.gson.annotations.SerializedName;

public class Paciente {
    @SerializedName("id_paciente") public Integer idPaciente;
    @SerializedName("nombre") public String nombre;
    @SerializedName("apellido_paterno") public String apellidoPaterno;
    @SerializedName("apellido_materno") public String apellidoMaterno;
    @SerializedName("edad") public Integer edad;
    @SerializedName("sexo") public String sezo;
    @SerializedName("peso") public Double peso;
    @SerializedName("estatura") public Double estatura;
    @SerializedName("direccion") public String direccion;
    @SerializedName("email") public String email;
    @SerializedName("telefono") public String telefono;
    @SerializedName("estatus") public Boolean estatus;
    @SerializedName("contrasenia") public String contrasena;
    @SerializedName("id_tipo_usuario") public Integer idTipoUsuario;


}
