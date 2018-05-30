package es.pue.android.guestlist.model;

import java.io.Serializable;

public class Guest implements Serializable {
    private String name;
    private String phoneNumber;

    public Guest(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return this.getName();
    }
}
