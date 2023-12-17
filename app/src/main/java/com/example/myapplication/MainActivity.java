package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

import models.Contact;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<Contact> contacts = new ArrayList<>();
    Contact[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ApiClient.executeGetRequest("value1", "value2", new Callback<Contact[]>() {
            @Override
            public void onResponse(Call<Contact[]> call, retrofit2.Response<Contact[]> response) {
                if (response.isSuccessful()) {
                    data = response.body();
                    contacts.addAll(Arrays.asList(data));
                    ContactAdapter adapter = new ContactAdapter(MainActivity.this, contacts);
                    binding.listView.setAdapter(adapter);
                    System.out.println("Sukces");

                } else {
                    System.out.println("Bład");
                }
            }

            @Override
            public void onFailure(Call<Contact[]> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ContactInfo.class);
                i.putExtra("contact", contacts.get(position));
                startActivity(i);

            }
        });

    }

    public void onAddButtonClick(View view) {
        Intent i = new Intent(MainActivity.this, ContactAdd.class);
        startActivity(i);
    }

}