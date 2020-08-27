package com.example.contactsapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private static final String LOG_TAG = "ContactsAdapter";
    private NavController mNavController;
    private ArrayList<Contact> mContactsList;
    private ArrayList<String> mKeyList;
    private Context mContext;

    public ContactsAdapter(Context context, ArrayList<Contact> contactsList, ArrayList<String> keyList, NavController navController) {
        mNavController = navController;
        mContactsList = contactsList;
        mKeyList = keyList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_main_contacts, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact currentContact = mContactsList.get(position);
        holder.bindTo(currentContact);
    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImageView;
        private TextView mNameTextView;

         ViewHolder(View itemView) {
            super(itemView);
             itemView.setOnClickListener(this);

             mImageView = itemView.findViewById(R.id.main_contact_picture_imageview);
             mNameTextView = itemView.findViewById(R.id.main_contact_name_textview);
        }

        void bindTo(Contact currentContact) {
            Glide.with(mContext)
                    .load(currentContact.getImageUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(mImageView);

            String name = currentContact.getFirstName() + " " + currentContact.getLastName();
            mNameTextView.setText(name);

            Log.d(LOG_TAG, "name: " + name);
        }

        @Override
        public void onClick(View v) {
            //Go into view-contacts page
        }
    }

}
