package com.example.mystars.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mystars.R;
import com.example.mystars.models.Celebrity;
import com.example.mystars.services.CelebrityService;
import java.util.ArrayList;
import java.util.List;

public class CelebrityAdapter extends RecyclerView.Adapter<CelebrityAdapter.ViewHolder> implements Filterable {

    private final List<Celebrity> originalList;
    private List<Celebrity> filteredList;
    private final Context context;

    public CelebrityAdapter(Context context, List<Celebrity> list) {
        this.context = context;
        this.originalList = new ArrayList<>(list);
        this.filteredList = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_celebrity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Celebrity celebrity = filteredList.get(position);
        holder.name.setText(celebrity.getName().toUpperCase());
        holder.rating.setRating(celebrity.getRating());
        // Chargement local de l'image
        holder.image.setImageResource(celebrity.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            int pos = holder.getBindingAdapterPosition();
            if (pos != RecyclerView.NO_POSITION) {
                showRatingDialog(celebrity, pos);
            }
        });
    }

    private void showRatingDialog(Celebrity celebrity, int position) {
        View popupView = LayoutInflater.from(context).inflate(R.layout.dialog_rating, null);
        ImageView img = popupView.findViewById(R.id.dialogImg);
        RatingBar ratingBar = popupView.findViewById(R.id.dialogRating);

        img.setImageResource(celebrity.getImageResId());
        ratingBar.setRating(celebrity.getRating());

        new AlertDialog.Builder(context)
                .setTitle("Modifier la note")
                .setMessage("Choisissez une nouvelle note")
                .setView(popupView)
                .setPositiveButton("Enregistrer", (dialog, which) -> {
                    float newRating = ratingBar.getRating();
                    celebrity.setRating(newRating);
                    CelebrityService.getInstance().update(celebrity);
                    notifyItemChanged(position);
                })
                .setNegativeButton("Annuler", null)
                .show();
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Celebrity> result = new ArrayList<>();
                if (constraint == null || constraint.length() == 0) {
                    result.addAll(originalList);
                } else {
                    String pattern = constraint.toString().toLowerCase().trim();
                    for (Celebrity c : originalList) {
                        if (c.getName().toLowerCase().contains(pattern)) {
                            result.add(c);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = result;
                results.count = result.size();
                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (List<Celebrity>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        RatingBar rating;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgCelebrity);
            name = itemView.findViewById(R.id.tvName);
            rating = itemView.findViewById(R.id.ratingBar);
        }
    }
}