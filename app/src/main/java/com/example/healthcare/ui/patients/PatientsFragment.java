package com.example.healthcare.ui.patients;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.healthcare.R;
import android.content.Intent;
import android.widget.Button;
import com.example.healthcare.addPatient;
import com.example.healthcare.patientDetails;

import java.util.ArrayList;

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

        patientsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
            }
        });
        final ListView list = root.findViewById(R.id.patient_list);
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hana Anne");
        arrayList.add("Meena Jessy");
        arrayList.add("Keshari Welikalage");
        arrayList.add("Randika Ferdinando");
        arrayList.add("Thilesh Jayasinghe");
        arrayList.add("Akenya Perera");
        arrayList.add("Sonali Anesta");
        arrayList.add("Mithuni Supunsara");
        final ArrayAdapter adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) list.getItemAtPosition(position);
                Intent i = new Intent(getActivity(), patientDetails.class);
                i.putExtra("details", clickedItem);
                startActivity(i);
            }
        });
        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem2 = (String) list.getItemAtPosition(position);
                Intent i = new Intent(getActivity(), edit_Patient.class);
                i.putExtra("details", clickedItem2);
                startActivity(i);
            }
        });*/
        final Button patients = root.findViewById(R.id.btnaddPatient);
        patients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), addPatient.class);
                startActivity(i);
            }
        });
        return root;
    }
}