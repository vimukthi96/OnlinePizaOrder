package com.example.vimukthi.onlinepiza;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

   // View mView;

    private ItemClickListner itemClickListner;
    public TextView txtMenuName;
    public ImageView imageView;


    public MenuViewHolder(final View itemView) {
        super(itemView);
       // mView = itemView;

      /*  itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListner.onItemClick(view,getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                itemClickListner.onItemLongClick(view ,getAdapterPosition());
                return true;
            }
        });*/
        txtMenuName =(TextView)itemView.findViewById(R.id.txttitle);
        imageView =(ImageView)itemView.findViewById(R.id.imgtitle);

        itemView.setOnClickListener(this);


    }
   // public void  setDetails(Context context, String Name,String Image){

      //  TextView txtTitle =mView.findViewById(R.id.txttitle);
        //ImageView imgView =mView.findViewById(R.id.imgtitle);

       // txtTitle.setText(Name);
       // Picasso.get().load(Image).into(imgView);

 //   }

    @Override
    public void onClick(View view) {

        itemClickListner.onClick(view ,getAdapterPosition(),false);
    }

  /*  public interface ItemClickListner{
        void onItemClick(View view, int position);
        void onItemLongClick(View view,int position);
    }*/
    public void setItemClickListner(ItemClickListner clickListner) {
        this.itemClickListner = clickListner;
    }
}
