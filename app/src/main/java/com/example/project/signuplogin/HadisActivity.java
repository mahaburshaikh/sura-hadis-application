package com.example.project.signuplogin;


import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HadisActivity extends AppCompatActivity {

    ExpandableListView expandableListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadis);

        expandableListView=(ExpandableListView)findViewById(R.id.exp_listview);
        List<String> Heading=new ArrayList<>();

        List<String>L1=new ArrayList<>();
        List<String>L2=new ArrayList<>();
        List<String>L3=new ArrayList<>();
        List<String>L4=new ArrayList<>();
        List<String>L5=new ArrayList<>();
        List<String>L6=new ArrayList<>();
        List<String>L7=new ArrayList<>();
        List<String>L8=new ArrayList<>();
        List<String>L9=new ArrayList<>();
        List<String>L10=new ArrayList<>();


        HashMap<String,List<String>>childlist=new HashMap<String, List<String>>();

        String heading_items[]=getResources().getStringArray(R.array.header_titles);

        String l1[]=getResources().getStringArray(R.array.h1_item);
        String l2[]=getResources().getStringArray(R.array.h2_item);
        String l3[]=getResources().getStringArray(R.array.h3_item);
        String l4[]=getResources().getStringArray(R.array.h4_item);
        String l5[]=getResources().getStringArray(R.array.h5_item);
        String l6[]=getResources().getStringArray(R.array.h6_item);
        String l7[]=getResources().getStringArray(R.array.h7_item);
        String l8[]=getResources().getStringArray(R.array.h8_item);
        String l9[]=getResources().getStringArray(R.array.h9_item);
        String l10[]=getResources().getStringArray(R.array.h10_item);

        for (String titles :heading_items )
        {
            Heading.add(titles);
        }

        for (String titles :l1 )
        {
            L1.add(titles);
        }
        for (String titles :l2 )
        {
            L2.add(titles);
        }
        for (String titles :l3 )
        {
            L3.add(titles);
        }
        for (String titles :l4 )
        {
            L4.add(titles);
        }
        for (String titles :l5 )
        {
            L5.add(titles);
        }
        for (String titles :l6 )
        {
            L6.add(titles);
        }
        for (String titles :l7 )
        {
            L7.add(titles);
        }
        for (String titles :l8 )
        {
            L8.add(titles);
        }
        for (String titles :l9 )
        {
            L9.add(titles);
        }
        for (String titles :l10 )
        {
            L10.add(titles);
        }


        childlist.put(Heading.get(0),L1);
        childlist.put(Heading.get(1),L2);
        childlist.put(Heading.get(2),L3);
        childlist.put(Heading.get(3),L4);
        childlist.put(Heading.get(4),L5);
        childlist.put(Heading.get(5),L6);
        childlist.put(Heading.get(6),L7);
        childlist.put(Heading.get(7),L8);
        childlist.put(Heading.get(8),L9);
        childlist.put(Heading.get(9),L10);



        Myadapter myadapter=new Myadapter(this,Heading,childlist);
        expandableListView.setAdapter(myadapter);
    }
}