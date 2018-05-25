package mx.com.lania.controlasmaapp.model.local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Paciente {
    @PrimaryKey
    private Integer id_pciente;
    private Integer id_sintomas_diarios;
    private Integer id_informe;
    private Integer id_medicamento;
    private Integer id_alarma;
    private Integer id_configuracion;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Integer edad;
    private String sexo;
    private Double peso;
    private Double estatura;
    private String direccion;
    private String email;
    private String telefono;
    private Boolean estatus;
    private String contrasena;
    private Integer id_tipo_usuario;

    public Integer getId_pciente() {
        return id_pciente;
    }

    public void setId_pciente(Integer id_pciente) {
        this.id_pciente = id_pciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(Integer id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public Integer getId_sintomas_diarios() {
        return id_sintomas_diarios;
    }

    public void setId_sintomas_diarios(Integer id_sintomas_diarios) {
        this.id_sintomas_diarios = id_sintomas_diarios;
    }

    public Integer getId_informe() {
        return id_informe;
    }

    public void setId_informe(Integer id_informe) {
        this.id_informe = id_informe;
    }

    public Integer getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(Integer id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public Integer getId_alarma() {
        return id_alarma;
    }

    public void setId_alarma(Integer id_alarma) {
        this.id_alarma = id_alarma;
    }

    public Integer getId_configuracion() {
        return id_configuracion;
    }

    public void setId_configuracion(Integer id_configuracion) {
        this.id_configuracion = id_configuracion;
    }
}
