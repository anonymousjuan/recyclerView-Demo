package com.example.recycleviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Person2Adapter extends RecyclerView.Adapter<Person2Adapter.ViewHolder> {
    private ArrayList<PersonModel> people;

    public Person2Adapter(ArrayList<PersonModel> people) {
        this.people = people;
    }
public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imgBus;
    EditText etName, etDetails;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        //link to the components to list_items.xml
        imgBus = itemView.findViewById(R.id.imgBus);
        etName = itemView.findViewById(R.id.etName);
        etDetails = itemView.findViewById(R.id.etDetails);
    }
}

    @NonNull
    @Override
    public Person2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Person2Adapter.ViewHolder holder, int position) {
        //bind our PersonModel to our created/designed view.
        holder.itemView.setTag(people.get(position));
        holder.etName.setText(people.get(position).getName());
        holder.etDetails.setText(people.get(position).getSurname());
        if (people.get(position).getPreference().equals("BUS")){
            holder.imgBus.setImageResource(R.drawable.bus);
        }else{
            holder.imgBus.setImageResource(R.drawable.plane);
        }
    }




    @Override
    public int getItemCount() {
        return people.size();
    }
}
