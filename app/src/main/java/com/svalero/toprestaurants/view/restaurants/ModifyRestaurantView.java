package com.svalero.toprestaurants.view.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.mapbox.geojson.Point;
import com.mapbox.maps.MapView;
import com.mapbox.maps.plugin.annotation.AnnotationConfig;
import com.mapbox.maps.plugin.annotation.AnnotationPlugin;
import com.mapbox.maps.plugin.annotation.AnnotationPluginImplKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManagerKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions;
import com.mapbox.maps.plugin.gestures.GesturesPlugin;
import com.mapbox.maps.plugin.gestures.GesturesUtils;
import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.contract.restaurants.ModifyRestaurantContract;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.presenter.restaurants.ModifyRestaurantPresenter;

public class ModifyRestaurantView extends AppCompatActivity
    implements ModifyRestaurantContract.View{

    private long id;
    private double longitude;
    private double latitude;
    private Restaurant restaurant;
    private ModifyRestaurantPresenter presenter;

    private MapView restaurantMap;
    private Point point;
    private PointAnnotationManager pointAnnotationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_restaurant);

        noticeId();

        Bundle bundle = getIntent().getExtras();
        restaurant = (Restaurant) bundle.getSerializable("restaurant");
        id = restaurant.getId();

        fillData(restaurant);

        presenter = new ModifyRestaurantPresenter(this);
        restaurantMap = findViewById(R.id.restaurantMap);

        GesturesPlugin gesturesPlugin = GesturesUtils.getGestures(restaurantMap);
        gesturesPlugin.addOnMapClickListener(point -> {
            this.point = point;
            addMarker(point);
            return true;
        });

        initializePointManager();
    }

    private void initializePointManager() {
        AnnotationPlugin annotationPlugin = AnnotationPluginImplKt.getAnnotations(restaurantMap);
        AnnotationConfig annotationConfig = new AnnotationConfig();
        pointAnnotationManager = PointAnnotationManagerKt.createPointAnnotationManager(annotationPlugin, annotationConfig);
    }

    private void addMarker(com.mapbox.geojson.Point point) {
        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions()
                .withPoint(point)
                .withIconImage(BitmapFactory.decodeResource(getResources(), R.mipmap.red_marker));
        pointAnnotationManager.create(pointAnnotationOptions);
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

        if (point == null) {
            Toast.makeText(this, R.string.location_selection, Toast.LENGTH_LONG).show();
            return;
        }

        Restaurant modifiedRestaurant = new Restaurant(id, name, timetable, type, reservePrice, veganMenu, website, point.longitude(), point.latitude());
        presenter.modifyRestaurant(id, modifiedRestaurant);

        finish();
    }

    private void noticeId() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.sure)
                .setTitle(R.string.modify_restaurant)
                .setPositiveButton(R.string.no, (dialog, id) -> {


                    Intent intent = new Intent(this, RestaurantsListView.class);
                    intent.putExtra("id", restaurant.getId());
                    this.startActivity(intent);
                })
                .setNegativeButton(R.string.yes, (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
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