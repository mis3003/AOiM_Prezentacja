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


public class ContactAdd extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText number;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.nameText);

        email = findViewById(R.id.emailText);
        number = findViewById(R.id.phoneText);
    }

    public void onSaveButtonClick(View view){


        if(name.getText().toString().isEmpty())
        {
            Toast toast=new Toast(this);
            toast.setText("Wprowadź nazwę");
            toast.show();
        }
        else {
            if(number.getText().length()==9)
            {
                Contact contact = new Contact(1, name.getText().toString(), number.getText().toString(), email.getText().toString());
                ApiClient.executePostRequest(contact, new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
            else
            {
                Toast toast=new Toast(this);
                toast.setText("Dane nie są poprawne");
                toast.show();

            }
        }


    }


}
