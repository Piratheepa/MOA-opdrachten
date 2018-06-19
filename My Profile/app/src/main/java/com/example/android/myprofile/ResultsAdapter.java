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
 * Created by Piratheepa on 3-6-2018.
 */


public class ResultsAdapter extends ArrayAdapter<Results> {
    private ArrayList<Results> scoreList = new ArrayList<Results>();

    public ResultsAdapter(Activity context, ArrayList<Results> scoreList){
        super(context, 0, scoreList);

        this.scoreList = scoreList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;
        if(listViewItem == null){
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.resultsrij, parent, false);
        }

        Results objScore = this.getItem(position);

        TextView scoreCC = listViewItem.findViewById(R.id.tvScoreCC);
        scoreCC.setText(objScore.getCoursecode());

        TextView result = listViewItem.findViewById(R.id.tvScoreResult);
        result.setText(""+objScore.getResult());

        String str = objScore.getResultdate();



        TextView resultDate = listViewItem.findViewById(R.id.tvScoreResultDate);
        resultDate.setText(str.substring(0,10));

        TextView studentNr = listViewItem.findViewById(R.id.tvScoreStudentNr);
        studentNr.setText(objScore.getStudentnr());

        TextView title = listViewItem.findViewById(R.id.tvScoreTitle);
        title.setText(objScore.getTitle());

        return listViewItem;
    }
}