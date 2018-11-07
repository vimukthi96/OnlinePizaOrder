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
        txtOrderId =(TextView)itemView.findViewById(R.id.orderItemId);
        txtOrderPhone =(TextView)itemView.findViewById(R.id.orderItemId);
        txtOrderStatus =(TextView)itemView.findViewById(R.id.orderItemId);
        txtOrderAddress =(TextView)itemView.findViewById(R.id.orderItemId);

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
