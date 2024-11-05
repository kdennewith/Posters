package com.example.f3connection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements PosterListener{

    private Button buttonAddToWatchList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView postersRecyclerView = findViewById(R.id.postersRecyclerView);
        buttonAddToWatchList = findViewById(R.id.buttonAddWatchList);

        //Preparing Data

        List<Poster> posterList = new ArrayList<>();

        Poster nine = new Poster();
        nine.image = R.drawable.poster9;
        nine.name = "Nine";
        nine.createdBy = "Tim Burton";
        nine.rating = 4f;
        nine.story = "This is a movie about 9 unexpected hero's surviving the terrors of the world.";
        posterList.add(nine);

        Poster district9 = new Poster();
        district9.image = R.drawable.district9;
        district9.name = "District 9";
        district9.createdBy = "Neill Blomkamp";
        district9.rating = 3.6f;
        district9.story = "A government agents investigation into District 9, and what's to come.";
        posterList.add(district9);

        Poster coraline = new Poster();
        coraline.image = R.drawable.coraline;
        coraline.name = "Coraline";
        coraline.createdBy = "Tim Burton";
        coraline.rating = 5f;
        coraline.story = "Coraline moves, and finds herself in a interesting predicament.";
        posterList.add(coraline);

        Poster spiritedAway = new Poster();
        spiritedAway.image = R.drawable.spiritedaway;
        spiritedAway.name = "Spirited Away";
        spiritedAway.createdBy = "Hayao Miyazaki";
        spiritedAway.rating = 5f;
        spiritedAway.story = "Greedy pigs.";
        posterList.add(spiritedAway);

        Poster theBoyAndHeron = new Poster();
        theBoyAndHeron.image = R.drawable.theboyandheron;
        theBoyAndHeron.name = "The Boy and the Heron";
        theBoyAndHeron.createdBy = "Hayao Miyazaki";
        theBoyAndHeron.rating = 5f;
        theBoyAndHeron.story = "The mysteries in the tower above hold the key to forgiveness";
        posterList.add(theBoyAndHeron);

        Poster cabinInTheWoods = new Poster();
        cabinInTheWoods.image = R.drawable.cabininthewoods;
        cabinInTheWoods.name = "The Cabin In The Woods";
        cabinInTheWoods.createdBy = "Drew Goddard";
        cabinInTheWoods.rating = 4.1f;
        cabinInTheWoods.story = "What lies beneath it all will surprise you";
        posterList.add(cabinInTheWoods);

        Poster vhs = new Poster();
        vhs.image = R.drawable.vhs;
        vhs.name = "V/H/S";
        vhs.createdBy = "Brad Miska";
        vhs.rating = 2.4f;
        vhs.story = "Found footage film that will leave you feeling, uncomfortable.";
        posterList.add(vhs);

        Poster ironGiant = new Poster();
        ironGiant.image = R.drawable.theirongiant;
        ironGiant.name = "The Iron Giant";
        ironGiant.createdBy = "Brad Bird";
        ironGiant.rating = 5f;
        ironGiant.story = "A Childhood favorite!";
        posterList.add(ironGiant);

        Poster goodWillHunting = new Poster();
        goodWillHunting.image = R.drawable.goodwillhunting;
        goodWillHunting.name = "Good Will Hunting";
        goodWillHunting.createdBy = "Gus Van Sant";
        goodWillHunting.rating = 5f;
        goodWillHunting.story = "Robin Williams will always be a gem.";
        posterList.add(goodWillHunting);

        Poster uncutGems = new Poster();
        uncutGems.image = R.drawable.uncutgems;
        uncutGems.name = "Uncut Gems";
        uncutGems.createdBy = "Benny Safdie";
        uncutGems.rating = 4.9f;
        uncutGems.story = "A roller-coaster ride, never been so emotionally distressed during a movie.";
        posterList.add(uncutGems);

        final PosterAdapter posterAdapter = new PosterAdapter(posterList,this);
        postersRecyclerView.setAdapter(posterAdapter);

        buttonAddToWatchList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                List<Poster> selectPosters = posterAdapter.getSelectedPosters();

                StringBuilder posterNames = new StringBuilder();
                for(int i=0;i<selectPosters.size();i++){
                    if(i==0){
                        posterNames.append(selectPosters.get(i).name);
                    }else{
                        posterNames.append("\n").append(selectPosters.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this,posterNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onPosterAction(Boolean isSelected) {
        if(isSelected){
            buttonAddToWatchList.setVisibility(View.VISIBLE);
        }else{
            buttonAddToWatchList.setVisibility(View.GONE);
        }
    }
}