package mx.com.lania.controlasmaapp.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import mx.com.lania.controlasmaapp.R;
import mx.com.lania.controlasmaapp.model.CausaModel;

public class ProblemaCausaAdapter extends RecyclerView.Adapter<ProblemaCausaAdapter.ViewHolder>{

    private List<CausaModel> lista;
    private Context context;

    public ProblemaCausaAdapter(List<CausaModel> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public ProblemaCausaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(R.layout.posible_causa_card, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProblemaCausaAdapter.ViewHolder holder, int position) {
        final int pos = position;
        holder.causa.setText(lista.get(position).getCausa());
        holder.seleccionado.setChecked(lista.get(position).isSeleccionado());
        holder.seleccionado.setTag(lista.get(position));


        holder.seleccionado.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v;

                CausaModel causaModel = (CausaModel)checkBox.getTag();
                causaModel.setSeleccionado(checkBox.isChecked());
                lista.get(pos).setSeleccionado(checkBox.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    // View Holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView causa;
        public CheckBox seleccionado;

        public CausaModel causaModel;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            causa = (TextView) itemLayoutView.findViewById(R.id.text_posible_causa);
            seleccionado= (CheckBox) itemLayoutView.findViewById(R.id.check_posible_causa);

        }

    }
}
