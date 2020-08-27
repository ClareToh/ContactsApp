package com.example.contactsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MainContactsFragment extends Fragment {
    private static final String LOG_TAG = "MainContactsFragment";

    private RecyclerView mRecyclerView;
    private ArrayList<Contact> mContactsList;
    private ArrayList<String> mKeyList;
    private ContactsAdapter mAdapter;


    public MainContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_contacts, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Contact egContact = new Contact("George", "Bluth", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg", 1);

        //Initialize the RecyclerView and set layout manager
        mRecyclerView = view.findViewById(R.id.contactsRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mContactsList = new ArrayList<>();
        mKeyList = new ArrayList<>();

        //setAdapter
        mAdapter = new ContactsAdapter(getContext(), mContactsList, mKeyList,
                NavHostFragment.findNavController(MainContactsFragment.this));
        mRecyclerView.setAdapter(mAdapter);

        mContactsList.add(egContact);
        mContactsList.add(new Contact("Janet","Weaver","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", 2));
        mAdapter.notifyDataSetChanged();
    }
}
