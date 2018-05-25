package mx.com.lania.controlasmaapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import mx.com.lania.controlasmaapp.BR;
import mx.com.lania.controlasmaapp.database.UserRepository;
import mx.com.lania.controlasmaapp.model.Paciente;

public class LoginViewModel extends BaseObservable{

    private LiveData<Paciente> pacienteResponse;

    private final ObservableField<String> correo = new ObservableField<>();
    private final ObservableField<String> contrasena = new ObservableField<>();
    private final ObservableField<String> correo_error = new ObservableField<>();
    private final ObservableField<String> contrasena_error = new ObservableField<>();

    //UserRepository
}
