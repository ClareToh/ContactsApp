package com.example.contactsapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
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

    protected Contact(Parcel in) {
        mFirstName = in.readString();
        mLastName = in.readString();
        mImageUrl = in.readString();
        contactID = in.readInt();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFirstName);
        dest.writeString(mLastName);
        dest.writeString(mImageUrl);
        dest.writeInt(contactID);
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
