package com.rl.superheros.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProvider;

import com.rl.superheros.R;
import com.rl.superheros.model.Hero;
import com.rl.superheros.model.HerosAdapter;
import com.rl.superheros.viewmodel.HerosViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HerosAdapter adapter;

    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HerosViewModel model = new ViewModelProvider(this).get(HerosViewModel.class);

        model.getHeros().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(List<Hero> heroList) {
                adapter = new HerosAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });

    }
}