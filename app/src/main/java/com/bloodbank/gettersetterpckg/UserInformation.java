package com.bloodbank.gettersetterpckg;

/**
 * Created by User on 4/21/2018.
 */

public class UserInformation {
    String uid;
    String fistName;
    String lastName;
    String email;
    String password;
    String bloodGroup;

    public UserInformation() {
    }

    public UserInformation(String uid, String fistName, String lastName, String email, String password, String bloodGroup) {
        this.uid = uid;
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bloodGroup = bloodGroup;
    }

    public String getUid() {
        return uid;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }


    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
