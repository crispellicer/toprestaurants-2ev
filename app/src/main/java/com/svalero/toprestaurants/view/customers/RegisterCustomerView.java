package com.svalero.toprestaurants.view.customers;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.contract.customers.RegisterCustomerContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.presenter.customers.RegisterCustomerPresenter;

public class RegisterCustomerView extends AppCompatActivity implements RegisterCustomerContract.View {

    private int SELECT_PICTURE_RESULT = 1;
    private int REQUEST_IMAGE_CAPTURE = 2;
    private RegisterCustomerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);

        presenter = new RegisterCustomerPresenter(this);
    }

    public void saveButton(View view) {
        EditText etName = findViewById(R.id.edit_text_customer_name);
        EditText etSurname = findViewById(R.id.edit_text_customer_surname);
        EditText etTelephone = findViewById(R.id.edit_text_customer_telephone);
        EditText etBirthDate = findViewById(R.id.edit_text_customer_birthdate);
        CheckBox checkVip = findViewById(R.id.check_box_vip);

        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        String telephone = etTelephone.getText().toString();
        String birthDate = etBirthDate.getText().toString();
        boolean vip = checkVip.isChecked();

        Customer customer = new Customer(name, surname, telephone, birthDate, vip);
        presenter.registerCustomer(customer);

    }

    public void selectPicture(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.select_option)
                .setPositiveButton(R.string.take_photo,
                        (dialog, which) -> {
                            int result = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                            if (result != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
                            }


                            Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (takePhotoIntent.resolveActivity(getPackageManager()) != null) {
                                startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE);
                            }
                        })
                .setNegativeButton(R.string.choose_picture,
                        (dialog, which) -> {
                            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(intent, SELECT_PICTURE_RESULT);
                        }
                );
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == SELECT_PICTURE_RESULT) && (resultCode == RESULT_OK)
                && (data != null)) {
            Picasso.get().load(data.getData()).noPlaceholder().centerCrop().fit()
                    .into((ImageView) findViewById(R.id.customer_image));
        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = findViewById(R.id.customer_image);
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(((EditText) findViewById(R.id.edit_text_customer_name)), errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(((EditText) findViewById(R.id.edit_text_customer_name)), message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void resetForm() {
        ((EditText) findViewById(R.id.edit_text_customer_name)).setText("");
        ((EditText) findViewById(R.id.edit_text_customer_surname)).setText("");
        ((EditText) findViewById(R.id.edit_text_customer_telephone)).setText("");
        ((EditText) findViewById(R.id.edit_text_customer_birthdate)).setText("");
        ((CheckBox) findViewById(R.id.check_box_vip)).setChecked(false);
        ((EditText) findViewById(R.id.edit_text_customer_name)).requestFocus();
    }
}