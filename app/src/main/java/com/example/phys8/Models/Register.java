package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

public class Register implements Parcelable {
    private String name;
    private String email;
    private String password;
    private String password_confirmation;

    protected Register(Parcel in) {
        name = in.readString();
        email = in.readString();
        password = in.readString();
        password_confirmation = in.readString();
    }

    public static final Creator<Register> CREATOR = new Creator<Register>() {
        @Override
        public Register createFromParcel(Parcel in) {
            return new Register(in);
        }

        @Override
        public Register[] newArray(int size) {
            return new Register[size];
        }
    };

    public static Register objectFromData(String str) {

        return new Gson().fromJson(str, Register.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeString(password_confirmation);
    }
}
