package com.chemwater.week3day3hw;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent ;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast ;
import android.widget.ArrayAdapter ;
import android.widget.ListView ;


public class DetailActivity extends Activity {

    Intent passedIntent ;
    Animals animals ;
    public static final String EXTRA_ANIMALNO = "animalNo" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        if(getIntent() != null) {
            passedIntent = getIntent() ;
            Bundle bundle = passedIntent.getExtras() ;
            animals = bundle.getParcelable("ani") ;


            //Populate the animal type
            TextView type = (TextView) findViewById(R.id.type) ;
            type.setText(animals.getAnimalType()) ;

            //Populate the animal name
            TextView name = (TextView) findViewById(R.id.name) ;
            name.setText(animals.getAnimalName()) ;

            //Populate the animal sound
            TextView sound = (TextView) findViewById(R.id.sound) ;
            sound.setText(animals.getAnimalSound()) ;

            //Populate the animal rating
            RatingBar rating = (RatingBar) findViewById(R.id.rating) ;
            rating.setRating(animals.getRating()) ;

        }

    }
}

//Pretty much all response calls come back as a JSON Object
