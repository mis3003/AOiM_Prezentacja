package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import models.Contact;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactInfo extends AppCompatActivity {

    Contact contact;
    ActivityMainBinding binding;
    Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_information);

        intent = this.getIntent();
        TextView name = findViewById(R.id.nameTextView);
        TextView email = findViewById(R.id.emailTextView);
        TextView number = findViewById(R.id.phoneTextView);

        if(intent != null){
            contact = (Contact) getIntent().getSerializableExtra("contact") ;

            name.setText(contact.getName());
            email.setText(contact.getEmail());
            number.setText(contact.getNumber());
        }

    }

    public void onEditButtonClick(View view){

        Intent i = new Intent(ContactInfo.this, ContactEdit.class);
        i.putExtra("contact", contact);
        startActivity(i);

    }
    public void onDeleteButtonClick(View view){
        System.out.println(contact.getId());
        ApiClient.executeDeleteRequest(contact.getId(), new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("pomyślnie usunięto");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("nie usunięto");
            }
        });

        Intent i = new Intent(ContactInfo.this, MainActivity.class);
        startActivity(i);
    }


}
