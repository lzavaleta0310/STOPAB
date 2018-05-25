package mx.com.lania.controlasmaapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import mx.com.lania.controlasmaapp.database.local.PacienteDao;
import mx.com.lania.controlasmaapp.model.Login;

@Database(entities = {Login.class}, version = 1)
public  abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract PacienteDao pacienteDao();

    public static AppDatabase getAppDatabase(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "sistema_asma_movil").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
