package mx.com.lania.controlasmaapp.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

import mx.com.lania.controlasmaapp.R;
import mx.com.lania.controlasmaapp.model.Gina;
import mx.com.lania.controlasmaapp.model.Mensaje;
import mx.com.lania.controlasmaapp.network.rest.CallEncuestaACT;
import mx.com.lania.controlasmaapp.network.rest.CallEncuestaGina;

public class EncuestaGinaActivity extends AppCompatActivity {
    static final String LOGTAG = "EncuestaGinaActivity";

    Button button_enviar;
    Switch check_1, check_2, check_3, check_4, check_5;
    TextViewEx pregunta_text001, pregunta_text002, pregunta_text003, pregunta_text004, pregunta_text005;
    LinearLayout linear_progress;
    private CallEncuestaGina call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_encuesta_gina);

        button_enviar = (Button)findViewById(R.id.button_enviar);

        check_1 = (Switch) findViewById(R.id.switch_pregunta_1);
        check_2 = (Switch) findViewById(R.id.switch_pregunta_2);
        check_3 = (Switch) findViewById(R.id.switch_pregunta_3);
        check_4 = (Switch) findViewById(R.id.switch_pregunta_4);
        check_5 = (Switch) findViewById(R.id.switch_pregunta_5);

        pregunta_text001 = (TextViewEx)findViewById(R.id.pregunta_gina_001);
        pregunta_text002 = (TextViewEx)findViewById(R.id.pregunta_gina_002);
        pregunta_text003 = (TextViewEx)findViewById(R.id.pregunta_gina_003);
        pregunta_text004 = (TextViewEx)findViewById(R.id.pregunta_gina_004);
        pregunta_text005 = (TextViewEx)findViewById(R.id.pregunta_gina_005);

        pregunta_text001.setText(getResources().getString(R.string.gina_uno),false);
        pregunta_text002.setText(getResources().getString(R.string.gina_dos),true);
        pregunta_text003.setText(getResources().getString(R.string.gina_tres),false);
        pregunta_text004.setText(getResources().getString(R.string.gina_cuatro),false);
        pregunta_text005.setText(getResources().getString(R.string.gina_cinco),true);

        linear_progress = (LinearLayout)findViewById(R.id.linearHeaderProgress);

        button_enviar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                /*int dia = getDiaDelMes();
                if (dia == 1 || dia == 8 || dia == 16 || dia == 24){
                    HttpRequestTask t = new HttpRequestTask();
                    t.execute();
                } else {
                    EnvioNoValidoDialog dialog = new EnvioNoValidoDialog();
                    dialog.show(getFragmentManager(), "EnvioNoValidoDialog");
                }*/

                // Sin validación de día
                //HttpRequestTask t = new HttpRequestTask();
                //t.execute();

                Gina gina = new Gina();
                gina.id_paciente = 1;
                gina.pregunta_uno = check_1.isChecked();
                gina.pregunta_dos = check_2.isChecked();
                gina.pregunta_tres = check_3.isChecked();
                gina.pregunta_cuatro = check_4.isChecked();
                gina.pregunta_cinco = check_5.isChecked();

                call = new CallEncuestaGina(EncuestaGinaActivity.this, gina, new CallEncuestaGina.Delegate() {
                    @Override
                    public void onSuccess(Mensaje mensaje) {
                        Toast.makeText(getBaseContext(), mensaje.mensaje, Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Object t) {
                        Log.e(LOGTAG, "onFailure :: " + t.toString());
                    }
                });
                call.execute();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        this.finish();
        return true;
    }



    private int getDiaDelMes(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public static class EnvioNoValidoDialog extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.envio_no_valido_gina)
                    .setPositiveButton(R.string.button_aceptar, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dismiss();
                        }
                    });
            return builder.create();
        }
    }
}
