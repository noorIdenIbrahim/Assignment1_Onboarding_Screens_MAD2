package com.example.fragmentsexmple1;

import static android.app.ProgressDialog.show;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fragmentsexmple1.databinding.Fragment2Binding;

public class Fragment2 extends Fragment  {
    private Fragment2Binding fragment2Binding ;
    private OnFragment2Listener listener;

    public interface OnFragment2Listener {
        void onContinueClicked(String name);
    }

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        if (context instanceof  OnFragment2Listener){

            listener =(OnFragment2Listener) context ;

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        fragment2Binding=Fragment2Binding.inflate(inflater,container,false);


        fragment2Binding.butFragment2.setOnClickListener(v ->{
            String name ="";
            String age = "";
            String email = "";
            String university = "";
            String gender = "";
            if (fragment2Binding.edFragment2Name.getText().toString().isEmpty()) {

                fragment2Binding.edFragment2Name.setHint("Name is required");
                fragment2Binding.edFragment2Name.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

            } else  {
                name = fragment2Binding.edFragment2Name.getText().toString();
                fragment2Binding.edFragment2Name.setBackgroundTintList(null);

               if (fragment2Binding.edFragment2Age.getText().toString().isEmpty()){

                   fragment2Binding.edFragment2Age.setHint("Age is required");
                   fragment2Binding.edFragment2Age.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

               }else {
                    age = fragment2Binding.edFragment2Age.getText().toString();
                   fragment2Binding.edFragment2Age.setBackgroundTintList(null);

                    if (fragment2Binding.edFragment2Email.getText().toString().isEmpty()){
                        fragment2Binding.edFragment2Email.setHint("Email is required");
                        fragment2Binding.edFragment2Email.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

                    }else {
                         email = fragment2Binding.edFragment2Email.getText().toString();
                        fragment2Binding.edFragment2Email.setBackgroundTintList(null);

                        if (fragment2Binding.edFragment2Unversity.getText().toString().isEmpty()){
                            fragment2Binding.edFragment2Unversity.setHint("University is required");
                            fragment2Binding.edFragment2Unversity.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

                        }else {
                             university = fragment2Binding.edFragment2Unversity.getText().toString();
                            fragment2Binding.edFragment2Unversity.setBackgroundTintList(null);

                            int select=fragment2Binding.radioGroup.getCheckedRadioButtonId();

                            if (select==R.id.radioBut_fragment2_female){
                                gender="Female";
                            }else if (select==R.id.radioBut_fragment2_male){
                                gender="Male";
                            }else {
                                Toast.makeText(getContext(), "Select Gender",Toast.LENGTH_SHORT).show();
                            }


                            if (listener != null) {
                                listener.onContinueClicked(name);
                            }
                        }
                    }
               }
            }


        });


        return fragment2Binding.getRoot();
    }



}