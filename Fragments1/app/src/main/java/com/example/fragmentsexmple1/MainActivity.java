package com.example.fragmentsexmple1;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.example.fragmentsexmple1.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements
        Fragment2.OnFragment2Listener,
        Fragment3.OnFragment3Listener  {
    private ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new Fragment2())
                    .commit();

    }

    @Override
    public void onContinueClicked(String name) {

        Fragment3 fragment3 = new Fragment3();

        Bundle bundle = new Bundle();
        bundle.putString("user_name", name);
        fragment3.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment3)
                .commit();
    }
    @Override
    public void onCheckboxChanged(boolean isChecked) {

    }
}