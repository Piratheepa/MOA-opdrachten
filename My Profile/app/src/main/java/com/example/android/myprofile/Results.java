package com.example.android.myprofile;

/**
 * Created by Piratheepa on 3-6-2018.
 */

public class Results {


    String coursecode, resultdate, studentnr, title;
    Double result;

    public Results(String coursecode, Double result, String resultdate, String studentnr, String title) {
        this.coursecode = coursecode;
        this.result = result;
        this.resultdate = resultdate;
        this.studentnr = studentnr;
        this.title = title;
    }


    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getResultdate() {
        return resultdate;
    }

    public void setResultdate(String resultdate) {
        this.resultdate = resultdate;
    }

    public String getStudentnr() {
        return studentnr;
    }

    public void setStudentnr(String studentnr) {
        this.studentnr = studentnr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
