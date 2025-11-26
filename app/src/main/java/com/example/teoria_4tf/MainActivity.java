package com.example.teoria_4tf;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String[] elementy =
            {
            "Element1","Element2","Element2","Element4","Element5"
            };
    private ArrayAdapter<String> adapter;
    private ArrayList<String> elementyList;
    private ListView lvElementy;
    private int index = -1;
    private Button btn;
    private EditText newItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn = findViewById(R.id.btnAdd);
        newItem = findViewById(R.id.etNewElement);
        lvElementy = findViewById(R.id.listaNapisow);
        lvElementy.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        elementyList = new ArrayList<String>();
        elementyList.addAll(Arrays.asList(elementy));
        adapter = new ArrayAdapter<String>(this, R.layout.my_item,elementyList);
        lvElementy.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                elementyList.add(newItem.getText().toString());
                adapter.notifyDataSetChanged();
                //newItem.setText("");
            }
        });






        //lvElementy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         //   @Override
           // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 //if(index>=0)
                 //   lvElementy.getChildAt(index).setBackgroundColor(Color.parseColor("white"));

                //view.setBackgroundColor(Color.parseColor("#00ff00"));
                //index = position;

                //elementyList.add("Nowy element");


       //     }
       // });

    }
}