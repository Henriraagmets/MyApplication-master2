package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class SpinnerKings extends AppCompatActivity {

    private List<King> kings = (new Kings().getKings());
    private Spinner view;
    private EditText from, to;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            to = findViewById(R.id.txtTo);

            disable(from);
            disable(to);

            view.setAdapter(new ArrayAdapter<King>(this, android.R.layout.simple_spinner_item, kings));
            view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    update(position);
                }
            });
        }
        private void disable(EditText view){
            view.setKeyListener(null);
            view.setEnabled(false);
        }
        public void update(int position)
        {
            int a = kings.get(position).getFrom();
            int b = kings.get(position).getTo();
            from.setText(a == 0 ? "" : "" + a);
            to.setText(b == 9999 ? "" : "" + b);
        }
    }

