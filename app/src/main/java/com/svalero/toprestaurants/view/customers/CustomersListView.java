package com.svalero.toprestaurants.view.customers;

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
import com.svalero.toprestaurants.adapter.CustomerAdapter;
import com.svalero.toprestaurants.contract.CustomersListContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.presenter.CustomersListPresenter;

import java.util.ArrayList;
import java.util.List;

public class CustomersListView extends AppCompatActivity implements CustomersListContract.View {

    private List<Customer> customersList;
    private CustomerAdapter adapter;
    private CustomersListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_list_view);

        presenter = new CustomersListPresenter(this);

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        customersList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.customers_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CustomerAdapter(this, customersList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllCustomers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_cust, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.register_customer) {
            Intent intent = new Intent(this, RegisterCustomerActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showCustomers(List<Customer> customers) {
        customersList.clear();
        customersList.addAll(customers);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {

    }
}