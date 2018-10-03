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

public class SuraActivity extends AppCompatActivity {

    ExpandableListView expandableListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura);

        expandableListView=(ExpandableListView)findViewById(R.id.exp_listview);
        List<String> Heading=new ArrayList<>();

        List<String>L11=new ArrayList<>();
        List<String>L22=new ArrayList<>();
        List<String>L33=new ArrayList<>();
        List<String>L44=new ArrayList<>();
        List<String>L55=new ArrayList<>();
        List<String>L66=new ArrayList<>();
        List<String>L77=new ArrayList<>();
        List<String>L88=new ArrayList<>();
        List<String>L99=new ArrayList<>();
        List<String>L100=new ArrayList<>();
        List<String>L101=new ArrayList<>();
        List<String>L102=new ArrayList<>();
        List<String>L103=new ArrayList<>();

        HashMap<String,List<String>>childlist=new HashMap<String, List<String>>();

        String heading_items1[]=getResources().getStringArray(R.array.header1_titles);

        String l11[]=getResources().getStringArray(R.array.h11_item);
        String l22[]=getResources().getStringArray(R.array.h22_item);
        String l33[]=getResources().getStringArray(R.array.h33_item);
        String l44[]=getResources().getStringArray(R.array.h44_item);
        String l55[]=getResources().getStringArray(R.array.h55_item);
        String l66[]=getResources().getStringArray(R.array.h66_item);
        String l77[]=getResources().getStringArray(R.array.h77_item);
        String l88[]=getResources().getStringArray(R.array.h88_item);
        String l99[]=getResources().getStringArray(R.array.h99_item);
        String l100[]=getResources().getStringArray(R.array.h100_item);
        String l101[]=getResources().getStringArray(R.array.h101_item);
        String l102[]=getResources().getStringArray(R.array.h102_item);
        String l103[]=getResources().getStringArray(R.array.h103_item);



        for (String titles :heading_items1 )
        {
            Heading.add(titles);
        }


        for (String titles :l11 )
        {
            L11.add(titles);
        }
        for (String titles :l22 )
        {
            L22.add(titles);
        }
        for (String titles :l33 )
        {
            L33.add(titles);
        }
        for (String titles :l44 )
        {
            L44.add(titles);
        }
        for (String titles :l55 )
        {
            L55.add(titles);
        }
        for (String titles :l66 )
        {
            L66.add(titles);
        }
        for (String titles :l77 )
        {
            L77.add(titles);
        }
        for (String titles :l88 )
        {
            L88.add(titles);
        }
        for (String titles :l99 )
        {
            L99.add(titles);
        }
        for (String titles :l100 )
        {
            L100.add(titles);
        }
        for (String titles :l101 )
        {
            L101.add(titles);
        }
        for (String titles :l102 )
        {
            L102.add(titles);
        }
        for (String titles :l103 )
        {
            L103.add(titles);
        }


        childlist.put(Heading.get(0),L11);
        childlist.put(Heading.get(1),L22);
        childlist.put(Heading.get(2),L33);
        childlist.put(Heading.get(3),L44);
        childlist.put(Heading.get(4),L55);
        childlist.put(Heading.get(5),L66);
        childlist.put(Heading.get(6),L77);
        childlist.put(Heading.get(7),L88);
        childlist.put(Heading.get(8),L99);
        childlist.put(Heading.get(9),L100);
        childlist.put(Heading.get(10),L101);
        childlist.put(Heading.get(11),L102);
        childlist.put(Heading.get(12),L103);


        Myadapter myadapter=new Myadapter(this,Heading,childlist);
        expandableListView.setAdapter(myadapter);
    }
}