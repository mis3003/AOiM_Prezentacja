package com.example.myapplication;
import models.Contact;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/api/v1/contact")
    Call<Contact[]> getSomething();

    @DELETE("/api/v1/contact/{contactId}")
    Call<Void> deleteContact(@Path("contactId") int contactId);

    @POST("/api/v1/contact")
    Call<Void> createContact(@Body Contact contact);

    @PUT("/api/v1/contact/{contactId}")
    Call<Void> updateContact(
            @Path("contactId") int contactId,
            @Body Contact updatedContact
    );

}
