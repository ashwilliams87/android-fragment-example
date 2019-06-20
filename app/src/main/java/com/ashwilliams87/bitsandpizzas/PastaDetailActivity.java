package com.ashwilliams87.bitsandpizzas;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashwilliams87.bitsandpizzas.models.Pasta;
import com.ashwilliams87.bitsandpizzas.models.Pizza;

public class PastaDetailActivity extends AppCompatActivity {

    public static final String EXTRA_PASTA_ID = "pastaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);


        //Set the toolbar as the activity's app bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Display details of the pizza
        Bundle extras = getIntent().getExtras();
        assert extras != null;

        int pastaId = (int) extras.get(EXTRA_PASTA_ID);
        String pastaName = Pasta.pastas[pastaId].getName();
        TextView textView = findViewById(R.id.pasta_text_view);
        textView.setText(pastaName);

        ImageView imageView = findViewById(R.id.pasta_iamge_view);
        imageView.setImageResource(Pasta.pastas[pastaId].getImageResourceId());
        imageView.setContentDescription(pastaName);
    }
}
