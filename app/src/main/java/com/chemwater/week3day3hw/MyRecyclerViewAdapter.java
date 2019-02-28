package com.chemwater.week3day3hw;

import android.content.Intent ;
import android.os.Bundle ;
import android.support.annotation.NonNull ;
import android.support.v7.widget.RecyclerView ;
import android.util.Log ;
import android.view.LayoutInflater ;
import android.view.View ;
import android.view.ViewGroup ;
import android.widget.RatingBar ;
import android.widget.TextView ;
import android.widget.Toast ;

import java.util.ArrayList ;
import java.util.Collections;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> /*implements ItemTouchHelperAdapter*/ {

    //List of Animals that will be populated into the recycler view
    ArrayList<Animals> animalsArrayList ;

    //Constructor for the Adapter
    public MyRecyclerViewAdapter(ArrayList<Animals> animalsArrayList) {
        this.animalsArrayList = animalsArrayList ;
    }


    public void addAnimalToList(Animals animals) {
        animalsArrayList.add(animals) ;
        notifyDataSetChanged() ;
    }



    /*
    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mItems, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mItems, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }
    */






    private String additionalInfo(Animals passAnimals) {
        StringBuilder sb = new StringBuilder() ;
        if(passAnimals.isHerbivore()) {
            sb.append(" CAN EAT LETTUCE ! ") ;
        }
        return sb.toString() ;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ani_item, viewGroup, false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        Animals currentAnimalsBeingPopulated = animalsArrayList.get(position) ;
        viewHolder.tvAniType.setText(currentAnimalsBeingPopulated.getAnimalType()) ;
        viewHolder.tvAniName.setText(currentAnimalsBeingPopulated.getAnimalName()) ;
        viewHolder.tvAniSound.setText(currentAnimalsBeingPopulated.getAnimalSound()) ;
        viewHolder.rtAniRating.setRating(currentAnimalsBeingPopulated.getRating()) ;

        Log.d("TAG", "onBindViewHolder: item being rendered = " + position) ;


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), animalsArrayList.get(position).getAnimalName() + "clicked", Toast.LENGTH_SHORT).show() ;


                Bundle bundle = new Bundle() ;
                bundle.putParcelable("ani", animalsArrayList.get(position)) ;
                Intent intentToStartDetails = new Intent(v.getContext(), DetailActivity.class) ;
                intentToStartDetails.putExtras(bundle) ;
                v.getContext().startActivity(intentToStartDetails) ;
            }

        });


    }

    @Override
    public int getItemCount() {
        return animalsArrayList.size() ;
    }


    //View Holder is a inner class view container. This container holds the views that we will use for each item.

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAniType, tvAniName, tvAniSound ;
        RatingBar rtAniRating ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView) ;
            tvAniType = itemView.findViewById(R.id.tvAniType) ;
            tvAniName = itemView.findViewById(R.id.tvAniName) ;
            tvAniSound = itemView.findViewById(R.id.tvAniSound) ;
            rtAniRating = itemView.findViewById(R.id.rtRating) ;
        }
    }




}