package com.example.android.myprofile;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Piratheepa on 2-6-2018.
 */

public class StudentenAdapter extends ArrayAdapter<Studenten> {
    private ArrayList<Studenten> studentList = new ArrayList<Studenten>();

    public StudentenAdapter(Activity context, ArrayList<Studenten> studentList){
        super(context, 0, studentList);

        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;
        if(listViewItem == null){
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.listrij, parent, false);
        }

        Studenten objStudent = this.getItem(position);

        TextView tvName = listViewItem.findViewById(R.id.tvName);
        tvName.setText(objStudent.getFirstname() + "" + objStudent.getMiddlename() + "" + objStudent.getLastname());

        TextView tvGender = listViewItem.findViewById(R.id.tvGender);
        tvGender.setText(objStudent.getGender());

        TextView tvResidence = listViewItem.findViewById(R.id.tvResidence);
        tvResidence.setText(objStudent.getResidence());

        TextView tvStudentNr = listViewItem.findViewById(R.id.tvStudentNr);
        tvStudentNr.setText(objStudent.getEducation());

        String initials = "";

        initials +=  objStudent.getFirstname().charAt(0);
        initials +=  objStudent.getLastname().charAt(0);

        TextView tvInitials = listViewItem.findViewById(R.id.myImageViewText);
        tvInitials.setText(initials);

        return listViewItem;
    }
}