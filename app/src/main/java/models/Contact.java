package models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Contact implements Serializable {
    public Contact(int id , String name, String number, String email) {
        this.id=id;
        this.name = name;
        this.number = number;
        this.email = email;
    }

    int id;
    @SerializedName("name")
    private String name;
    @SerializedName("number")
    private String number;
    @SerializedName("email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
