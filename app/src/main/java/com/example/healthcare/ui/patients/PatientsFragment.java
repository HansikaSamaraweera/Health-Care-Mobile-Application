package com.example.healthcare.ui.patients;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.healthcare.R;

public class PatientsFragment extends Fragment {

    private PatientsViewModel patientsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Fragment medicine1_fragment = getActivity().getSupportFragmentManager().findFragmentByTag("medicine1");
        if(medicine1_fragment != null)
            getActivity().getSupportFragmentManager().beginTransaction().remove(medicine1_fragment).commit();

        Fragment notes1_fragment = getActivity().getSupportFragmentManager().findFragmentByTag("notes1");
        if(notes1_fragment != null)
            getActivity().getSupportFragmentManager().beginTransaction().remove(notes1_fragment).commit();

        patientsViewModel =
                ViewModelProviders.of(this).get(PatientsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_patients, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        patientsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}