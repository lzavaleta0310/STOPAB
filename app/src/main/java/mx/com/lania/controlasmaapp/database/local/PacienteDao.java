package mx.com.lania.controlasmaapp.database.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import mx.com.lania.controlasmaapp.model.local.Paciente;

@Dao
public interface PacienteDao {
    @Query("SELECT * FROM paciente LIMIT 1")
    LiveData<Paciente> getPaciente();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Paciente paciente);

    @Delete
    void delete(Paciente paciente);
}
