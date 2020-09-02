package com.example.contactsapp;
import android.util.Log;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.net.*;


//this class retrieves and updates the data to backend
public class ContactData {
    private static final String LOG_TAG = "MainContactsFragment";

    public static ArrayList<Contact> getContactsArrayList () {
        ArrayList<Contact> ContactsArrayList = new ArrayList<>();;
        try {
            URL url = new URL("https://reqres.in/api/users?per_page=10");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

//            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JSONObject contactListJson = new JSONObject(content.toString());
            JSONArray contactArrayJson = contactListJson.getJSONArray("data");

            int num = 0;
            while(num < contactArrayJson.length()){
                JSONObject contactJson = contactArrayJson.getJSONObject(num);
                String imageUrl =  contactJson.getString("avatar");
                int contactId =  Integer.parseInt(contactJson.getString("id"));
                String firstName =  contactJson.getString("first_name");
                String lastName =  contactJson.getString("last_name");
                Contact newContact = new Contact(firstName, lastName, imageUrl, contactId);
                ContactsArrayList.add(newContact);


                Log.d(LOG_TAG, content.toString());

            }



        } catch (Exception e) {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter= new PrintWriter(writer);
            e.printStackTrace(printWriter);
            Log.d(LOG_TAG, writer.toString());
        }

        return ContactsArrayList;
    }







}
