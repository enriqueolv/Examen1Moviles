package com.example.examenmoviles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class TacoArrayAdapter extends ArrayAdapter<Taco>{
    private ArrayList<Taco> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtNumTaco;
        TextView txtCarne;
        TextView txtSalsa;
        TextView txtLimon;
        TextView txtCilantro;
        TextView txtCebolla;
    }

    public TacoArrayAdapter(ArrayList<Taco> data, Context context) {
        super(context, R.layout.view_taco, data);
        this.dataSet = data;
        this.mContext=context;
    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Taco dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.view_taco, parent, false);
            viewHolder.txtNumTaco  = (TextView) convertView.findViewById(R.id.viewTaco_textViewNumTaco);
            viewHolder.txtCarne    = (TextView) convertView.findViewById(R.id.viewTaco_textViewCarne);
            viewHolder.txtSalsa    = (TextView) convertView.findViewById(R.id.viewTaco_textViewSalsa);
            viewHolder.txtLimon    = (TextView) convertView.findViewById(R.id.viewTaco_textViewLimon);
            viewHolder.txtCebolla  = (TextView) convertView.findViewById(R.id.viewTaco_textViewCilantro);
            viewHolder.txtCilantro = (TextView) convertView.findViewById(R.id.viewTaco_textViewCebolla);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        lastPosition = position;


        viewHolder.txtNumTaco.setText("Num. Taco: " + Integer.toString(position + 1));
        viewHolder.txtCarne.setText(dataModel.getCarne());
        if(dataModel.getTipo_salsa() == 0){
            viewHolder.txtSalsa.setText("Salsa de la que pica");
        }else if(dataModel.getTipo_salsa() == 1){
            viewHolder.txtSalsa.setText("Salsa de la que NO pica");
        }else{
            viewHolder.txtSalsa.setText("Salsa de la que pica");
        }

        if (dataModel.getLimon()){
            viewHolder.txtLimon.setText("Con limón");
        }else{
            viewHolder.txtLimon.setText("");
        }

        if (dataModel.getCilantro()){
            viewHolder.txtCilantro.setText("Con cilantro");
        }else{
            viewHolder.txtCilantro.setText("");
        }

        if (dataModel.getCebolla()){
            viewHolder.txtCebolla.setText("Con cebolla");
        }else{
            viewHolder.txtCebolla.setText("");
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
