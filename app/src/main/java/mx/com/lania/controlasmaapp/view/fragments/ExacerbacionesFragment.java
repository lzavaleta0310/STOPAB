package mx.com.lania.controlasmaapp.view.fragments;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.lania.controlasmaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExacerbacionesFragment extends Fragment {
    private static final String LOGTAG = "ExacerbacionesFragment";
    private CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7 ;
    private TextView respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7;
    private ArrayList<String> listaRespuestas = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_exacerbaciones, container, false);
        cardView1 = (CardView)view.findViewById(R.id.card_1);
        respuesta1 = (TextView)view.findViewById(R.id.text_disnea_2);

        cardView2 = (CardView)view.findViewById(R.id.card_2);
        respuesta2 = (TextView)view.findViewById(R.id.text_habla_2);

        cardView3 = (CardView)view.findViewById(R.id.card_3);
        respuesta3 = (TextView)view.findViewById(R.id.text_estado_2);

        cardView4 = (CardView)view.findViewById(R.id.card_4);
        respuesta4 = (TextView)view.findViewById(R.id.text_frecuencia_2);

        cardView5 = (CardView)view.findViewById(R.id.card_5);
        respuesta5 = (TextView)view.findViewById(R.id.text_musculos_2);

        cardView6 = (CardView)view.findViewById(R.id.card_6);
        respuesta6 = (TextView)view.findViewById(R.id.text_sibilancias_2);

        cardView7 = (CardView)view.findViewById(R.id.card_7);
        respuesta7 = (TextView)view.findViewById(R.id.text_pulsaciones_2);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                builderSingle.setTitle("Seleccionar opción que indique algún dato presente en disnea");
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("No");
                arrayAdapter.add("Al caminar, al acostarse");
                arrayAdapter.add("Al hablar, prefiere estár sentado");
                arrayAdapter.add("En reposo, encorbado hacia delante");

                builderSingle.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String respuesta = arrayAdapter.getItem(which);
                        listaRespuestas.add(0, respuesta);
                        saveExacerbaciones("exa1", respuesta);
                        respuesta1.setText("Respuesta : " + respuesta);
                        dialog.dismiss();
                    }
                });
                builderSingle.show();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                builderSingle.setTitle("Seleccionar opción que indique algún dato presente en disnea");
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("No");
                arrayAdapter.add("Al caminar, al acostarse");
                arrayAdapter.add("Al hablar, prefiere estár sentado");
                arrayAdapter.add("En reposo, encorbado hacia delante");

                builderSingle.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String respuesta = arrayAdapter.getItem(which);
                        listaRespuestas.add(1, respuesta);
                        saveExacerbaciones("exa2", respuesta);
                        respuesta2.setText("Respuesta : " + respuesta);
                        dialog.dismiss();
                    }
                });
                builderSingle.show();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                builderSingle.setTitle("Seleccionar opción que indique algún dato presente en disnea");
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("No");
                arrayAdapter.add("Al caminar, al acostarse");
                arrayAdapter.add("Al hablar, prefiere estár sentado");
                arrayAdapter.add("En reposo, encorbado hacia delante");

                builderSingle.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String respuesta = arrayAdapter.getItem(which);
                        listaRespuestas.add(2, respuesta);
                        saveExacerbaciones("exa3", respuesta);
                        respuesta3.setText("Respuesta : " + respuesta);
                        dialog.dismiss();
                    }
                });
                builderSingle.show();
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                builderSingle.setTitle("Seleccionar opción que indique algún dato presente en disnea");
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("No");
                arrayAdapter.add("Al caminar, al acostarse");
                arrayAdapter.add("Al hablar, prefiere estár sentado");
                arrayAdapter.add("En reposo, encorbado hacia delante");

                builderSingle.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String respuesta = arrayAdapter.getItem(which);
                        listaRespuestas.add(3, respuesta);
                        saveExacerbaciones("exa4", respuesta);
                        respuesta4.setText("Respuesta : " + respuesta);
                        dialog.dismiss();
                    }
                });
                builderSingle.show();
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                builderSingle.setTitle("Seleccionar opción que indique algún dato presente en disnea");
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("No");
                arrayAdapter.add("Al caminar, al acostarse");
                arrayAdapter.add("Al hablar, prefiere estár sentado");
                arrayAdapter.add("En reposo, encorbado hacia delante");

                builderSingle.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String respuesta = arrayAdapter.getItem(which);
                        listaRespuestas.add(4, respuesta);
                        saveExacerbaciones("exa5", respuesta);
                        respuesta5.setText("Respuesta : " + respuesta);
                        dialog.dismiss();
                    }
                });
                builderSingle.show();
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                builderSingle.setTitle("Seleccionar opción que indique algún dato presente en disnea");
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("No");
                arrayAdapter.add("Al caminar, al acostarse");
                arrayAdapter.add("Al hablar, prefiere estár sentado");
                arrayAdapter.add("En reposo, encorbado hacia delante");

                builderSingle.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String respuesta = arrayAdapter.getItem(which);
                        listaRespuestas.add(5, respuesta);
                        saveExacerbaciones("exa6", respuesta);
                        respuesta6.setText("Respuesta : " + respuesta);
                        dialog.dismiss();
                    }
                });
                builderSingle.show();
            }
        });

        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                builderSingle.setTitle("Seleccionar opción que indique algún dato presente en disnea");
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("No");
                arrayAdapter.add("Al caminar, al acostarse");
                arrayAdapter.add("Al hablar, prefiere estár sentado");
                arrayAdapter.add("En reposo, encorbado hacia delante");

                builderSingle.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String respuesta = arrayAdapter.getItem(which);
                        listaRespuestas.add(6, respuesta);
                        saveExacerbaciones("exa7", respuesta);
                        respuesta7.setText("Respuesta : " + respuesta);
                        dialog.dismiss();
                    }
                });
                builderSingle.show();
            }
        });
        return view;
    }

    private void saveExacerbaciones(String key, String valor){
        SharedPreferences prefs = getContext().getSharedPreferences("Crisis",getContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, valor);
        editor.commit();
    }

}
