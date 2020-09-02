package com.example.contactsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditContactFragment extends Fragment {
    private Contact mCurrentCount;
    private Button mDoneButton;


    public EditContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Change the buttons on the app bar layout
        ((MainActivity) getActivity()).findViewById(R.id.edit_button).setVisibility(View.GONE);
        mDoneButton = ((MainActivity) getActivity()).findViewById(R.id.done_button);
        mDoneButton.setVisibility(View.VISIBLE);
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the data to backend
            }
        });

        //TODO: remove and change to get actual data from previous fragment
        Contact egContact = new Contact("George", "Bluth", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg", 1);



    }
}
