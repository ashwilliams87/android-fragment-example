package com.ashwilliams87.bitsandpizzas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashwilliams87.bitsandpizzas.models.Pizza;


public class PizzaDetailActivity extends AppCompatActivity {

    public static final String EXTRA_PIZZA_ID = "pizzaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        //Set the toolbar as the activity's app bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Display details of the pizza
        Bundle extras = getIntent().getExtras();
        assert extras != null;

        int pizzaId = (int) extras.get(EXTRA_PIZZA_ID);
        String pizzaName = Pizza.pizzas[pizzaId].getName();
        TextView textView = findViewById(R.id.pizza_text_view);
        textView.setText(pizzaName);

        ImageView imageView = findViewById(R.id.pizza_iamge_view);
        imageView.setImageResource(Pizza.pizzas[pizzaId].getImageResourceId());
        imageView.setContentDescription(pizzaName);
    }

}