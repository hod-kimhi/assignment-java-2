package com.example.challengetwo.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.challengetwo.R;
import com.example.challengetwo.activities.MentorInfoActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

  private ArrayList<Mentor> mentors;

  public static class ImageViewHolder extends RecyclerView.ViewHolder {
    public TextView textView_name;
    public ImageView imageView_profilePicture;

    public ImageViewHolder(CardView view) {
      super(view);

      textView_name = view.findViewById(R.id.name);
      imageView_profilePicture = view.findViewById(R.id.profilePicture);
    }
  }

  public ImageAdapter(ArrayList<Mentor> mentors) {
    this.mentors = mentors;
  }

  @NonNull
  @Override
  public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);

    ImageViewHolder viewHolder = new ImageViewHolder(view);

    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ImageAdapter.ImageViewHolder holder, int position) {
    final Mentor currentMentor = mentors.get(position);

    holder.textView_name.setText(currentMentor.name);
    holder.imageView_profilePicture.setImageResource(currentMentor.profilePicture);

    final Context context = holder.textView_name.getContext();

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(context, MentorInfoActivity.class);
        intent.putExtra("mentor", currentMentor);

        context.startActivity(intent);
      }
    });
  }

  @Override
  public int getItemCount() {
    return mentors.size();
  }
}
