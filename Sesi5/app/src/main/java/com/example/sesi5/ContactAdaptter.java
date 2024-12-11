package com.example.sesi5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdaptter extends RecyclerView.Adapter<ContactAdaptter.ContactHolder> {
    private Context activityContext;
    private List<ContactData> contactList;

    public ContactAdaptter(List<ContactData> datacontact){
        contactList = datacontact;
    }

    @NonNull
    @Override
    public ContactAdaptter.ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activityContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(activityContext);
        View layoutView = inflater.inflate(R.layout.item_contact, parent, false);
        ContactHolder holder = new ContactHolder(layoutView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdaptter.ContactHolder holder, int position) {
        String name = contactList.get(position).getName();
        String phoneNumber = contactList.get(position).getPhoneNumber();

        holder.ItemNumberTV.setText(phoneNumber);
        holder.ItemNameTV.setText(name);

        holder.ImageItem.setImageResource(R.drawable.ic_launcher_background);

        holder.itemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri phone = Uri.parse("tel" + phoneNumber);
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(phone);

                activityContext.startActivity(phoneIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder {
        TextView ItemNameTV, ItemNumberTV;
        ImageView ImageItem;
        ConstraintLayout itemContainer;


        public ContactHolder(@NonNull View itemView) {
            super(itemView);

            ItemNameTV = itemView.findViewById(R.id.ItemNameTV);
            ImageItem = itemView.findViewById(R.id.ItemImage);
            ItemNumberTV = itemView.findViewById(R.id.ItemNumberTV);
            itemContainer = itemView.findViewById(R.id.itemContainer);
        }
    }
}
