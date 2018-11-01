package com.example.vimukthi.onlinepiza;

import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
   /* RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView =findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference("Category");

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<MenuItems,MenuViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<MenuItems,MenuViewHolder>(
                MenuItems.class,R.layout.meu_item,MenuViewHolder.class,databaseReference) {

            @Override
            protected void populateViewHolder(MenuViewHolder menuViewHolder, MenuItems menuItems, int position) {
                menuViewHolder.setDetails(getApplicationContext(),menuItems.getName(),menuItems.getImage());
            }

            @Override
            public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                MenuViewHolder menuViewHolder = super.onCreateViewHolder(parent,viewType);
                menuViewHolder.setClickListner(new MenuViewHolder.ItemClickListner() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                });

                return super.onCreateViewHolder(parent, viewType);
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }*/
}
