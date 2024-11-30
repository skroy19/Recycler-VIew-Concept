package com.example.recyclerviewconcept;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.recyclerviewconcept.Adapter.RecipeAdapter;
import com.example.recyclerviewconcept.Models.RecipeModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Add padding to stop scrollbar earlier
        int padding = (int) (getResources().getDisplayMetrics().density * 15); // Convert 15dp to pixels
        recyclerView.setPadding(0, padding, 0, padding);
        recyclerView.setClipToPadding(false); // Allow content to scroll into the padded area

        ArrayList<RecipeModel>list = new ArrayList<>();
        list.add(new RecipeModel(R.drawable.menu1, "Food-1"));
        list.add(new RecipeModel(R.drawable.menu2, "Food-2"));
        list.add(new RecipeModel(R.drawable.menu3, "Food-3"));
        list.add(new RecipeModel(R.drawable.menu4, "Food-4"));
        list.add(new RecipeModel(R.drawable.menu5, "Food-5"));
        list.add(new RecipeModel(R.drawable.menu6, "Food-6"));
        list.add(new RecipeModel(R.drawable.menu7, "Food-7"));
        list.add(new RecipeModel(R.drawable.menu1, "Food-9"));
        list.add(new RecipeModel(R.drawable.menu2, "Food-10"));
        list.add(new RecipeModel(R.drawable.menu3, "Food-11"));
        list.add(new RecipeModel(R.drawable.menu4, "Food-12"));
        list.add(new RecipeModel(R.drawable.menu5, "Food-13"));
        list.add(new RecipeModel(R.drawable.menu6, "Food-14"));
        list.add(new RecipeModel(R.drawable.menu7, "Food-15"));

        RecipeAdapter adapter = new RecipeAdapter(list,this);
        recyclerView.setAdapter(adapter);

        //linear layout manager
        //eta by default vertically kore
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //for horizontally scroll
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //recyclerView.setLayoutManager(layoutManager);

        //for gridLayout manager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        //StaggeredGridLayout Manager
        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(staggeredGridLayoutManager);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}