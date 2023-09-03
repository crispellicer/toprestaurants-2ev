package com.svalero.toprestaurants.adapter;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.contract.restaurants.DeleteFavRestaurantContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.FavRestaurant;

import java.util.List;

public class FavRestaurantAdapter extends RecyclerView.Adapter<FavRestaurantAdapter.FavRestaurantHolder> implements DeleteFavRestaurantContract.View{

    private Context context;
    private List<FavRestaurant> favRestaurantsList;
    private FavRestaurant favRestaurant;

    public FavRestaurantAdapter(Context context, List<FavRestaurant> dataList) {
        this.context = context;
        this.favRestaurantsList = dataList;

    }

    public Context getContext() {
        return context;
    }

    @Override
    public FavRestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fav_restaurant_item, parent, false);
        return new FavRestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavRestaurantHolder holder, int position) {

        holder.restaurantName.setText(favRestaurantsList.get(position).getName());
        holder.restaurantType.setText(favRestaurantsList.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return favRestaurantsList.size();
    }

    public void showMessage(String message) {

    }

    public void showError(String errorMessage) {

    }

    public class FavRestaurantHolder extends RecyclerView.ViewHolder {

        public TextView restaurantName;
        public TextView restaurantType;
        public Button deleteFavRestaurantButton;
        public View parentView;

        public FavRestaurantHolder(View view) {
            super(view);
            parentView = view;

            restaurantName = view.findViewById((R.id.restaurant_name));
            restaurantType = view.findViewById(R.id.restaurant_type);
            deleteFavRestaurantButton = view.findViewById(R.id.delete_fav_restaurant_button);

            deleteFavRestaurantButton.setOnClickListener(v -> deleteFavRestaurant(getAdapterPosition()));
        }
    }

    private void deleteFavRestaurant(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.sure)
                .setTitle(R.string.delete_restaurant)
                .setPositiveButton(R.string.yes, (dialog, id) -> {
                    final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                            .allowMainThreadQueries().build();
                    FavRestaurant favRestaurant = favRestaurantsList.get(position);
                    db.favRestaurantDao().delete(favRestaurant);

                    favRestaurantsList.remove(position);
                    notifyItemRemoved(position);
                })
                .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
