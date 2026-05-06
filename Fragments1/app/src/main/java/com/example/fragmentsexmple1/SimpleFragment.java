package com.example.fragmentsexmple1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentsexmple1.databinding.FragmentSimpleBinding;

import kotlin.jvm.internal.FloatSpreadBuilder;

public class SimpleFragment extends Fragment {

    private FragmentSimpleBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSimpleBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {

            int index = radioGroup.getCheckedRadioButtonId();
            if (index == R.id.radio_button_yes) {
                binding.fragmentHeader.setText(R.string.yes_message);
            } else if (index == R.id.radio_button_no) {
                binding.fragmentHeader.setText(R.string.no_message);
            }
        });
    }
}