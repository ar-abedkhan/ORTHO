package com.abedkhan.ortho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.abedkhan.ortho.Fragments.HomeFragment;
import com.abedkhan.ortho.Fragments.LogeinFragment;
import com.abedkhan.ortho.Fragments.RegistrationFragment;
import com.abedkhan.ortho.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new LogeinFragment()).commit();


//  getSupportFragmentManager().beginTransaction().replace(androidx.constraintlayout.widget.R.id.constraint,new HomeFragment()).commit();


    }
}