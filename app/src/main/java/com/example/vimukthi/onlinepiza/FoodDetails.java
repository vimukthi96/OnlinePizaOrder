package com.example.vimukthi.onlinepiza;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FoodDetails extends AppCompatActivity {

    TextView foodName,foodPrice,foodDescription;
    ImageView foodImage;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String FoodId;
    FirebaseDatabase database;
    DatabaseReference foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        database=FirebaseDatabase.getInstance();
        foods=database.getReference("Food");
/*
        numberButton=(ElegantNumberButton)findViewById(R.id.numberBtn);
        btnCart=(FloatingActionButton)findViewById(R.id.floatBtn);

        foodDescription=(TextView)findViewById(R.id.foodDescription);
        foodPrice=(TextView)findViewById(R.id.foodPrice);
        foodName=(TextView)findViewById(R.id.foodName);
        foodImage=(ImageView) findViewById(R.id.foodImage);

        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        if (getIntent() !=null){
            FoodId =getIntent().getStringExtra("FoodId");
        }
        if(!FoodId.isEmpty()){
            getDetailFood(FoodId);

        }*/
    }

    private void getDetailFood(final String foodId) {
        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Food food =dataSnapshot.getValue(Food.class);
                Picasso.with(getBaseContext()).load(food.getImage())
                        .into(foodImage);
                collapsingToolbarLayout.setTitle(food.getName());
                foodPrice.setText(food.getPrice());
                foodDescription.setText(food.getDescription());
                foodName.setText(food.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
