package com.abedkhan.ortho.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.ortho.R;
import com.abedkhan.ortho.databinding.FragmentTopUPBinding;

public class TopUPFragment extends Fragment {
    public TopUPFragment() {
        // Required empty public constructor
    }

    FragmentTopUPBinding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentTopUPBinding.inflate(getLayoutInflater(),container, false);


















        return binding.getRoot();
    }
}