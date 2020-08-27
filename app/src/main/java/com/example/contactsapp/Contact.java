package com.example.contactsapp;

public class Contact {
    private String mFirstName;
    private String mLastName;
    private String mImageUrl;
    private int contactID;

    public Contact(String firstName, String lastName, String imageUrl, int contactID) {
        mFirstName = firstName;
        mLastName = lastName;
        mImageUrl = imageUrl;
        this.contactID = contactID;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }


}
