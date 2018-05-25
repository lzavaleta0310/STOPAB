package mx.com.lania.controlasmaapp.database;

import java.util.concurrent.Executor;

import mx.com.lania.controlasmaapp.database.local.PacienteDao;

public class UserRepository {
    PacienteDao pacienteDao;
    Executor executor;

    public UserRepository(){

    }
}
