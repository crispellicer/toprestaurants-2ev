package com.svalero.toprestaurants.view.restaurants;

import androidx.appcompat.app.AppCompatActivity;

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
import com.svalero.toprestaurants.contract.restaurants.RegisterRestaurantContract;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.presenter.restaurants.RegisterRestaurantPresenter;

public class RegisterRestaurantView extends AppCompatActivity implements RegisterRestaurantContract.View {

    private MapView restaurantMap;
    private Point point;
    private PointAnnotationManager pointAnnotationManager;
    private RegisterRestaurantPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_restaurant);

        presenter = new RegisterRestaurantPresenter(this);
        restaurantMap = findViewById(R.id.restaurantMap);

        GesturesPlugin gesturesPlugin = GesturesUtils.getGestures(restaurantMap);
        gesturesPlugin.addOnMapClickListener(point -> {
            removeAllMarkers();
            this.point = point;
            addMarker(point);
            return true;
        });

        initializePointManager();
    }

    public void saveButton(View view) {
        EditText etName = findViewById(R.id.edit_text_restaurant_name);
        EditText etTimetable = findViewById(R.id.edit_text_restaurant_timetable);
        EditText etType = findViewById(R.id.edit_text_restaurant_type);
        EditText etReservePrice = findViewById(R.id.edit_text_restaurant_reserveprice);
        CheckBox checkVeganMenu = findViewById(R.id.check_box_veganmenu);
        EditText etWebsite = findViewById(R.id.edit_text_restaurant_website);

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

        Restaurant restaurant = new Restaurant(name, timetable, type, reservePrice,veganMenu, website, point.longitude(), point.latitude());
        presenter.registerRestaurant(restaurant);
    }
    private void initializePointManager() {
        AnnotationPlugin annotationPlugin = AnnotationPluginImplKt.getAnnotations(restaurantMap);
        AnnotationConfig annotationConfig = new AnnotationConfig();
        pointAnnotationManager = PointAnnotationManagerKt.createPointAnnotationManager(annotationPlugin, annotationConfig);
    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    private void addMarker(Point point) {
        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions()
                .withPoint(point)
                .withIconImage(BitmapFactory.decodeResource(getResources(), R.mipmap.red_marker));
        pointAnnotationManager.create(pointAnnotationOptions);
    }

    private void removeAllMarkers() {
        pointAnnotationManager.deleteAll();
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(((EditText) findViewById(R.id.edit_text_restaurant_name)), errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(((EditText) findViewById(R.id.edit_text_restaurant_name)), message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void resetForm() {
        ((EditText) findViewById(R.id.edit_text_restaurant_name)).setText("");
        ((EditText) findViewById(R.id.edit_text_restaurant_timetable)).setText("");
        ((EditText) findViewById(R.id.edit_text_restaurant_type)).setText("");
        ((EditText) findViewById(R.id.edit_text_restaurant_reserveprice)).setText("");
        ((CheckBox) findViewById(R.id.check_box_veganmenu)).setChecked(false);
        ((EditText) findViewById(R.id.edit_text_restaurant_website)).setText("");
        ((EditText) findViewById(R.id.edit_text_restaurant_name)).requestFocus();
    }
}