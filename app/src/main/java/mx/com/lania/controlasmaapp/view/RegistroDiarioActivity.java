package mx.com.lania.controlasmaapp.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.com.lania.controlasmaapp.R;
import mx.com.lania.controlasmaapp.model.Mensaje;
import mx.com.lania.controlasmaapp.model.RegistroDiario;
import mx.com.lania.controlasmaapp.model.SintomaCard;
import mx.com.lania.controlasmaapp.network.rest.CallEncuestaACT;
import mx.com.lania.controlasmaapp.network.rest.CallRegistroDiario;

public class RegistroDiarioActivity extends AppCompatActivity {
    static final String LOGTAG = "RegistroDiarioActivity";
    static List<SintomaCard> sintomas;
    EditText input_comentario, input_fem, input_otra_dosis;
    TextView text_semaforo;
    RadioGroup radio_dosis;
    Button button_enviar;
    boolean dosis_indicada = true;
    LinearLayout linearProgress;
    private CallRegistroDiario call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_registro_diario);

        sintomas = new ArrayList<SintomaCard>();
        SintomaCard sc1 = new SintomaCard(false, "Disnea", "");
        SintomaCard sc2 = new SintomaCard(false, "Tos", "");
        SintomaCard sc3 = new SintomaCard(false, "Sibilancias", "");
        SintomaCard sc4 = new SintomaCard(false, "Opresión de pecho", "");

        sintomas.add(sc1);
        sintomas.add(sc2);
        sintomas.add(sc3);
        sintomas.add(sc4);

        RecyclerView rv = (RecyclerView) findViewById(R.id.sintomas_list);
        input_comentario = (EditText) findViewById(R.id.input_comentario);
        input_fem = (EditText) findViewById(R.id.input_fem);
        input_otra_dosis = (EditText) findViewById(R.id.input_otra_dosis);
        text_semaforo = (TextView) findViewById(R.id.text_semaforo);
        radio_dosis = (RadioGroup) findViewById(R.id.radio_dosis);
        button_enviar = (Button) findViewById(R.id.button_enviar);
        linearProgress = (LinearLayout)findViewById(R.id.linearHeaderProgress);

        radio_dosis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton)group.findViewById(checkedId);
                if(radioButton.getText().equals("Dosis indicada")){
                    dosis_indicada = true;
                    input_otra_dosis.setVisibility(View.GONE);
                } else {
                    dosis_indicada = false;
                    input_otra_dosis.setVisibility(View.VISIBLE);
                }
            }
        });

        button_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistroDiario registro = new RegistroDiario();

                registro.id_paciente = 1;
                registro.comentario = input_comentario.getText().toString();
                registro.disnea = sintomas.get(0).getRespuestaSintoma();
                registro.sibilancias = sintomas.get(2).getRespuestaSintoma();
                registro.opresion_de_pecho = sintomas.get(3).getRespuestaSintoma();
                registro.dosis_indicada = "" + dosis_indicada;
                registro.otra_dosis = input_otra_dosis.getText().toString();
                registro.fem = Integer.parseInt(input_fem.getText().toString());

                call = new CallRegistroDiario(RegistroDiarioActivity.this, registro, new CallRegistroDiario.Delegate() {
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

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new SintomasListAdapter(sintomas));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        this.finish();
        return true;
    }

    class SintomasListAdapter extends RecyclerView.Adapter<SintomaViewHolder> {
        private final List<SintomaCard> sintomas;

        public SintomasListAdapter(List<SintomaCard> sintomas) {
            this.sintomas = sintomas;
        }

        @NonNull
        @Override
        public SintomaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            final View v = layoutInflater.inflate(R.layout.sintomas_card, parent, false);
            return new SintomaViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull SintomaViewHolder holder, final int position) {
            holder.sintomaText.setText(sintomas.get(position).getSintoma());
            holder.sintomaCheck.setChecked(sintomas.get(position).isChecked());
            holder.respuestaText.setText("Respuesta : " + sintomas.get(position).getRespuestaSintoma());


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(v.getContext(), v);
                    popup.inflate(R.menu.registro_diario_menu);

                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_poco:
                                    sintomas.get(position).setRespuestaSintoma("Poco");
                                    sintomas.get(position).setChecked(true);
                                    notifyDataSetChanged();
                                    return true;
                                case R.id.action_moderado:
                                    sintomas.get(position).setRespuestaSintoma("Moderado");
                                    sintomas.get(position).setChecked(true);
                                    notifyDataSetChanged();
                                    return true;
                                case R.id.action_mucho:
                                    sintomas.get(position).setRespuestaSintoma("Mucho");
                                    sintomas.get(position).setChecked(true);
                                    notifyDataSetChanged();
                                    return true;
                            }
                            return false;
                        }
                    });

                    popup.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return sintomas.size();
        }
    }

    class SintomaViewHolder extends RecyclerView.ViewHolder {
        TextView sintomaText, respuestaText;
        CheckBox sintomaCheck;

        SintomaViewHolder(View itemView) {
            super(itemView);
            sintomaText = (TextView) itemView.findViewById(R.id.text_sintoma);
            respuestaText = (TextView) itemView.findViewById(R.id.text_respuesta_sintoma);
            sintomaCheck = (CheckBox) itemView.findViewById(R.id.check_sintoma);
        }
    }
}
