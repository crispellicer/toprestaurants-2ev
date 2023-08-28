package com.svalero.toprestaurants.view.reserves;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.adapter.ReserveAdapter;
import com.svalero.toprestaurants.adapter.RestaurantAdapter;
import com.svalero.toprestaurants.contract.ReservesListContract;
import com.svalero.toprestaurants.contract.RestaurantsListContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.Reserve;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.presenter.ReservesListPresenter;
import com.svalero.toprestaurants.presenter.RestaurantsListPresenter;

import java.util.ArrayList;
import java.util.List;

public class ReservesListView extends AppCompatActivity implements ReservesListContract.View{
    private List<Reserve> reservesList;
    private ReserveAdapter adapter;
    private ReservesListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserves_list_view);

        presenter = new ReservesListPresenter(this);

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        reservesList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.reserves_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ReserveAdapter(this, reservesList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllReserves();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_reserv, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.register_reserve) {
            Intent intent = new Intent(this, RegisterReserveActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showReserves(List<Reserve> reserves) {
        reservesList.clear();
        reservesList.addAll(reserves);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {

    }
}