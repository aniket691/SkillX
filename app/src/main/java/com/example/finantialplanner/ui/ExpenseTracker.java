package com.example.finantialplanner.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finantialplanner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;

public class ExpenseTracker extends Fragment implements View.OnClickListener {

    EditText editText;
    TextView spend;
    TextView save;
    TextView total;
    DatabaseReference Save;
    DatabaseReference Spend;
    int val2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_expense_tracker, container, false);
        editText = v.findViewById(R.id.editTextTextPersonName);
        spend = v.findViewById(R.id.spend);
        spend.setOnClickListener(this);
        save = v.findViewById(R.id.save);
        save.setOnClickListener(this);
        total = v.findViewById(R.id.total);
        String user_id = FirebaseAuth.getInstance().getUid();
        Save = FirebaseDatabase.getInstance().getReference().child("save").child(user_id).child("m");
        Spend = FirebaseDatabase.getInstance().getReference().child("spend").child(user_id).child("m");
        Save.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {
                Spend.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot2) {
                        if (snapshot1.getValue() != null && snapshot2.getValue() != null) {
                            int val1 = Integer.parseInt(snapshot1.getValue(String.class));
                            int val2 = Integer.parseInt(snapshot2.getValue(String.class));
                            total.setText(String.valueOf(val1 - val2));
                        } else {
                            total.setText("0");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return v;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.save) {
            Save.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.getValue() != null) {
                        int val1 = Integer.parseInt(snapshot.getValue(String.class));
                        String s = editText.getText().toString();
                        if (s.trim().length() > 4) {
                            Toast.makeText(getContext(), "Number is too big", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Pattern p = Pattern.compile("[0-9]{1,4}");
                        Matcher m = p.matcher(s);
                        if (!(m.find() && m.group().equals(s))) {
                            Toast.makeText(getContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        int val2 = Integer.parseInt(s);
                        Save.setValue(String.valueOf(val1 + val2));
                    } else {
                        Save.setValue(String.valueOf(val2));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }

        if (v.getId() == R.id.spend) {
            Spend.addListenerForSingleValueEvent(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.getValue() != null) {
                        int val1 = Integer.parseInt(snapshot.getValue(String.class));
                        String s = editText.getText().toString();
                        if (s.trim().length() > 4) {
                            Toast.makeText(getContext(), "Number is too big", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Pattern p = Pattern.compile("[0-9]{1,4}");
                        Matcher m = p.matcher(s);
                        if (!(m.find() && m.group().equals(s))) {
                            Toast.makeText(getContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        val2 = Integer.parseInt(s);
                        Spend.setValue(String.valueOf(val1 + val2));
                    } else {
                        Spend.setValue(String.valueOf(val2));
                    }
                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}