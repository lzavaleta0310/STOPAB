package mx.com.lania.controlasmaapp.view.fragments;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import mx.com.lania.controlasmaapp.R;
import mx.com.lania.controlasmaapp.model.InformeCrisis;
import mx.com.lania.controlasmaapp.model.Login;
import mx.com.lania.controlasmaapp.model.Mensaje;
import mx.com.lania.controlasmaapp.network.rest.CallLogin;
import mx.com.lania.controlasmaapp.network.rest.CallRegistroCrisis;
import mx.com.lania.controlasmaapp.view.DesktopActivity;
import mx.com.lania.controlasmaapp.view.LoginActivity;
import mx.com.lania.controlasmaapp.viewmodel.ViewPagerAdapter;

public class InformeCrisisFragment extends Fragment {
    private static final String LOGTAG = "InformeCrisisFragment";
    private TextView textFechaCrisis, textHoraCrisis;
    private Button buttonEnviar;
    private Calendar calendar = Calendar.getInstance();
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private CallRegistroCrisis call;
    private InformeCrisis informe = new InformeCrisis();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_informe_crisis, container, false);
        textFechaCrisis = (TextView)view.findViewById(R.id.text_fecha_crisis);
        textHoraCrisis = (TextView)view.findViewById(R.id.text_hora_crisis);
        buttonEnviar = (Button)view.findViewById(R.id.button_enviar);

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);

        updateDate();
        updateTime();

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SharedPreferences prefs = getContext().getSharedPreferences("Crisis",getContext().MODE_PRIVATE);

                String medidaFem = prefs.getString("fem", "");
                String exa1 = prefs.getString("exa1", "");
                String exa2 = prefs.getString("exa2", "");
                String exa3 = prefs.getString("exa3", "");
                String exa4 = prefs.getString("exa4", "");
                String exa5 = prefs.getString("exa5", "");
                String exa6 = prefs.getString("exa6", "");
                String exa7 = prefs.getString("exa7", "");

                String med1 = prefs.getString("med1", "");
                String med2 = prefs.getString("med2", "");
                String med3 = prefs.getString("med3", "");

                if (!medidaFem.isEmpty()) {
                    informe.fem = Integer.parseInt(medidaFem);
                } else {
                    informe.fem = 0;
                }

                informe.id_paciente = 1;

                informe.fecha = textFechaCrisis.getText().toString();
                informe.hora = textHoraCrisis.getText().toString();

                informe.disnea = exa1;
                informe.hablar = exa2;
                informe.estado_concidencia = exa3;
                informe.frecuencia_repiratoria = exa4;
                informe.uso_musculos = exa5;
                informe.sibilancias = exa6;
                informe.pulsaciones_minuto = exa7;
                informe.medicamento_emergencia = med1;
                informe.dosis_medicamento = med2;
                informe.comentario = med3;

                call = new CallRegistroCrisis(getContext(), informe, new CallRegistroCrisis.Delegate() {
                    @Override
                    public void onSuccess(Mensaje mensaje) {
                        Toast.makeText(getContext(), mensaje.mensaje, Toast.LENGTH_LONG).show();

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.clear();
                        editor.commit();

                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        HomeFragment homeFragment = new HomeFragment();
                        fragmentTransaction.replace(R.id.fragment, homeFragment);
                        fragmentTransaction.commit();
                    }

                    @Override
                    public void onFailure(Object t) {

                    }
                });
                call.execute();
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDate();
            }

        };

        final TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                updateTime();
            }
        };

        textFechaCrisis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        textHoraCrisis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(getContext(), 0, time, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true).show();
            }
        });

        return view;
    }

    private void updateDate() {
        String myFormat = "dd MMM, yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        textFechaCrisis.setText(sdf.format(calendar.getTime()));
    }

    private void updateTime(){
        String myFormat =  "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        textHoraCrisis.setText(sdf.format(calendar.getTime()));
    }
}
