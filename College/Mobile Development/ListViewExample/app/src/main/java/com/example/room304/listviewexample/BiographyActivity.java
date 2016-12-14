package com.example.room304.listviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class BiographyActivity extends Activity {
    ListView listView;
    CustomSubjectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography);


        String[] subjects = getIntent().getStringArrayExtra("subjects");
        TextView bio = (TextView) findViewById(R.id.biography);
        bio.setText(getIntent().getStringExtra("bio"));
        listView = (ListView) findViewById(R.id.listViewSubject);
        adapter = new CustomSubjectAdapter(this, R.layout.listview_subject, subjects);

        listView.setAdapter(adapter);
    }

}
