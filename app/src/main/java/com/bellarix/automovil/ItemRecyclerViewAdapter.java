package com.bellarix.automovil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by flakoloko32 on 7/29/2015.
 */
public class ItemRecyclerViewAdapter
        extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // This is used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain member variable
        // for any view that will be set as you render a row
        public TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView)itemView.findViewById(R.id.tvTitle);
        }

    }

    // ... view holder defined above...
    // store a member variable for the offers
    private ArrayList<Item> items;
    // storing the context for later use
    private Context context;

    // Now, pass in the context and users array into the constructor
    public ItemRecyclerViewAdapter(Context context, ArrayList<Item> items){
        this.items = items;
        this.context = context;
    }


    // Now, define the default constructor so that the IDE stops being vexing
    // This usually involves inflating a layout from XML and returning the holder
    @Override
    public ItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Inflate the custom layout
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_layout, parent, false);
        // Return a new holder instance
        return new ItemRecyclerViewAdapter.ViewHolder(itemView);
    }

    // Now, this populates data into the offer item through the holder
    @Override
    public void onBindViewHolder(ItemRecyclerViewAdapter.ViewHolder holder, int position){
        // Get the data model based on position
        Item item = items.get(position);
        // Set item views based on the data model
        holder.tvTitle.setText(item.title);
    }

    // Return the total count of offers/items
    @Override
    public int getItemCount(){
        return items.size();
    }
}