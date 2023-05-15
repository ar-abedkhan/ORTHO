package com.abedkhan.ortho.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abedkhan.ortho.R;
import com.abedkhan.ortho.databinding.FragmentRegistrationBinding;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistrationFragment extends Fragment {
    public RegistrationFragment() {
    }
    FragmentRegistrationBinding binding;

                   final static String url="http://192.168.0.114/php/register.php";
                    //    final static String url="https://abedkhan.000webhostapp.com/registration.php";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentRegistrationBinding.inflate(getLayoutInflater(),container,false);


        binding.registrationBtn.setOnClickListener(view -> {



            String name=binding.userFullName.getText().toString().trim();
            String email=binding.userMail.getText().toString().trim();
            String pass=binding.userPassword.getText().toString().trim();
            String number=binding.userPhoneNumber.getText().toString().trim();

            if (name.isEmpty() && email.isEmpty() && pass.isEmpty() && number.isEmpty()){

                binding.userFullName.setError("Field cannot be empty!");
                binding.userMail.setError("Field cannot be empty!");
                binding.userPassword.setError("Field cannot be empty!");
                binding.userPhoneNumber.setError("Field cannot be empty!");

            }else {

                registrationUser(name,email,pass);

            }

        });


        //   AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
//        HomeFragment fragment=new HomeFragment();
//        Bundle bundle=new Bundle();
//        fragment.setArguments(bundle);
//
//        getChildFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();



        binding.loginBtn.setOnClickListener(view -> {

            AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
            LogeinFragment fragment=new LogeinFragment();
            Bundle bundle=new Bundle();
            fragment.setArguments(bundle);
            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();

        });













        return binding.getRoot();
    }

    private void registrationUser(final String name, final String email, final String pass) {


        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                binding.userFullName.setText("");
                binding.userMail.setText("");
                binding.userPassword.setText("");
                binding.userPhoneNumber.setText("");
                Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>map=new HashMap<>();
                map.put("name",name);
                map.put("email",email);
                map.put("password",pass);
             //   map.put("number",number);
                return map;
            }
        };

        RequestQueue queue= Volley.newRequestQueue(getContext());
        queue.add(request);











    }
}