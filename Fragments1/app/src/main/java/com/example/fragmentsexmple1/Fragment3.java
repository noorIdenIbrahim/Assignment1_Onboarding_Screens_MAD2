package com.example.fragmentsexmple1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentsexmple1.databinding.Fragment3Binding;


public class Fragment3 extends Fragment {
    private Fragment3Binding fragment3Binding;
    private OnFragment3Listener listener;

    public interface OnFragment3Listener {
        void onCheckboxChanged(boolean isChecked);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment3Listener) {
            listener = (OnFragment3Listener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        String name="";
        fragment3Binding=Fragment3Binding.inflate(inflater,container,false);
        if (getArguments() != null) {
            name = getArguments().getString("user_name");
        }
        fragment3Binding.textViewFragment3.setText("Welcome " + name + "   ^_- ");

        fragment3Binding.checkBoxFragment3.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (listener != null) {
                listener.onCheckboxChanged(isChecked);
            }

            if (isChecked) {
                fragment3Binding.buttonFragment3.setEnabled(true);
                fragment3Binding.buttonFragment3.setText(R.string.Finish);
            }else {
                fragment3Binding.buttonFragment3.setEnabled(false);
                fragment3Binding.buttonFragment3.setText(R.string.Continue);
            }
        });

        return fragment3Binding.getRoot();

    }
}