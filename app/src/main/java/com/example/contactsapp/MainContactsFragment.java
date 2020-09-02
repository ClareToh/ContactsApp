package com.example.contactsapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class MainContactsFragment extends Fragment {
    private static final String LOG_TAG = "MainContactsFragment";

    private Button mAddContactsButton;
    private RecyclerView mRecyclerView;
    private ArrayList<Contact> mContactsList;
    private ArrayList<String> mKeyList;
    private ContactsAdapter mAdapter;

    private ProgressDialog pDialog;


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

        //Show only mAddContactsButton
        ((MainActivity) getActivity()).findViewById(R.id.edit_button).setVisibility(View.GONE);
        ((MainActivity) getActivity()).findViewById(R.id.done_button).setVisibility(View.GONE);

        mAddContactsButton = ((MainActivity) getActivity()).findViewById(R.id.add_contact_button);
        mAddContactsButton.setVisibility(View.VISIBLE);
        mAddContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Initialize the RecyclerView and set layout manager
        mRecyclerView = view.findViewById(R.id.contactsRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mContactsList = new ArrayList<>();
        mKeyList = new ArrayList<>();

        //setAdapter
        mAdapter = new ContactsAdapter(getContext(), mContactsList, mKeyList,
                NavHostFragment.findNavController(MainContactsFragment.this));
        mRecyclerView.setAdapter(mAdapter);


        //TODO: remove and change to get actual data
        Contact egContact = new Contact("George", "Bluth", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg", 1);
        mContactsList.add(egContact);
        mContactsList.add(new Contact("Janet","Weaver","https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", 2));

            mContactsList = ContactData.getContactsArrayList();
        mAdapter.notifyDataSetChanged();

        //cannot get this to work
//            new GetJsonTask(mAdapter).execute();

    }

    private class GetJsonTask extends AsyncTask <Void, Void, Void> {
    private ContactsAdapter mAdapter;
        GetJsonTask(ContactsAdapter adapter) {
            mAdapter = adapter;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mContactsList = ContactData.getContactsArrayList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mAdapter.notifyDataSetChanged();
        }
    }
}
