package com.example.findstems;

import android.content.Context;
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

    private Fragment1Listener listener;
    private Button btnEnterWord;
    private EditText editTextInput;
    private TextView printStems;

    public interface Fragment1Listener {
        void onInput1Sent(List<String> data);
    }

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

                List<String> stemsToBeSent = new ArrayList<>();

                //get text from input
                String input = editTextInput.getText().toString();


                //convert string to list of all words entered
               String[] allWords = input.split(" ");

               StringBuilder sb = new StringBuilder();
               for (int i = 0 ; i < allWords.length ; i++) {
                   String curr = allWords[i].toUpperCase();

                   //get stems of word
                   //word does not include any non-alphabetical characters
                   String[] stems = Word.getStems(curr.replaceAll("[^A-Za-z]+", "")).toArray(new String[0]);

                   sb.append(curr + ": ");

                   for (int j = 0 ; j < stems.length - 1 ; j++) {
                       sb.append(stems[j] + ", ");
                       stemsToBeSent.add(stems[j]);
                   }
                   sb.append(stems[stems.length - 1]);
                   stemsToBeSent.add(stems[stems.length - 1]);

                   sb.append("\n");
                }

               printStems.setText(sb.toString());

               //send stems to fragment 2
                listener.onInput1Sent(stemsToBeSent);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment1Listener) {
            listener = (Fragment1Listener) context;
        }
        else {
            throw new RuntimeException(context.toString() +
                    " must implement Fragment1Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
