package mx.com.lania.controlasmaapp.model;

import com.google.gson.annotations.SerializedName;

public class RegistroDiario {
    @SerializedName("id_registro_diario") public Integer id_registro_diario;
    @SerializedName("disnea") public String disnea;
    @SerializedName("id_paciente") public Integer id_paciente;
    @SerializedName("sibilancias") public String sibilancias;
    @SerializedName("opresion_de_pecho") public String opresion_de_pecho;
    @SerializedName("comentario") public String comentario;
    @SerializedName("fem") public Integer fem;
    @SerializedName("dosis_indicada") public String dosis_indicada;
    @SerializedName("otra_dosis") public String otra_dosis;
}
