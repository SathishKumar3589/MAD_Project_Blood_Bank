package com.ideabox.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListItem extends Fragment {

    DonorData donorData = new DonorData();

    public ListItem() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            donorData.id = getArguments().getInt("Id");
            donorData.full_name = getArguments().getString("Name");
            donorData.city = getArguments().getString("City");
            donorData.area = getArguments().getString("Area");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView name  = (TextView) view.findViewById(R.id.name);
        TextView location  = (TextView) view.findViewById(R.id.location);

        name.setText(donorData.full_name);
        location.setText(donorData.city+", "+donorData.area);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("info", "onClick: "+donorData.id);
                Intent i = new Intent(getActivity(),DetailActivity.class);
                i.putExtra("Id",donorData.id);
                startActivity(i);
            }
        });
    }
}
