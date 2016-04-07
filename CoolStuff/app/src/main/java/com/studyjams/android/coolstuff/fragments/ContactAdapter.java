package com.studyjams.android.coolstuff.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studyjams.android.coolstuff.R;
import com.studyjams.android.coolstuff.fragments.ContactFragment.OnListFragmentInteractionListener;
import com.studyjams.android.coolstuff.fragments.dummy.ContactContent.ContactItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ContactItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private final List<ContactItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public ContactAdapter(List<ContactItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mEmailView.setText(mValues.get(position).email);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                    holder.mView.setSelected(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mEmailView;
        public ContactItem mItem;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
            mEmailView = (TextView) view.findViewById(R.id.email);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mEmailView.getText() + "'";
        }
    }
}
