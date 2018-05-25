package mx.com.lania.controlasmaapp.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import mx.com.lania.controlasmaapp.R;
import mx.com.lania.controlasmaapp.model.HomeDataModel;
import mx.com.lania.controlasmaapp.view.AutoFitGridLayoutManager;
import mx.com.lania.controlasmaapp.view.HomeViewAdapter;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        arrayList = new ArrayList();
        arrayList.add(new HomeDataModel("Capturar \nsíntomas", R.mipmap.ic_sintomas, "#2F5C75"));
        arrayList.add(new HomeDataModel("Registrar \nGINA", R.mipmap.ic_gina_3, "#079AEC"));
        arrayList.add(new HomeDataModel("Registrar \nACT", R.mipmap.ic_act, "#079AEC"));
        arrayList.add(new HomeDataModel("Consultar \ngráficos", R.mipmap.ic_graph, "#2F5C75"));
        arrayList.add(new HomeDataModel("Consultar \nmedicamentos", R.mipmap.ic_medical, "#2F5C75"));

        HomeViewAdapter adapter = new HomeViewAdapter(arrayList, getContext());
        recyclerView.setAdapter(adapter);

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(getContext(), 500);
        recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        return view;
    }
}
