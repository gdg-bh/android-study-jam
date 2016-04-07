package com.studyjams.android.coolstuff.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studyjams.android.coolstuff.R;
import com.studyjams.android.coolstuff.fragments.dummy.ContactContent;
import com.studyjams.android.coolstuff.fragments.dummy.ContactContent.ContactItem;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ContactFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";

    // Action when Item was clicked
    private OnListFragmentInteractionListener mListener = new OnListFragmentInteractionListener() {
        @Override
        public void onListFragmentInteraction(ContactItem item) {
            // Send email to contact list
            sendEmail(item.name, item.email);
        }
    };

    // TODO: Customize parameter initialization
    public static ContactFragment newInstance(int columnCount) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ContactFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            recyclerView.setAdapter(new ContactAdapter(ContactContent.ITEMS, mListener));
        }
        return view;
    }

    private void sendEmail(String name, String email) {

        String message = name + " você está na minha lista de contatos! :)";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { email });
        intent.putExtra(Intent.EXTRA_SUBJECT, "My Contact List");
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(ContactItem item);
    }
}
