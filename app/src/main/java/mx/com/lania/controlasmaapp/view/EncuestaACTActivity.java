package mx.com.lania.controlasmaapp.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import mx.com.lania.controlasmaapp.R;
import mx.com.lania.controlasmaapp.model.ACT;
import mx.com.lania.controlasmaapp.model.Constantes;
import mx.com.lania.controlasmaapp.model.Login;
import mx.com.lania.controlasmaapp.model.Mensaje;
import mx.com.lania.controlasmaapp.network.rest.CallEncuestaACT;
import mx.com.lania.controlasmaapp.network.rest.CallLogin;

public class EncuestaACTActivity extends AppCompatActivity {

    static final String LOGTAG = "EncuestaACTActivity";
    Button buttonEnviar;
    RelativeLayout relative1, relative2, relative3, relative4, relative5;
    TextViewEx pregunta_text1, pregunta_text2, pregunta_text3, pregunta_text4, pregunta_text5;
    static String[] arregloRespuestas = new String[5];
    LinearLayout linearProgress;
    private CallEncuestaACT call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_encuesta_act);

        buttonEnviar = (Button)findViewById(R.id.button_enviar);
        relative1 = (RelativeLayout)findViewById(R.id.linear_001);
        relative2 = (RelativeLayout)findViewById(R.id.linear_002);
        relative3 = (RelativeLayout)findViewById(R.id.linear_003);
        relative4 = (RelativeLayout)findViewById(R.id.linear_004);
        relative5 = (RelativeLayout)findViewById(R.id.linear_005);

        pregunta_text1 = (TextViewEx)findViewById(R.id.pregunta_001);
        pregunta_text2 = (TextViewEx)findViewById(R.id.pregunta_002);
        pregunta_text3 = (TextViewEx)findViewById(R.id.pregunta_003);
        pregunta_text4 = (TextViewEx)findViewById(R.id.pregunta_004);
        pregunta_text5 = (TextViewEx)findViewById(R.id.pregunta_005);

        pregunta_text1.setText(getResources().getString(R.string.act_uno),true);
        pregunta_text2.setText(getResources().getString(R.string.act_dos),true);
        pregunta_text3.setText(getResources().getString(R.string.act_tres),true);
        pregunta_text4.setText(getResources().getString(R.string.act_cuatro),true);
        pregunta_text5.setText(getResources().getString(R.string.act_cinco),true);

        linearProgress = (LinearLayout)findViewById(R.id.linearHeaderProgress);

        arregloRespuestas = new String[5];

        relative1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EncuestaACTActivity.OpcionesactDialog dialog = new EncuestaACTActivity.OpcionesactDialog();
                dialog.show(getSupportFragmentManager(), "respuesta_001");
            }
        });

        relative2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EncuestaACTActivity.OpcionesactDialog dialog = new EncuestaACTActivity.OpcionesactDialog();
                dialog.show(getSupportFragmentManager(), "respuesta_002");
            }
        });

        relative3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EncuestaACTActivity.OpcionesactDialog dialog = new EncuestaACTActivity.OpcionesactDialog();
                dialog.show(getSupportFragmentManager(), "respuesta_003");
            }
        });

        relative4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EncuestaACTActivity.OpcionesactDialog dialog = new EncuestaACTActivity.OpcionesactDialog();
                dialog.show(getSupportFragmentManager(), "respuesta_004");
            }
        });

        relative5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EncuestaACTActivity.OpcionesactDialog dialog = new EncuestaACTActivity.OpcionesactDialog();
                dialog.show(getSupportFragmentManager(), "respuesta_005");
            }
        });

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int dia = getDiaDelMes();
                if (dia == 1){
                    if(arregloRespuestas[0] == null || arregloRespuestas[1] == null || arregloRespuestas[2] == null || arregloRespuestas[3] == null || arregloRespuestas[4] == null){
                        EncuestaACTFragment.OpcionesFaltantesDialog dialog = new EncuestaACTFragment.OpcionesFaltantesDialog();
                        dialog.show(getFragmentManager(), "OpcionesFaltantesDialog");
                    } else {
                        EncuestaACTFragment.HttpRequestTask t = new EncuestaACTFragment.HttpRequestTask();
                        t.execute();
                    }
                } else {
                    EncuestaACTFragment.EnvioNoValidoDialog dialog = new EncuestaACTFragment.EnvioNoValidoDialog();
                    dialog.show(getFragmentManager(), "EnvioNoValidoDialog");
                }*/

                // Sin validación de día
                ACT act = new ACT();
                act.id_paciente = 1;
                act.pregunta_uno = arregloRespuestas[0];
                act.pregunta_dos = arregloRespuestas[1];
                act.pregunta_tres = arregloRespuestas[2];
                act.pregunta_cuatro = arregloRespuestas[3];
                act.pregunta_cinco = arregloRespuestas[4];

                call = new CallEncuestaACT(EncuestaACTActivity.this, act, new CallEncuestaACT.Delegate() {
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
            builder.setMessage(R.string.envio_no_valido_act)
                    .setPositiveButton(R.string.button_aceptar, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    })
                    /*.setNegativeButton(R.string.button_cancelar, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    })*/;
            return builder.create();
        }
    }

    public static class OpcionesFaltantesDialog extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.opciones_faltantes_act)
                    .setPositiveButton(R.string.button_aceptar, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
            return builder.create();
        }
    }

    public static class OpcionesactDialog extends DialogFragment {
        TextView respuesta1, respuesta2, respuesta3, respuesta4, respuesta5;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            respuesta1 = (TextView)getActivity().findViewById(R.id.respuesta_001);
            respuesta2 = (TextView)getActivity().findViewById(R.id.respuesta_002);
            respuesta3 = (TextView)getActivity().findViewById(R.id.respuesta_003);
            respuesta4 = (TextView)getActivity().findViewById(R.id.respuesta_004);
            respuesta5 = (TextView)getActivity().findViewById(R.id.respuesta_005);

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Selecciona una opción").setItems(R.array.opciones_act, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    String tag = getTag();
                    switch (tag){
                        case "respuesta_001":
                            switch (which){
                                case 0:
                                    respuesta1.setText("Respuesta : Siempre");
                                    arregloRespuestas[0] = "Siempre";
                                    break;
                                case 1:
                                    respuesta1.setText("Respuesta : Casi siempre");
                                    arregloRespuestas[0] = "Casi siempre";
                                    break;
                                case 2:
                                    respuesta1.setText("Respuesta : A veces");
                                    arregloRespuestas[0] = "A veces";
                                    break;
                                case 3:
                                    respuesta1.setText("Respuesta : Pocas veces");
                                    arregloRespuestas[0] = "Pocas veces";
                                    break;
                                case 4:
                                    respuesta1.setText("Respuesta : Nunca");
                                    arregloRespuestas[0] = "Nunca";
                                    break;
                            }
                            break;
                        case "respuesta_002":
                            switch (which){
                                case 0:
                                    respuesta2.setText("Respuesta : Siempre");
                                    arregloRespuestas[1] = "Siempre";
                                    break;
                                case 1:
                                    respuesta2.setText("Respuesta : Casi siempre");
                                    arregloRespuestas[1] = "Casi siempre";
                                    break;
                                case 2:
                                    respuesta2.setText("Respuesta : A veces");
                                    arregloRespuestas[1] = "A veces";
                                    break;
                                case 3:
                                    respuesta2.setText("Respuesta : Pocas veces");
                                    arregloRespuestas[1] = "Pocas veces";
                                    break;
                                case 4:
                                    respuesta2.setText("Respuesta : Nunca");
                                    arregloRespuestas[1] = "Nunca";
                                    break;
                            }
                            break;
                        case "respuesta_003":
                            switch (which){
                                case 0:
                                    respuesta3.setText("Respuesta : Siempre");
                                    arregloRespuestas[2] = "Siempre";
                                    break;
                                case 1:
                                    respuesta3.setText("Respuesta : Casi siempre");
                                    arregloRespuestas[2] = "Casi siempre";
                                    break;
                                case 2:
                                    respuesta3.setText("Respuesta : A veces");
                                    arregloRespuestas[2] = "A veces";
                                    break;
                                case 3:
                                    respuesta3.setText("Respuesta : Pocas veces");
                                    arregloRespuestas[2] = "Pocas veces";
                                    break;
                                case 4:
                                    respuesta3.setText("Respuesta : Nunca");
                                    arregloRespuestas[2] = "Nunca";
                                    break;
                            }
                            break;
                        case "respuesta_004":
                            switch (which){
                                case 0:
                                    respuesta4.setText("Respuesta : Siempre");
                                    arregloRespuestas[3] = "Siempre";
                                    break;
                                case 1:
                                    respuesta4.setText("Respuesta : Casi siempre");
                                    arregloRespuestas[3] = "Casi siempre";
                                    break;
                                case 2:
                                    respuesta4.setText("Respuesta : A veces");
                                    arregloRespuestas[3] = "A veces";
                                    break;
                                case 3:
                                    respuesta4.setText("Respuesta : Pocas veces");
                                    arregloRespuestas[3] = "Pocas veces";
                                    break;
                                case 4:
                                    respuesta4.setText("Respuesta : Nunca");
                                    arregloRespuestas[3] = "Nunca";
                                    break;
                            }
                            break;
                        case "respuesta_005":
                            switch (which){
                                case 0:
                                    respuesta5.setText("Respuesta : Siempre");
                                    arregloRespuestas[4] = "Siempre";
                                    break;
                                case 1:
                                    respuesta5.setText("Respuesta : Casi siempre");
                                    arregloRespuestas[4] = "Casi siempre";
                                    break;
                                case 2:
                                    respuesta5.setText("Respuesta : A veces");
                                    arregloRespuestas[4] = "A veces";
                                    break;
                                case 3:
                                    respuesta5.setText("Respuesta : Pocas veces");
                                    arregloRespuestas[4] = "Pocas veces";
                                    break;
                                case 4:
                                    respuesta5.setText("Respuesta : Nunca");
                                    arregloRespuestas[4] = "Nunca";
                                    break;
                            }
                            break;
                    }
                }
            });
            return builder.create();
        }
    }
}
