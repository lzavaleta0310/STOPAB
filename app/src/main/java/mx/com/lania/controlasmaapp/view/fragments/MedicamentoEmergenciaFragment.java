package mx.com.lania.controlasmaapp.view.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import mx.com.lania.controlasmaapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicamentoEmergenciaFragment extends Fragment {
    private static final String LOGTAG = "MedicamentoEmeFragment";
    private EditText editNombreMedicamento, editCantidad, editComentario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_medicamento_emergencia, container, false);
        editNombreMedicamento = (EditText)v.findViewById(R.id.edit_nombre_medicamento);
        editCantidad = (EditText)v.findViewById(R.id.edit_cantidad_medicamento);
        editComentario = (EditText)v.findViewById(R.id.input_comentario);

        editNombreMedicamento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    saveExacerbaciones("med1", editNombreMedicamento.getText().toString());
                }
            }
        });

        editCantidad.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    saveExacerbaciones("med2", editCantidad.getText().toString());
                }
            }
        });

        editComentario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    saveExacerbaciones("med3", editComentario.getText().toString());
                }
            }
        });
        return v;
    }

    private void saveExacerbaciones(String key, String valor){
        SharedPreferences prefs = getContext().getSharedPreferences("Crisis",getContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, valor);
        editor.commit();
    }
}
