package itacademy.kg.travelblogapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.TravelHolder> {
    private ArrayList<Travel> travelArrayList;
    private TravelClickListener listener;
    public void setTravelClickListener(TravelClickListener listener){
        this.listener = listener;
    }

    public static class TravelHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title, description, tags;
        public TravelHolder(@NonNull View itemView, TravelClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.titleTravel);
            description = itemView.findViewById(R.id.descriptions);
            tags = itemView.findViewById(R.id.tags);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onClickItem(position);
                }
            });

        }
    }
    public TravelAdapter(ArrayList<Travel> goods){
        this.travelArrayList = goods;
    }
    @NonNull
    @Override
    public TravelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TravelHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelHolder holder, int position) {
        Travel currentItem = travelArrayList.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescriptions());
        holder.tags.setText(currentItem.getTags());
    }





    @Override
    public int getItemCount() {
        return travelArrayList.size();
    }
}
