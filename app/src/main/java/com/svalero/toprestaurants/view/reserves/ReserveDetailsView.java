package com.svalero.toprestaurants.view.reserves;

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
import com.svalero.toprestaurants.contract.reserves.ReserveDetailsContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.domain.Reserve;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.presenter.reserves.ReserveDetailsPresenter;

public class ReserveDetailsView extends AppCompatActivity implements ReserveDetailsContract.View {

    private ReserveDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_details);

        presenter = new ReserveDetailsPresenter(this);

        Intent intent = getIntent();
        long id = intent.getLongExtra("id", 0);

        presenter.loadReserve(id);
        //Toast.makeText(this, getString(R.string.reserve) + " " + reserve.getId(), Toast.LENGTH_LONG).show();
    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showReserve(Reserve reserve, Customer customer, Restaurant restaurant) {
        TextView tvCustomerName = findViewById(R.id.tv_reserve_customername_details);
        TextView tvRestaurantName = findViewById(R.id.tv_reserve_restaurantname_details);
        TextView tvPeople = findViewById(R.id.tv_reserve_people_details);
        TextView tvTables = findViewById(R.id.tv_reserve_tables_details);
        TextView tvReserveDate = findViewById(R.id.tv_reserve_date_details);;
        CheckBox checkIsPaid = findViewById(R.id.cb_reserve_paid_details);
        CheckBox checkAllergic = findViewById(R.id.cb_reserve_allergic_details);

        tvCustomerName.setText(customer.getName());
        tvRestaurantName.setText(restaurant.getName());
        tvPeople.setText(String.valueOf(reserve.getPeople()));
        tvTables.setText(String.valueOf(reserve.getTables()));
        tvReserveDate.setText(reserve.getReserveDate());
        checkIsPaid.setChecked(reserve.isPaid());
        checkAllergic.setChecked(reserve.isAllergic());
    }
}