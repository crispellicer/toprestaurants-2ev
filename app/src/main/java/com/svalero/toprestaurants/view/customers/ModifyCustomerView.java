package com.svalero.toprestaurants.view.customers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.contract.customers.ModifyCustomerContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.presenter.customers.ModifyCustomerPresenter;

public class ModifyCustomerView extends AppCompatActivity
        implements ModifyCustomerContract.View {

    private long id;
    private Customer customer;
    private ModifyCustomerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer);

        noticeId();

        Bundle bundle = getIntent().getExtras();
        customer = (Customer) bundle.getSerializable("customer");
        id = customer.getId();

        fillData(customer);

        presenter = new ModifyCustomerPresenter(this);
    }

    public void modifyCustomerButton (View view) {
        EditText etName = findViewById(R.id.edit_text_modify_customer_name);
        EditText etSurname = findViewById(R.id.edit_text_modify_customer_surname);
        EditText etTelephone = findViewById(R.id.edit_text_modify_customer_telephone);
        EditText etBirthDate = findViewById(R.id.edit_text_modify_customer_birthdate);
        CheckBox checkVip = findViewById(R.id.check_box_modify_vip);

        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String telephone = etTelephone.getText().toString();
        String birthDate = etBirthDate.getText().toString();
        boolean vip = checkVip.isChecked();

        Customer modifiedCustomer = new Customer(id, name, surname, telephone, birthDate, vip);
        presenter.modifyCustomer(id, modifiedCustomer);

        finish();
    }

    private void noticeId() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.sure)
                .setTitle(R.string.modify_customer)
                .setPositiveButton(R.string.no, (dialog, id) -> {

                    Intent intent = new Intent(this, CustomersListView.class);
                    intent.putExtra("id", customer.getId());
                    this.startActivity(intent);
                })
                .setNegativeButton(R.string.yes, (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void fillData(Customer customer) {
        EditText etName = findViewById(R.id.edit_text_modify_customer_name);
        EditText etSurname = findViewById(R.id.edit_text_modify_customer_surname);
        EditText etTelephone = findViewById(R.id.edit_text_modify_customer_telephone);
        EditText etBirthDate = findViewById(R.id.edit_text_modify_customer_birthdate);
        CheckBox checkVip = findViewById(R.id.check_box_modify_vip);

        etName.setText(customer.getName());
        etSurname.setText(customer.getSurname());
        etTelephone.setText(customer.getTelephone());
        etBirthDate.setText(customer.getBirthDate());
        checkVip.setChecked(customer.isVip());
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