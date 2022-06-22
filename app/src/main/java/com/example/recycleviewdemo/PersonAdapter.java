package com.example.recycleviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{
    private ArrayList<PersonModel> people;

   /* public PersonAdapter(ArrayList<PersonModel> people) {
        this.people = people;
    }*/
    public PersonAdapter(Context context,ArrayList<PersonModel> list){
        people = list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBus;
        EditText etName, etDetails;
//class to represent every item in the list item
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //link to the components to list_items.xml
            imgBus = itemView.findViewById(R.id.imgBus);
            etName = itemView.findViewById(R.id.etName);
            etDetails = itemView.findViewById(R.id.etDetails);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
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
