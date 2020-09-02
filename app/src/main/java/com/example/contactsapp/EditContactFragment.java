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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditContactFragment extends Fragment {
    private Button mDoneButton;
    private Contact mSelectedContact;

    private ImageView mImageView;
    private TextView mContactIDTextView;
    private TextView mFirstNameTextView;
    private TextView mLastNameTextView;


    public  EditContactFragment() {
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

        //Show only done button
        ((MainActivity) getActivity()).findViewById(R.id.add_contact_button).setVisibility(View.GONE);
        ((MainActivity) getActivity()).findViewById(R.id.edit_button).setVisibility(View.GONE);

        mDoneButton = ((MainActivity) getActivity()).findViewById(R.id.done_button);
        mDoneButton.setVisibility(View.VISIBLE);
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the data to backend
                //Go back to main page after complete
                NavController navController = NavHostFragment.findNavController(EditContactFragment.this);
                navController.navigate(EditContactFragmentDirections.actionEditContactFragmentToMainContactsFragment());

            }
        });

        //Views for contact details
        mImageView = view.findViewById(R.id.edit_contact_imageView);
        mContactIDTextView = view.findViewById(R.id.edit_contactID_value_textView);
        mFirstNameTextView = view.findViewById(R.id.edit_contact_firstName_EditText);
        mLastNameTextView = view.findViewById(R.id.edit_contact_lastName_editText);;

        //get data from previous fragment
        mSelectedContact = EditContactFragmentArgs.fromBundle(getArguments()).getSelectedContact();

        Glide.with(this.getContext())
                .load(mSelectedContact.getImageUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(mImageView);

        mContactIDTextView.setText(""+mSelectedContact.getContactID());
        mFirstNameTextView.setText(mSelectedContact.getFirstName());
        mLastNameTextView.setText(mSelectedContact.getLastName());
    }
}
