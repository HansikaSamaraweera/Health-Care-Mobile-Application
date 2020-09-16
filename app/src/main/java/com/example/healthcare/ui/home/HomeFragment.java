package com.example.healthcare.ui.home;

import android.content.Context;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.healthcare.*;
import com.example.healthcare.ui.medicine.MedicineFragment;
import com.example.healthcare.ui.notes.NotesFragment;
import com.example.healthcare.ui.patients.PatientsFragment;
import com.example.healthcare.ui.profile.ProfileFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Fragment patients1_fragment = getActivity().getSupportFragmentManager().findFragmentByTag("patients1");
        if(patients1_fragment != null)
            getActivity().getSupportFragmentManager().beginTransaction().remove(patients1_fragment).commit();

        Fragment notes1_fragment = getActivity().getSupportFragmentManager().findFragmentByTag("notes1");
        if(notes1_fragment != null)
            getActivity().getSupportFragmentManager().beginTransaction().remove(notes1_fragment).commit();
        Fragment medicine1_fragment = getActivity().getSupportFragmentManager().findFragmentByTag("medicine1");
        if(medicine1_fragment != null)
            getActivity().getSupportFragmentManager().beginTransaction().remove(medicine1_fragment).commit();

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
        final Button med=root.findViewById(R.id.bt_med);
        final Button patients=root.findViewById(R.id.bt_patients);
        final Button notes=root.findViewById(R.id.btnotes);
        final Button cal=root.findViewById(R.id.bt_cal);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                med.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*Intent i = new Intent(getActivity(),navActivity.class );
                        startActivity(i);*/
                        MedicineFragment nextFrag= new MedicineFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .remove(HomeFragment.this)
                                .replace(R.id.nav_host_fragment, nextFrag, "medicine1")
                                .addToBackStack(null)
                                .commit();

                        Toast.makeText(getActivity(), "clicked medicine!",
                                Toast.LENGTH_LONG).show();
                    }
                });
                patients.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*Intent i = new Intent(getActivity(), PatientActivity.class);
                        startActivity(i);*/
                        PatientsFragment nextFrag= new PatientsFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .remove(HomeFragment.this)
                                .replace(R.id.nav_host_fragment, nextFrag, "patients1")
                                .addToBackStack(null)
                                .commit();

                    }
                });
                notes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       /* Intent i = new Intent(getActivity(), NotesActivity.class);
                        startActivity(i);*/
                        NotesFragment nextFrag= new NotesFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .remove(HomeFragment.this)
                                .replace(R.id.nav_host_fragment, nextFrag, "notes1")
                                .addToBackStack(null)
                                .commit();

                    }
                });
                cal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getActivity(), CalenderActivity.class);
                        startActivity(i);


                    }
                });
            }

        });
        return root;
    }


}