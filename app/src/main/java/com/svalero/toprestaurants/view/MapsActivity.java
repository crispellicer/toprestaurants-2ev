package com.svalero.toprestaurants.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.MapView;
import com.mapbox.maps.plugin.annotation.AnnotationConfig;
import com.mapbox.maps.plugin.annotation.AnnotationPlugin;
import com.mapbox.maps.plugin.annotation.AnnotationPluginImplKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManagerKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions;
import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.contract.restaurants.RestaurantsListContract;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.presenter.restaurants.RestaurantsListPresenter;

import java.util.List;

public class MapsActivity extends AppCompatActivity implements RestaurantsListContract.View {

    private MapView mapView;
    private PointAnnotationManager pointAnnotationManager;

    private RestaurantsListPresenter restaurantsListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapView = findViewById(R.id.mapView);
        initializePointManager();

        restaurantsListPresenter = new RestaurantsListPresenter(this);
        restaurantsListPresenter.loadAllRestaurants();
    }

    private void addRestaurantsToMap(List<Restaurant> restaurants) {
        for (Restaurant restaurant : restaurants) {
            Point point = Point.fromLngLat(restaurant.getLongitude(), restaurant.getLatitude());
            addMarker(point, restaurant.getName());
        }

        Restaurant lastRestaurant = restaurants.get(restaurants.size() - 1);
        setCameraPosition(Point.fromLngLat(lastRestaurant.getLongitude(), lastRestaurant.getLatitude()));
    }

    private void initializePointManager() {
        AnnotationPlugin annotationPlugin = AnnotationPluginImplKt.getAnnotations(mapView);
        AnnotationConfig annotationConfig = new AnnotationConfig();
        pointAnnotationManager = PointAnnotationManagerKt.createPointAnnotationManager(annotationPlugin, annotationConfig);
    }

    private void addMarker(Point point, String title) {
        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions()
                .withPoint(point)
                .withTextField(title)
                .withIconImage(BitmapFactory.decodeResource(getResources(), R.mipmap.red_marker));
        pointAnnotationManager.create(pointAnnotationOptions);
    }

    private void setCameraPosition(Point point) {
        CameraOptions cameraPosition = new CameraOptions.Builder()
                .center(point)
                .pitch(0.0)
                .zoom(13.5)
                .bearing(-17.6)
                .build();
        mapView.getMapboxMap().setCamera(cameraPosition);
    }

    @Override
    public void showRestaurants(List<Restaurant> restaurants) {
        addRestaurantsToMap(restaurants);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}