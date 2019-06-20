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
import com.ashwilliams87.bitsandpizzas.models.Pasta;
import com.ashwilliams87.bitsandpizzas.models.Pizza;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastaFragment extends Fragment {


    public PastaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        RecyclerView pastaRecylerView = (RecyclerView) inflater.inflate(R.layout.fragment_pasta, container, false);

        String[] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pastaImages = new int[Pasta.pastas.length];

        for (int i = 0; i < pastaImages.length; i++) {
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames, pastaImages);
        pastaRecylerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pastaRecylerView.setLayoutManager(layoutManager);

        adapter.setListner(
                new CaptionedImagesAdapter.Listner() {
                    @Override
                    public void onClick(int position) {
                        FragmentActivity activity = getActivity();
                        Intent intent = new Intent(activity, PastaDetailActivity.class);
                        intent.putExtra(PastaDetailActivity.EXTRA_PASTA_ID, position);
                        assert activity != null;
                        activity.startActivity(intent);
                    }
                }
        );


        return pastaRecylerView;
    }


}
