package com.svalero.toprestaurants.adapter;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.toprestaurants.contract.customers.DeleteCustomerContract;
import com.svalero.toprestaurants.presenter.customers.DeleteCustomerPresenter;
import com.svalero.toprestaurants.view.customers.ModifyCustomerView;
import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.domain.Customer;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerHolder>
        implements DeleteCustomerContract.View {

    private Context context;
    private List<Customer> customersList;
    private View snackBarView;
    private DeleteCustomerPresenter presenter;

    public CustomerAdapter(Context context, List<Customer> dataList) {
        this.context = context;
        this.customersList = dataList;
        presenter = new DeleteCustomerPresenter(this);
    }

    @Override
    public CustomerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer_item, parent, false);
        return new CustomerHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomerHolder holder, int position) {
        holder.customerName.setText(customersList.get(position).getName());
        holder.customerSurname.setText(customersList.get(position).getSurname());
    }

    @Override
    public int getItemCount() {
        return customersList.size();
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(snackBarView, errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(snackBarView, message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    public class CustomerHolder extends RecyclerView.ViewHolder{

        public TextView customerName;
        public TextView customerSurname;
        public Button customerDetailsButton;
        public Button modifyCustomerButton;
        public Button deleteCustomerButton;
        public View parentView;

        public CustomerHolder(View view) {
            super(view);
            parentView = view;
            snackBarView = parentView;

            customerName = view.findViewById(R.id.customer_name);
            customerSurname = view.findViewById(R.id.customer_surname);
            customerDetailsButton = view.findViewById(R.id.customer_details_button);
            modifyCustomerButton = view.findViewById(R.id.modify_customer_button);
            deleteCustomerButton = view.findViewById(R.id.delete_customer_button);

            //customerDetailsButton.setOnClickListener(v -> seeDetails(getAdapterPosition()));
            modifyCustomerButton.setOnClickListener(v -> modifyCustomer(getAdapterPosition()));
            deleteCustomerButton.setOnClickListener(v -> deleteCustomer(getAdapterPosition()));
        }
    }

//    private void seeDetails(int position) {
//        Customer customer = customersList.get(position);
//
//        Intent intent = new Intent(context, CustomerDetailsView.class);
//        intent.putExtra("name", customer.getName());
//        context.startActivity(intent);
//    }

    private void modifyCustomer(int position){
        Customer customer = customersList.get(position);

        Intent intent = new Intent(context, ModifyCustomerView.class);
        intent.putExtra("customer", customer);
        context.startActivity(intent);
    }

    private void deleteCustomer(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.sure)
                .setTitle(R.string.delete_customer)
                .setPositiveButton(R.string.yes, (dialog, id) -> {
                    Customer customer = customersList.get(position);
                    presenter.deleteCustomer(customer.getId());

                    customersList.remove(position);
                    notifyItemRemoved(position);
                })
                .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
