package mx.com.lania.controlasmaapp.model;

import com.google.gson.annotations.SerializedName;

public class InformeCrisis {
    @SerializedName("id_informe_crisis") public Integer id_informe_crisis;
    @SerializedName("fecha") public String fecha;
    @SerializedName("id_paciente") public Integer id_paciente;
    @SerializedName("hora") public String hora;
    @SerializedName("fem") public Integer fem;
    @SerializedName("posible_causa") public String posible_causa;
    @SerializedName("medicamento_emergencia") public String medicamento_emergencia;
    @SerializedName("dosis_medicamento") public String dosis_medicamento;
    @SerializedName("comentario") public String comentario;
    @SerializedName("disnea") public String disnea;
    @SerializedName("hablar") public String hablar;
    @SerializedName("estado_concidencia") public String estado_concidencia;
    @SerializedName("frecuencia_repiratoria") public String frecuencia_repiratoria;
    @SerializedName("uso_musculos") public String uso_musculos;
    @SerializedName("sibilancias") public String sibilancias;
    @SerializedName("pulsaciones_minuto") public String pulsaciones_minuto;
}
