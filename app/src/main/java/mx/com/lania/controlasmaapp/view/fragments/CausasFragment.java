package mx.com.lania.controlasmaapp.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.com.lania.controlasmaapp.R;
import mx.com.lania.controlasmaapp.model.CausaModel;
import mx.com.lania.controlasmaapp.viewmodel.ProblemaCausaAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CausasFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<CausaModel> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_causas, container, false);
        lista = new ArrayList<CausaModel>();
        for(String causa : getResources().getStringArray(R.array.posible_causa)) {
            lista.add(new CausaModel(causa, false));
        }

        recyclerView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ProblemaCausaAdapter(lista, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

}
