package com.example.room304.listviewexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {
    ListView listView;
    CustomStudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        Student[] students = Student.getStudents();
        adapter = new CustomStudentAdapter(this, R.layout.listview_student, students);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student listItem = (Student) listView.getItemAtPosition(position);
                Intent appInfo = new Intent(MainActivity.this, BiographyActivity.class);
                appInfo.putExtra("subjects", listItem.getSubjects());
                appInfo.putExtra("bio", listItem.getBiography());
                startActivity(appInfo);
            }
        });


    }

}
