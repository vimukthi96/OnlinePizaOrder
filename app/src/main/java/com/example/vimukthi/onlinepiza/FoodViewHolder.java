package com.example.vimukthi.onlinepiza;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ItemClickListner itemClickListner;
    public TextView txtFoodName;
    public ImageView imgFood;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        txtFoodName =(TextView)itemView.findViewById(R.id.foodTitle);
        imgFood =(ImageView)itemView.findViewById(R.id.foodImage);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        itemClickListner.onClick(view,getAdapterPosition(),false);

    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }
}
