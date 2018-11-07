package com.example.vimukthi.onlinepiza;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView txtOrderId,txtOrderStatus,txtOrderPhone,txtOrderAddress;
    private ItemClickListner itemClickListner;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
   /*     txtOrderId =(TextView)itemView.findViewById(R.id.orderItemId);
        txtOrderPhone =(TextView)itemView.findViewById(R.id.orderPhone);
        txtOrderStatus =(TextView)itemView.findViewById(R.id.orderStatus);
        txtOrderAddress =(TextView)itemView.findViewById(R.id.orderAddress);*/

        itemView.setOnClickListener(this);

    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View view) {

        itemClickListner.onClick(view ,getAdapterPosition(),false);

    }
}
