package com.example.collegeconnect.ui.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.collegeconnect.R;
import com.example.collegeconnect.UploadNotes;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NotesFragment extends Fragment {
    BottomNavigationView bottomNavigationView;
    TextView tv;
    Button viewnotes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(getActivity()!=null)
            bottomNavigationView = getActivity().findViewById(R.id.bottomNav);

        View view = inflater.inflate(R.layout.fragment_notes,null);

        tv=getActivity().findViewById(R.id.tvTitle);
        tv.setText("Notes");

        view.findViewById(R.id.fab_upload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), UploadNotes.class));
            }
        });

        view.findViewById(R.id.viewnotes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNotes();
            }
        });
        return view;

    }

    private void viewNotes() {

    }

    @Override
    public void onStart() {
        super.onStart();
        bottomNavigationView.getMenu().findItem(R.id.nav_notes).setChecked(true);
    }
}