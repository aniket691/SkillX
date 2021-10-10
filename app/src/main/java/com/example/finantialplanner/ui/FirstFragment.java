package com.example.finantialplanner.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.finantialplanner.R;
import com.google.android.material.textfield.TextInputEditText;


public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }

    TextView info;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        info = v.findViewById(R.id.info1);
        TextView textView = v.findViewById(R.id.linkHyper);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        info.setText(" * Economy is a framework that deals with four major decisions." +
                "viz investment, production, consumption and expenditure\n" +
                " - Economics was defined by Adam Smith, \"the father of economics, as the science relating to the laws of production, distribution and exchange.\n" +
                " - Economics consists of two main branches micro-economics and macro-economics The former deals with the forces of demand and supply, market types, labour supply and demand on a ceterus paribus approach. The later is concerned with aggregates of economy like employment. aggregate output and income, inflation etc.\n" +
                "\n" + " * Characteristics of Indian Economy Main characteristics of Indian Economy are : - \n" +
                "\n" +
                " - Agrarian Economy In an Agrarian economy. agriculture dominates in both the Gross National Product (GNP) and employment. More than half of India's working population is engaged in agriculture\n" +
                "\n" +
                " -  Mixed Economy It is an economy, where both public" +
                "" +
                "and private sector co-exist The nature of Indian economy" +
                "" +
                "is a mixed economy. The term was coined by IM Keynes." +
                "" +
                "India opted for 'Mixed Economy in the industrial policy" +
                "" +
                "of 1948.\n" +
                "\n" +
                " * Broad Sectors of Indian Economy\n" +
                "\n" +
                " 1) Primary Sector Agriculture forestry fishing\n" +
                "\n" +
                " 2)  Secondary Sector Mining manufacturing electricity, gas" +
                "" +
                "and water supply construction\n" +
                "\n" +
                " 3) Tertiary Sector (also called service secton) (Business, transport, telecommunication, banking insurance, real estate community and personnel services");

        return v;
    }
}