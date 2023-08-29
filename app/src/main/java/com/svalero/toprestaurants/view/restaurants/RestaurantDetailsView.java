package com.svalero.toprestaurants.view.restaurants;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.contract.restaurants.RestaurantDetailsContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.presenter.restaurants.RestaurantDetailsPresenter;

public class RestaurantDetailsView extends AppCompatActivity implements RestaurantDetailsContract.View {

    private RestaurantDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        presenter = new RestaurantDetailsPresenter(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        if (name == null)
            return;

        presenter.loadRestaurant(name);
        //Toast.makeText(this, getString(R.string.restaurant) + " " + restaurant.getName(), Toast.LENGTH_LONG).show();

    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showRestaurant(Restaurant restaurant) {
        TextView tvName = findViewById(R.id.tv_restaurant_name_details);
        TextView tvType = findViewById(R.id.tv_restaurant_type_details);
        TextView tvTimetable = findViewById(R.id.tv_restaurant_timetable_details);
        TextView tvReservePrice = findViewById(R.id.tv_restaurant_reserveprice_details);
        CheckBox checkVeganMenu = findViewById(R.id.cb_restaurant_veganmenu_details);
        TextView tvWebsite = findViewById(R.id.tv_restaurant_website_details);

        tvName.setText(restaurant.getName());
        tvType.setText(restaurant.getType());
        tvTimetable.setText(restaurant.getTimetable());
        tvReservePrice.setText(String.valueOf(restaurant.getReservePrice()));
        checkVeganMenu.setChecked(restaurant.isVeganMenu());
        tvWebsite.setText(restaurant.getWebsite());
    }
}
