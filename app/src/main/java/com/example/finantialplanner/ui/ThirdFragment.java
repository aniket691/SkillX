package com.example.finantialplanner.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finantialplanner.R;


public class ThirdFragment extends Fragment {


    EditText number1;
    EditText number2;
    Button Add_button;
    TextView result;
    int ans=0;

    public ThirdFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v= inflater.inflate(R.layout.fragment_third, container, false);

        number1=v.findViewById(R.id.editText_first_no);
        number2=v. findViewById(R.id.editText_second_no);
        Add_button= v.findViewById(R.id.add_button);
        result = v.findViewById(R.id.textView_answer);

Add_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double sum = num1 + num2;
        if (num1 < num2 )
        {
            result.setText("Profit");
        }else if (num1 == num2)
        {
            result.setText("No Profit No Loss");
        }else
        {
            result.setText("Loss");
        }

    }
});
        return v;
    }
}