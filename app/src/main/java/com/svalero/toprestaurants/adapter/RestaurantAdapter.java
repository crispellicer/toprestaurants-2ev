package com.svalero.toprestaurants.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.toprestaurants.contract.restaurants.DeleteRestaurantContract;
import com.svalero.toprestaurants.domain.FavRestaurant;
import com.svalero.toprestaurants.presenter.restaurants.AddFavRestaurantPresenter;
import com.svalero.toprestaurants.presenter.restaurants.DeleteRestaurantPresenter;
import com.svalero.toprestaurants.view.restaurants.ModifyRestaurantView;
import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.domain.Restaurant;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder>
        implements DeleteRestaurantContract.View{

    private Context context;
    private List<Restaurant> restaurantsList;
    private View snackBarView;
    private DeleteRestaurantPresenter presenter;
    private AddFavRestaurantPresenter favRestaurantPresenter;

    public RestaurantAdapter(Context context, List<Restaurant> dataList) {
        this.context = context;
        this.restaurantsList = dataList;
        presenter = new DeleteRestaurantPresenter(this);
        favRestaurantPresenter = new AddFavRestaurantPresenter(this);
    }

    public Context getContext() {
        return context;
    }

    @Override
    public RestaurantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_item, parent, false);
        return new RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantHolder holder, int position) {
        holder.restaurantName.setText(restaurantsList.get(position).getName());
        holder.restaurantType.setText(restaurantsList.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(snackBarView, errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(snackBarView, message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    public class RestaurantHolder extends RecyclerView.ViewHolder{

        public TextView restaurantName;
        public TextView restaurantType;
        public Button addFavRestaurantButton;
        public Button modifyRestaurantButton;
        public Button deleteRestaurantButton;
        public View parentView;

        public RestaurantHolder(View view) {
            super(view);
            parentView = view;
            snackBarView = parentView;

            restaurantName = view.findViewById(R.id.restaurant_name);
            restaurantType = view.findViewById(R.id.restaurant_type);
            addFavRestaurantButton = view.findViewById(R.id.add_fav_restaurant_button);
            modifyRestaurantButton = view.findViewById(R.id.modify_restaurant_button);
            deleteRestaurantButton = view.findViewById(R.id.delete_restaurant_button);

            addFavRestaurantButton.setOnClickListener(v -> addFavRestaurant(getAdapterPosition()));
            modifyRestaurantButton.setOnClickListener(v -> modifyRestaurant(getAdapterPosition()));
            deleteRestaurantButton.setOnClickListener(v -> deleteRestaurant(getAdapterPosition()));
        }
    }

    private void addFavRestaurant(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you wnat to add to favourites?")
                .setTitle("Add to Favourites")
                .setPositiveButton("Yes", (dialog, id) -> {
                    Restaurant restaurant = restaurantsList.get(position);

                    FavRestaurant favRestaurant = new FavRestaurant();
                    favRestaurant.setName(restaurant.getName());
                    favRestaurant.setTimetable(restaurant.getTimetable());
                    favRestaurant.setType(restaurant.getType());
                    favRestaurant.setReservePrice(restaurant.getReservePrice());
                    favRestaurant.setVeganMenu(restaurant.isVeganMenu());
                    favRestaurant.setWebsite(restaurant.getWebsite());
                    favRestaurant.setLongitude(restaurant.getLongitude());
                    favRestaurant.setLatitude(restaurant.getLatitude());

                    favRestaurantPresenter.addFavRestaurant(favRestaurant);
                })
                .setNegativeButton("No", (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void modifyRestaurant(int position){
        Restaurant restaurant = restaurantsList.get(position);

        Intent intent = new Intent(context, ModifyRestaurantView.class);
        intent.putExtra("restaurant", restaurant);
        context.startActivity(intent);
    }

    private void deleteRestaurant(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.sure)
                .setTitle(R.string.delete_restaurant)
                .setPositiveButton(R.string.yes, (dialog, id) -> {
                    Restaurant restaurant = restaurantsList.get(position);
                    presenter.deleteRestaurant(restaurant.getId());

                    restaurantsList.remove(position);
                    notifyItemRemoved(position);
                })
                .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
