package mx.com.lania.controlasmaapp.view.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mx.com.lania.controlasmaapp.R;

public class ICFemFragment extends Fragment {
    private static final String LOGTAG = "ICFemFragment";
    private EditText editMedidaFem;
    private Button buttonCalcular;
    private TextView textSemaforo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_icfem, container, false);
        editMedidaFem = (EditText)view.findViewById(R.id.text_medida_fem);
        buttonCalcular = (Button)view.findViewById(R.id.button_calcular_semaforo);
        textSemaforo = (TextView)view.findViewById(R.id.text_semaforo_level);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getContext().getSharedPreferences("Crisis",getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("fem", editMedidaFem.getText().toString());
                editor.commit();

                textSemaforo.setText("Leve");
            }
        });
        return view;
    }
}
