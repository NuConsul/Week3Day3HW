package com.chemwater.week3day3hw;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager ;
import android.support.v7.widget.RecyclerView ;
import android.view.View ;
import android.widget.CheckBox ;
import android.widget.EditText ;

import java.util.ArrayList ;

public class MainActivity extends Activity {

    //Globally accesible variables
    RecyclerView recyclerView ;
    MyRecyclerViewAdapter myRecyclerViewAdapter ;

    //declare views and bind them
    EditText etAniType, etAniName, etAniSound, etRating ;
    CheckBox chkIsHerbivore ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;

        //Bind other views used to insert Animals
        etAniName = (EditText) findViewById(R.id.etAnimName) ;
        etAniType = (EditText) findViewById(R.id.etAniType) ;
        etAniSound = (EditText) findViewById(R.id.etAniSound) ;
        etRating = (EditText) findViewById(R.id.etRating) ;
        chkIsHerbivore = (CheckBox) findViewById(R.id.chkIsHerbivore) ;

        //Bind RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.rvMainView) ;

        //Recycler View needs 2 items
        //1. LayoutManager (Can be customized but generally use the one the system gives)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this) ; //Can have GridLayoutManager too also relative
        recyclerView.setLayoutManager(layoutManager) ;

        //2. RecyclerView adapter (We write this)
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(generateListOfAnimals()) ;
        recyclerView.setAdapter(myRecyclerViewAdapter) ;

        /*
        If we had a database, call the method from the database helper that returns
        an ArrayList (most likely all the databases entries) and pass it in the constructor

        ex:
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(generatedListOfAnimals()) ;
        Change to:
        ArrayList<Beverage> bevList = beverageDatabaseHelper.getAllBeverages() ;
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(bevList) ;
         */
    }

    // public Beverages(String name, String servingSize, int rating, boolean isCaffinated, boolean isAlcoholic, boolean isCarbonated) {
    //public Animals(String animalType, String animalName, String animalSound, int rating, boolean isHerbivore)
    //Test method that will hold a list of animals
    private ArrayList<Animals> generateListOfAnimals() {
        ArrayList<Animals> animalsArrayList = new ArrayList<>() ;
        animalsArrayList.add(new Animals("Reptile", "Snake", "SssssSSs", 5, false )) ;
        animalsArrayList.add(new Animals("Mammal", "Cat", "Meow", 5, false)) ;
        animalsArrayList.add(new Animals("Mammal", "Monkey", "Oooh ahh ah", 5, true)) ;
        animalsArrayList.add(new Animals("Mammal", "Human", "Language", 5, false)) ;
        animalsArrayList.add(new Animals("Reptile", "Parrot", "Talk and Sing", 5, true)) ;



        animalsArrayList.add(new Animals("Reptile", "Snake", "SssssSSs", 5, false )) ;
        animalsArrayList.add(new Animals("Mammal", "Cat", "Meow", 5, false)) ;
        animalsArrayList.add(new Animals("Mammal", "Monkey", "Oooh ahh ah", 5, true)) ;
        animalsArrayList.add(new Animals("Mammal", "Human", "Language", 5, false)) ;
        animalsArrayList.add(new Animals("Reptile", "Parrot", "Talk and Sing", 5, true)) ;


        animalsArrayList.add(new Animals("Reptile", "Snake", "SssssSSs", 5, false )) ;
        animalsArrayList.add(new Animals("Mammal", "Cat", "Meow", 5, false)) ;
        animalsArrayList.add(new Animals("Mammal", "Monkey", "Oooh ahh ah", 5, true)) ;
        animalsArrayList.add(new Animals("Mammal", "Human", "Language", 5, false)) ;
        animalsArrayList.add(new Animals("Reptile", "Parrot", "Talk and Sing", 5, true)) ;


        animalsArrayList.add(new Animals("Reptile", "Snake", "SssssSSs", 5, false )) ;
        animalsArrayList.add(new Animals("Mammal", "Cat", "Meow", 5, false)) ;
        animalsArrayList.add(new Animals("Mammal", "Monkey", "Oooh ahh ah", 5, true)) ;
        animalsArrayList.add(new Animals("Mammal", "Human", "Language", 5, false)) ;
        animalsArrayList.add(new Animals("Reptile", "Parrot", "Talk and Sing", 5, true)) ;




    /*
       a) Animals Type (Mammal, Reptile, ect)
         b) Animals Name(Human, Snake, Cat, ect)
         c) Animals Sound(Talk, none, meow, ect)
     */

    return animalsArrayList ;
    }


    public void onClick(View view) {
        //Get input from user
        String type = etAniType.getText().toString() ;
        String name = etAniName.getText().toString() ;
        String sound = etAniSound.getText().toString() ;
        int rating = Integer.parseInt(etRating.getText().toString()) ;
        boolean isHerb = chkIsHerbivore.isChecked() ;
        Animals animalsToInsert = new Animals(type, name, sound, rating, isHerb) ;

        //Call the method in the adapter to add the beverage to list
        myRecyclerViewAdapter.addAnimalToList(animalsToInsert) ;

    }
}






/*
4.  Create an activity that will allow you to add an animal to the DB.
You should display a ListView for the animal types and allow the user to pick from it.
5.  Implement a item touch helper for the RecyclerView that will remove an animal from the RecyclerView AND the Database.
 */









