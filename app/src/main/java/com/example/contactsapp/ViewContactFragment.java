package com.example.contactsapp;

import android.os.Bundle;

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
    private Button mEditButton;

    private Contact mSelectedContact;
    private ImageView mImageView;
    private TextView mNameTextView;
    private TextView mContactIDTextView;


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
        ((MainActivity) getActivity()).findViewById(R.id.done_button).setVisibility(View.GONE);

        mEditButton = ((MainActivity) getActivity()).findViewById(R.id.edit_button);
        mEditButton.setVisibility(View.VISIBLE);
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavController navController = NavHostFragment.findNavController(ViewContactFragment.this);
                navController.navigate(ViewContactFragmentDirections.actionViewContactFragmentToEditContactFragment(mSelectedContact));


            }
        });


        //Views for contact details
        mImageView = view.findViewById(R.id.view_contact_imageView);
        mNameTextView = view.findViewById(R.id.view_contact_name_imageView);
        mContactIDTextView = view.findViewById(R.id.view_contactID_value_textView);

        //get data from previous fragment
        mSelectedContact = ViewContactFragmentArgs.fromBundle(getArguments()).getSelectedContact();

        Glide.with(this.getContext())
                .load(mSelectedContact.getImageUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(mImageView);

        String name = mSelectedContact.getFirstName() + " " + mSelectedContact.getLastName();
        mNameTextView.setText(name);
        mContactIDTextView.setText("" + mSelectedContact.getContactID());
    }
}
