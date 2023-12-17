package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import models.Contact;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ContactEdit extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText number;

    Contact contact;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent i = this.getIntent();

        name = findViewById(R.id.nameEditText);
        email = findViewById(R.id.emailEditText);
        number = findViewById(R.id.phoneEditText);


        contact = (Contact) getIntent().getSerializableExtra("contact");

        name.setText(contact.getName());
        email.setText(contact.getEmail());
        number.setText(contact.getNumber());
    }

    public void onSaveButtonClick(View view) {


        if(name.getText().toString().isEmpty())
        {
            Toast toast=new Toast(this);
            toast.setText("Wprowadź nazwę");
            toast.show();
        }
else
        {
            contact.setName(name.getText().toString());
            contact.setEmail(email.getText().toString());
            contact.setNumber(number.getText().toString());
            if (number.getText().length() == 9) {



                ApiClient.executeUpdateRequest(contact.getId(), contact, new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            } else{
                Toast toast=new Toast(this);
                toast.setText("Dane nie są poprawne");
                toast.show();
            }
        }

    }

}
