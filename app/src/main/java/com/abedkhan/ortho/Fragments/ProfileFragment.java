package com.abedkhan.ortho.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.ortho.R;
import com.abedkhan.ortho.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
    }
    FragmentProfileBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
binding=FragmentProfileBinding.inflate(getLayoutInflater(),container,false);




binding.backBtn.setOnClickListener(view -> {

    AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
    HomeFragment fragment=new HomeFragment();
    Bundle bundle=new Bundle();
    fragment.setArguments(bundle);

    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();


});















        return binding.getRoot();
    }
}