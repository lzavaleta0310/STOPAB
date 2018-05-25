package mx.com.lania.controlasmaapp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.lania.controlasmaapp.R;
import mx.com.lania.controlasmaapp.model.HomeDataModel;
import mx.com.lania.controlasmaapp.view.fragments.HomeFragment;


public class HomeViewAdapter extends RecyclerView.Adapter<HomeViewAdapter.ViewHolder> {
    ArrayList<HomeDataModel> values;
    static Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public RelativeLayout mRelativeLayout;
        public ImageView mImageView;

        public ViewHolder(final View itemView) {
            super(itemView);
            this.mTextView = (TextView) itemView.findViewById(R.id.textView);
            this.mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            this.mImageView = (ImageView) itemView.findViewById(R.id.imageView);


            this.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTextView.getText().toString().equals("Registrar \nGINA")) {
                        Intent intent = new Intent(HomeViewAdapter.context, EncuestaGinaActivity.class);
                        HomeViewAdapter.context.startActivity(intent);
                    } else if(mTextView.getText().toString().equalsIgnoreCase("Registrar \nACT")){
                        Intent intent = new Intent(HomeViewAdapter.context, EncuestaACTActivity.class);
                        HomeViewAdapter.context.startActivity(intent);
                    } else if(mTextView.getText().toString().equalsIgnoreCase("Capturar \nsíntomas")){
                        Intent intent = new Intent(HomeViewAdapter.context, RegistroDiarioActivity.class);
                        HomeViewAdapter.context.startActivity(intent);
                    }
                    Toast.makeText(v.getContext(), mTextView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public HomeViewAdapter(ArrayList<HomeDataModel> values, Context context) {
        this.values = values;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeViewAdapter.ViewHolder holder, int position) {
        HomeDataModel home = values.get(position);
        holder.mTextView.setText(home.texto);
        holder.mRelativeLayout.setBackgroundColor(Color.parseColor(home.color));
        holder.mImageView.setImageResource(home.drawable);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
