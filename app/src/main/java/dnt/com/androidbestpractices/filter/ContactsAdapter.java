package dnt.com.androidbestpractices.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import dnt.com.androidbestpractices.R;

/**
 * Created by sir.dnt@gmail.com on 2019-04-24.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> implements Filterable {

    private static final String TAG = ContactsAdapter.class.getSimpleName();

    private Context mContext;
    private List<Contact> mContactList;
    private List<Contact> mFilteredContactList;
    private ContactsAdapterListener mContactsAdapterListener;

    public ContactsAdapter(Context mContext, List<Contact> mContactList, ContactsAdapterListener mContactsAdapterListener) {
        this.mContext = mContext;
        this.mContactList = mContactList;
        this.mFilteredContactList = mContactList;
        this.mContactsAdapterListener = mContactsAdapterListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.contact_cell, viewGroup, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        contactViewHolder.bindContact(mFilteredContactList.get(i));
    }

    @Override
    public int getItemCount() {
        return mFilteredContactList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String filterString = charSequence.toString();
                List<Contact> contacts = new ArrayList<>();
                if (filterString.isEmpty()) {
                    contacts = mContactList;
                } else {

                    for (Contact contact : mContactList) {
                        if (contact.getName().toLowerCase().contains(filterString.toLowerCase())
                                || contact.getPhone().toLowerCase().contains(filterString.toLowerCase())) {
                            contacts.add(contact);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = contacts;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredContactList = (List<Contact>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvPhone;
        ImageView thumbnail;
        Contact contact;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_contact_name);
            tvPhone = itemView.findViewById(R.id.tv_contact_phone);
            thumbnail = itemView.findViewById(R.id.imv_contact_avatar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick");
                    if (mContactsAdapterListener != null) {
                        mContactsAdapterListener.onContactSelected(contact);
                    }
                }
            });
        }

        public void bindContact(Contact contact) {
            this.contact = contact;
            tvName.setText(contact.getName());
            tvPhone.setText(contact.getPhone());
            Glide.with(mContext)
                    .load(contact.getImage())
                    .apply(RequestOptions.circleCropTransform())
                    .into(thumbnail);
        }
    }

    public interface ContactsAdapterListener {
        void onContactSelected(Contact selectedContact);
    }
}
