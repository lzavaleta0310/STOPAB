package mx.com.lania.controlasmaapp.database;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import mx.com.lania.controlasmaapp.app.AppController;
import mx.com.lania.controlasmaapp.database.local.PacienteDao;
import mx.com.lania.controlasmaapp.network.Api;

public class PacienteRepository {
    PacienteDao pacienteDao;
    Executor executor;

    public PacienteRepository(){
        this.pacienteDao = AppDatabase.getAppDatabase(AppController.context).pacienteDao();
        executor = Executors.newSingleThreadExecutor();
    }

    public void loginPaciente(String correo, String contrasena){
        
    }
}
