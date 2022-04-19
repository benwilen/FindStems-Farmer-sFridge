package com.example.findstems;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.*;

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private Button btnClear;
    private Button btnGetHistory;
    private TextView printHistory;

    public Map<String, Integer> history;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);
        btnClear = (Button) view.findViewById(R.id.btnClear);
        btnGetHistory = (Button) view.findViewById(R.id.btnGetHistory);
        printHistory = (TextView) view.findViewById(R.id.printHistory);
        history = new HashMap<String, Integer>();

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear history and screen of past searches
                history.clear();
                printHistory.setText("");
            }
        });

        btnGetHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get all mappings
                Set<Map.Entry<String, Integer>> mappings = history.entrySet();

                //iterate through each Entry to get the stem and its frequency of searches
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Integer> pair : mappings) {
                    sb.append(pair.getKey() + ": ");
                    sb.append(Integer.toString(pair.getValue()));
                    sb.append("\n");
                }

                //set text on screen to StringBuilder
                printHistory.setText(sb.toString());
            }
        });

        return view;
    }

    public void updateHistory(List<String> data) {
        for (int i = 0 ; i < data.size() ; i++) {
            String curr = data.get(i);

            //implement its frequency by 1 if already in Map
            if (history.containsKey(curr)) {
                history.put(curr, history.get(curr) + 1);
            }

            //else modify the Map to include it
            else {
                history.put(curr, 1);
            }
        }
    }

}