package com.example.Android_WeatheApp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView; import android.widget.TextView;
import java.util.HashMap; import java.util.List;
import java.util.Map;

public class MeteoListModel extends ArrayAdapter<MeteoItem> {


    private List<MeteoItem> listItems; private int resource;

    public static Map<String,Integer> images=new HashMap<>();
    static{
        images.put("Clear",R.drawable.clear);
        images.put("Clouds",R.drawable.clouds);
        images.put("Rain",R.drawable.rain);
        images.put("thunderstormspng",R.drawable.thunderstormspng);
    }
    public MeteoListModel(@NonNull Context context,int resource,
                          List<MeteoItem> data) {
        super(context, resource,data);
        Log.i("Size:",String.valueOf(data.size()));
        this.listItems=data; this.resource=resource;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup
            parent) {
        Log.i("MyLog","......................."+position);
        View listItem=convertView;
        if(listItem==null)
            listItem =LayoutInflater.from(getContext()).inflate(resource,parent,false);
        ImageView imageView=listItem.findViewById(R.id.imageView);
        TextView textViewTempMax=listItem.findViewById(R.id.TextTempMax);
        TextView textViewTempMin=listItem.findViewById(R.id.TextTempMin);
        TextView textViewPression=listItem.findViewById(R.id.TextViewPression);
        TextView textViewHumidite=listItem.findViewById(R.id.TextViewHum);
        TextView textViewDate=listItem.findViewById(R.id.textViewDate);
        String key=listItems.get(position).image;
        if(key!=null) imageView.setImageResource(images.get(key));
        textViewTempMax.setText(String.valueOf(listItems.get(position).tempMax)+"°C  ");
        textViewTempMin.setText(String.valueOf(listItems.get(position).tempMin)+"°C");
        textViewPression.setText(String.valueOf(listItems.get(position).pression)+" hPa");
        textViewHumidite.setText(String.valueOf(listItems.get(position).humidite)+"%");
        textViewDate.setText(String.valueOf(listItems.get(position).Date));
        return listItem;
    }
}


