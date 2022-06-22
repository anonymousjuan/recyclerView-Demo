package com.example.recycleviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<PersonModel> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);


        people = new ArrayList<PersonModel>();
        people.add(new PersonModel("Zeus","Mendoza","BUS"));
        people.add(new PersonModel("Vincent","Mendoza","PLANE"));
        people.add(new PersonModel("Pedro","Penduko","PLANE"));

        myAdapter = new PersonAdapter(MainActivity.this,people);

        recyclerView.setAdapter(myAdapter);
    }
}