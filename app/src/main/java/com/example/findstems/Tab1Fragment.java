package com.example.findstems;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private Button btnEnterWord;
    private EditText editTextInput;
    private TextView printStems;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);
        btnEnterWord = (Button) view.findViewById(R.id.btnEnterWord);
        editTextInput = (EditText) view.findViewById(R.id.editTextInput);
        printStems = (TextView) view.findViewById(R.id.printStems);

        btnEnterWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get text from input
                String input = editTextInput.getText().toString();


                //convert string to list of all words entered
               String[] allWords = input.split(" ");

               StringBuilder sb = new StringBuilder();
               for (int i = 0 ; i < allWords.length ; i++) {
                   String curr = allWords[i];

                   //get stems of word
                   //word does not include any non-alphabetical characters
                   String[] stems = Word.getStems(curr.replaceAll("[^A-Za-z]+", "")).toArray(new String[0]);

                   sb.append(allWords[i] + ": ");

                   for (int j = 0 ; j < stems.length - 1 ; j++) {
                       sb.append(stems[j] + ", ");
                   }
                   sb.append(stems[stems.length - 1]);

                   sb.append("\n");
                }

               printStems.setText(sb.toString());
            }
        });

        return view;
    }

}
