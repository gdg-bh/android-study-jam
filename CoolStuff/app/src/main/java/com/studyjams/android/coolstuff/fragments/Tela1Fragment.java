package com.studyjams.android.coolstuff.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studyjams.android.coolstuff.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tela1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tela1Fragment extends Fragment {

    public Tela1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Tela1Fragment.
     */
    public static Tela1Fragment newInstance() {
        return new Tela1Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela1, container, false);
    }

}
