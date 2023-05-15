package com.abedkhan.ortho.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abedkhan.ortho.ApiRetrofit.Controller;
import com.abedkhan.ortho.ApiRetrofit.ResponseModel;
import com.abedkhan.ortho.R;
import com.abedkhan.ortho.databinding.FragmentLogeinBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LogeinFragment extends Fragment {

    public LogeinFragment() {
    }
FragmentLogeinBinding binding;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding=FragmentLogeinBinding.inflate(getLayoutInflater(),container,false);







        binding.registrationBtn.setOnClickListener(view -> {

            AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
            RegistrationFragment fragment=new RegistrationFragment();
            Bundle bundle=new Bundle();
            fragment.setArguments(bundle);

            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();


        });


        checkUser();



        binding.loginBtn.setOnClickListener(view -> {

            String email=binding.userMail.getText().toString();
            String pass=binding.userPassword.getText().toString();

            if (email.isEmpty() && pass.isEmpty()){

                binding.userMail.setError("Field cannot be empty!");
                binding.userPassword.setError("Field cannot be empty!");

            }else {

                logeinProcess(email,pass);

            }
            Log.i("tag", "login : ");

//
//
//
//            AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
//            HomeFragment fragment=new HomeFragment();
//            Bundle bundle=new Bundle();
//            fragment.setArguments(bundle);
//
//            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();

        });

















        return binding.getRoot();
    }

    private void checkUser() {

        SharedPreferences sp= getActivity().getSharedPreferences("logein",Context.MODE_PRIVATE);
        if (sp.contains("email")){
            getChildFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).addToBackStack(null).commit();

        }else {

        }

    }

     void logeinProcess(String email, String pass) {

        Log.i("tag", "process work : ");

        Call<ResponseModel> call=Controller
                .getInstance()
                .getApi()
                .veryfyUser(email,pass);


        call.enqueue(new Callback<ResponseModel>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                Log.i("tag", "response : ");

                ResponseModel object=response.body();
                String output =object.getMessage();


              if (output.equals("exist")){
                  Log.i("tag", "success : ");
                    SharedPreferences sp= getActivity().getSharedPreferences("logein", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("email",email);
                    editor.putString("password",pass);
                    editor.commit();
                    editor.apply();
                  Toast.makeText(getContext(), "Logein successfully", Toast.LENGTH_SHORT).show();

//                    HomeFragment fragment=new HomeFragment();
//                    Bundle bundle=new Bundle();
//                    fragment.setArguments(bundle);
//
//                    getChildFragmentManager().beginTransaction().replace(R.id.container,fragment).addToBackStack(null).commit();
//                    getActivity().finish();

                }  if (output.equals("failed")){
                    Log.i("tag", "failed : "+output);

                    showAlert("Something went wrong!","Email or Password are invalid");
                    binding.userMail.setTextColor(R.color.red);
                    binding.userPassword.setTextColor(R.color.red);


                }else {

                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                showAlert("Error",t.getLocalizedMessage());
            }
        });

    }

    private void showAlert(String title, String msg) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setIcon(R.drawable.ic_baseline_warning_24);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}