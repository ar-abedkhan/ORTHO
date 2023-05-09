package com.abedkhan.ortho.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abedkhan.ortho.R;
import com.abedkhan.ortho.databinding.FragmentHomeBinding;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }
FragmentHomeBinding binding;
    ArrayList<SlideModel> imageList;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(getLayoutInflater(),container,false);

        imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.programm,"India", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel,"KSA", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel,"UAE", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.unnamed,"Pakistan", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel,"America", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel,"London", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.unnamed,"Bangladesh", ScaleTypes.CENTER_CROP));


        binding.imageSlider.setImageList(imageList);


binding.profileimg.setOnClickListener(view -> {

    AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
    ProfileFragment fragment=new ProfileFragment();
    Bundle bundle=new Bundle();
    fragment.setArguments(bundle);

    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();


});




binding.profilename.setOnClickListener(view -> {

    AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
    ProfileFragment fragment=new ProfileFragment();
    Bundle bundle=new Bundle();
    fragment.setArguments(bundle);

    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();


});




binding.phoneNumber.setOnClickListener(view -> {

    AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
    ProfileFragment fragment=new ProfileFragment();
    Bundle bundle=new Bundle();
    fragment.setArguments(bundle);

    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();


});

























        return binding.getRoot();
    }
}