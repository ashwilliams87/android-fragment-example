package com.ashwilliams87.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashwilliams87.bitsandpizzas.adapters.CaptionedImagesAdapter;
import com.ashwilliams87.bitsandpizzas.models.Pizza;

/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        RecyclerView pizzaRecylerView = (RecyclerView) inflater.inflate(R.layout.fragment_pizza, container, false);

        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int[Pizza.pizzas.length];

        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecylerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecylerView.setLayoutManager(layoutManager);

        adapter.setListner(
                new CaptionedImagesAdapter.Listner() {
                    @Override
                    public void onClick(int position) {
                        FragmentActivity activity = getActivity();
                        Intent intent = new Intent(activity, PizzaDetailActivity.class);
                        intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                        assert activity != null;
                        activity.startActivity(intent);
                    }
                }

        );

        return pizzaRecylerView;

    }

}
