package com.bellarix.automovil;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by flakoloko32 on 7/27/2015.
 */
public class ThirdFragment extends Fragment {
    protected LinearLayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // defining the layout of the fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        // Lookup the recyclerview in activity layout
        RecyclerView rvUsers = (RecyclerView) view.findViewById(R.id.rvUsersThird);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvUsers.setLayoutManager(mLayoutManager);
        // Create adapter passing in the sample user data
        ItemRecyclerViewAdapter adapter = new ItemRecyclerViewAdapter(getActivity(), getCoolItemList());
        // Attach the adapter to the recyclerview to populate items
        rvUsers.setAdapter(adapter);
        return view;
    }

    private ArrayList<Item> getCoolItemList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Dany Targaryen"));
        items.add(new Item("Rob Stark"));
        items.add(new Item("Jon Snow"));
        items.add(new Item("Tyrion Lanister"));
        return items;
    }
}
