package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import models.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(Context context, ArrayList<Contact> contactArrayList){
        super(context, R.layout.contact_item, contactArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Contact contact = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_item, parent,false);

        }
        TextView contactName = convertView.findViewById(R.id.personName);
        TextView contactNumber = convertView.findViewById(R.id.personNumber);

        contactName.setText(contact.getName());
        contactNumber.setText(contact.getNumber());


        return convertView;
    }
}
