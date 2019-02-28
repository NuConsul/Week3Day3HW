package com.chemwater.week3day3hw;

import android.os.Parcelable;
import android.os.Parcel ;

public class Animals implements Parcelable {

    private String animalType ;
    private String animalName ;
    private String animalSound ;
    private boolean isHerbivore ;
    private int rating ;

    private int animalId ;

    protected Animals(Parcel in) {
        animalType = in.readString();
        animalName = in.readString();
        animalSound = in.readString();
        isHerbivore = in.readByte() != 0 ;
        rating = in.readInt() ;



        animalId = in.readInt() ;
    }


    public static final Creator<Animals> CREATOR = new Creator<Animals>() {
        @Override
        public Animals createFromParcel(Parcel in) {
            return new Animals(in);
        }

        @Override
        public Animals[] newArray(int size) {
            return new Animals[size];
        }
    };

    public Animals() {
    }

    public Animals(String animalType, String animalName, String animalSound, int rating, boolean isHerbivore) {
        this.animalType = animalType ;
        this.animalName = animalName ;
        this.animalSound = animalSound ;
        this.rating = rating ;
        this.isHerbivore = isHerbivore ;
    }

    public Animals(String animalType, String animalName, String animalSound, int animalId) {
        this.animalType = animalType ;
        this.animalName = animalName ;
        this.animalSound = animalSound ;
        this.animalId = animalId ;
    }

    public Animals(String animalType, String animalName, String animalSound, int rating, boolean isHerbivore,     int animalId) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalSound = animalSound;
        this.isHerbivore = isHerbivore ;
        this.rating = rating ;


        this.animalId = animalId ;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(animalType);
        parcel.writeString(animalName);
        parcel.writeString(animalSound);
        parcel.writeByte((byte) (isHerbivore ? 1 : 0)) ;
        parcel.writeInt(rating) ;




        parcel.writeInt(animalId) ;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(String animalSound) {
        this.animalSound = animalSound;
    }

    public boolean isHerbivore() {
        return isHerbivore ;
    }

    public void setHerbivore(boolean herbivore) {
        isHerbivore = herbivore ;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}