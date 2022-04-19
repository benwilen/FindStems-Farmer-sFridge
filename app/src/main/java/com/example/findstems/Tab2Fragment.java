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
                history.clear();
                printHistory.setText("");
            }
        });

        btnGetHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get all mappings
                Set<Map.Entry<String, Integer>> mappings = history.entrySet();

                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Integer> pair : mappings) {
                    sb.append(pair.getKey() + ": ");
                    sb.append(Integer.toString(pair.getValue()));
                    sb.append("\n");
                }

                printHistory.setText(sb.toString());
            }
        });

        return view;
    }

    public void updateHistory(List<String> data) {
        for (int i = 0 ; i < data.size() ; i++) {
            String curr = data.get(i);
            if (history.containsKey(curr)) {
                history.put(curr, history.get(curr) + 1);
            }
            else {
                history.put(curr, 1);
            }
        }
    }

}