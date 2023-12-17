package com.example.myapplication;
import models.Contact;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://10.0.2.2:8080";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static ApiService apiService = retrofit.create(ApiService.class);

    public static void executeGetRequest(String param1, String param2, Callback<Contact[]> callback) {
        Call<Contact[]> call = apiService.getSomething();
        call.enqueue(callback);
    }
    public static void executeDeleteRequest(int contactId, Callback<Void> callback) {
        Call<Void> call = apiService.deleteContact(contactId);
        call.enqueue(callback);
    }
    public static void executePostRequest(Contact contact, Callback<Void> callback) {
        Call<Void> call = apiService.createContact(contact);
        call.enqueue(callback);
    }

    public static void executeUpdateRequest(int contactId, Contact updatedContact, Callback<Void> callback) {
        Call<Void> call = apiService.updateContact(contactId, updatedContact);
        call.enqueue(callback);
    }

}
