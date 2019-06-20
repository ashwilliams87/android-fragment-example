package com.ashwilliams87.bitsandpizzas.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashwilliams87.bitsandpizzas.PizzaDetailActivity;
import com.ashwilliams87.bitsandpizzas.R;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    private String[] captions;
    private int[] imageIds;
    private Listner listner;

    public CaptionedImagesAdapter(String[] captions, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_captioned_image, viewGroup, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        final CardView cardView = viewHolder.cardView;
        ImageView imageView = cardView.findViewById(R.id.info_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(cardView.getContext(), imageIds[position]));
        imageView.setContentDescription(captions[position]);
        TextView textView = cardView.findViewById(R.id.info_text_view);
        textView.setText(captions[position]);
        cardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(listner!=null){
                            listner.onClick(position);
                        }
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public void setListner(Listner listner) {
        this.listner = listner;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;

        ViewHolder(CardView itemView) {
            super(itemView);
            this.cardView = itemView;
        }

    }

    public interface Listner {
        void onClick(int position);
    }
}
