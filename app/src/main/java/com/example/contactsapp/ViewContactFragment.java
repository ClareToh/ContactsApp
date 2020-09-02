package com.example.contactsapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
public class ViewContactFragment extends Fragment {
    private Contact mCurrentContact;
    private ImageView mImageView;
    private TextView mNameTextView;
    private TextView mContactIDTextView;
    private Button mEditButton;

    public ViewContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_contact, container, false);
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Change the buttons on the app bar layout
        ((MainActivity) getActivity()).findViewById(R.id.add_contact_button).setVisibility(View.GONE);
        mEditButton = ((MainActivity) getActivity()).findViewById(R.id.edit_button);
        mEditButton.setVisibility(View.VISIBLE);
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = NavHostFragment.findNavController(ViewContactFragment.this);
                navController.navigate(ViewContactFragmentDirections.actionViewContactFragmentToEditContactFragment());
            }
        });


        //Views for contact details
        mImageView = view.findViewById(R.id.view_contact_imageView);
        mNameTextView = view.findViewById(R.id.view_contact_name_imageView);
        mContactIDTextView = view.findViewById(R.id.view_contactID_value_textView);

        //TODO: remove and change to get actual data
        mCurrentContact = new Contact("George", "Bluth", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg", 1);

        Glide.with(this.getContext())
                .load(mCurrentContact.getImageUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(mImageView);

        String name = mCurrentContact.getFirstName() + " " + mCurrentContact.getLastName();
        mNameTextView.setText(name);
        mContactIDTextView.setText("" + mCurrentContact.getContactID());
    }
}
