package com.svalero.toprestaurants.view.customers;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.contract.customers.CustomerDetailsContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.presenter.customers.CustomerDetailsPresenter;

public class CustomerDetailsView extends AppCompatActivity implements CustomerDetailsContract.View {

    private CustomerDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        presenter = new CustomerDetailsPresenter(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        if (name == null)
            return;

        presenter.loadCustomer(name);
        //Toast.makeText(this, getString(R.string.customer) + " " + customer.getName(), Toast.LENGTH_LONG).show();
    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showCustomer(Customer customer) {
        TextView tvName = findViewById(R.id.tv_customer_name_details);
        TextView tvSurname = findViewById(R.id.tv_customer_surname_details);
        TextView tvTelephone = findViewById(R.id.tv_customer_telephone_details);
        TextView tvBirthDate = findViewById(R.id.tv_customer_birthdate_details);
        CheckBox checkVip = findViewById(R.id.cb_customer_vip_details);

        tvName.setText(customer.getName());
        tvSurname.setText(customer.getSurname());
        tvTelephone.setText(customer.getTelephone());
        tvBirthDate.setText(customer.getBirthDate());
        checkVip.setChecked(customer.isVip());
    }
}
