package com.svalero.toprestaurants.view.reserves;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.adapter.ReserveAdapter;
import com.svalero.toprestaurants.contract.reserves.ReservesListContract;
import com.svalero.toprestaurants.domain.Reserve;
import com.svalero.toprestaurants.presenter.reserves.ReservesListPresenter;

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
            Intent intent = new Intent(this, RegisterReserveView.class);
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