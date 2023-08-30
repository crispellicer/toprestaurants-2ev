package com.svalero.toprestaurants.view.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.contract.restaurants.ModifyRestaurantContract;
import com.svalero.toprestaurants.domain.Restaurant;

public class ModifyRestaurantView extends AppCompatActivity
    implements ModifyRestaurantContract.View{

    private long id;
    private double longitude;
    private double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_restaurant);

        Intent intent = getIntent();
        id = intent.getLongExtra("id", 0);

        //final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, DATABASE_NAME)
          //      .allowMainThreadQueries().build();
        //Restaurant restaurant = db.restaurantDao().getById(id);
        //longitude = restaurant.getLongitude();
        //latitude = restaurant.getLatitude();
        //fillData(restaurant);
    }

    public void modifyRestaurantButton(View view) {
        EditText etName = findViewById(R.id.edit_text_modify_restaurant_name);
        EditText etTimetable = findViewById(R.id.edit_text_modify_restaurant_timetable);
        EditText etType = findViewById(R.id.edit_text_modify_restaurant_type);
        EditText etReservePrice = findViewById(R.id.edit_text_modify_restaurant_reserveprice);
        CheckBox checkVeganMenu = findViewById(R.id.check_box_modify_veganmenu);
        EditText etWebsite = findViewById(R.id.edit_text_modify_restaurant_website);

        String name = etName.getText().toString();
        String timetable = etTimetable.getText().toString();
        String type = etType.getText().toString();
        String reservePriceString = etReservePrice.getText().toString();
        double reservePrice = Double.parseDouble(reservePriceString);
        boolean veganMenu = checkVeganMenu.isChecked();
        String website = etWebsite.getText().toString();

        Restaurant restaurant = new Restaurant(id, name, timetable, type, reservePrice, veganMenu, website, longitude, latitude);

        //final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, DATABASE_NAME)
          //      .allowMainThreadQueries().build();

        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.sure)
                    .setTitle(R.string.modify_restaurant)
                    .setPositiveButton(R.string.yes, (dialog, id) -> {

                        //db.restaurantDao().update(restaurant);

                        Intent intent = new Intent(this, RestaurantsListView.class);
                        intent.putExtra("id", restaurant.getId());
                        this.startActivity(intent);
                    })
                    .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());
            AlertDialog dialog = builder.create();
            dialog.show();
        } catch (SQLiteConstraintException sce) {
            Snackbar.make(etName, R.string.error_message, BaseTransientBottomBar.LENGTH_LONG);
        }
    }

    private void fillData(Restaurant restaurant) {
        EditText etName = findViewById(R.id.edit_text_modify_restaurant_name);
        EditText etTimetable = findViewById(R.id.edit_text_modify_restaurant_timetable);
        EditText etType = findViewById(R.id.edit_text_modify_restaurant_type);
        EditText etReservePrice = findViewById(R.id.edit_text_modify_restaurant_reserveprice);
        CheckBox checkVeganMenu = findViewById(R.id.check_box_modify_veganmenu);
        EditText etWebsite = findViewById(R.id.edit_text_modify_restaurant_website);

        etName.setText(restaurant.getName());
        etTimetable.setText(restaurant.getType());
        etType.setText(restaurant.getTimetable());
        etReservePrice.setText(String.valueOf(restaurant.getReservePrice()));
        checkVeganMenu.setChecked(restaurant.isVeganMenu());
        etWebsite.setText(restaurant.getWebsite());
    }

    public void cancelModifyButton(View view) {
        onBackPressed();
    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showMessage(String message) {

    }
}