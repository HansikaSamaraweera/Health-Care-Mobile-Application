package com.example.healthcare.ui.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.healthcare.CalenderActivity;
import com.example.healthcare.MedicineActivity;
import com.example.healthcare.MedicineHome;
import com.example.healthcare.R;
import com.example.healthcare.ui.home.HomeFragment;

public class MedicineFragment extends Fragment {

    private MedicineViewModel medicineViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Fragment patients1_fragment = getActivity().getSupportFragmentManager().findFragmentByTag("patients1");
        if(patients1_fragment != null)
            getActivity().getSupportFragmentManager().beginTransaction().remove(patients1_fragment).commit();

        Fragment notes1_fragment = getActivity().getSupportFragmentManager().findFragmentByTag("notes1");
        if(notes1_fragment != null)
            getActivity().getSupportFragmentManager().beginTransaction().remove(notes1_fragment).commit();

        medicineViewModel =
                ViewModelProviders.of(this).get(MedicineViewModel.class);
        View root = inflater.inflate(R.layout.fragment_medicine, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        final Button save=root.findViewById(R.id.savem);
        medicineViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getActivity(), MedicineActivity.class);
                        startActivity(i);
               
                   }
                });
            }
        });
        return root;
    }
}