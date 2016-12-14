package com.example.room304.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class CustomStudentAdapter extends ArrayAdapter<Student> implements ListAdapter{

    Student[] listItems;
    Context context;

    public CustomStudentAdapter(Context context, int resID, Student[] array){
        super(context, resID, array);

        listItems = array;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        View view = convertView;
        TextView nameTv;
        TextView age;
        TextView subjects;

        if(view != null){
            nameTv= (TextView)view.findViewById(R.id.name);
            age = (TextView)view.findViewById(R.id.ageView);
            subjects = (TextView)view.findViewById(R.id.subjectsText);
        }else{
            LayoutInflater lf  = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = lf.inflate(R.layout.listview_student, null);
            nameTv = (TextView)view.findViewById(R.id.name);
            age = (TextView)view.findViewById(R.id.ageView);
            subjects = (TextView)view.findViewById(R.id.subjectsText);
        }

        age.setText(listItems[position].getAge()+"");
        subjects.setText(listItems[position].getSubjects().length+"");
        nameTv.setText(listItems[position].getName());
        return view;
    }

    @Override
    public int getCount(){
        return listItems.length;
    }

}
