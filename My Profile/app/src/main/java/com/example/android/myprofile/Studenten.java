package com.example.android.myprofile;

/**
 * Created by Piratheepa on 2-6-2018.
 */

public class Studenten {

    public Studenten(String education, String firstname, String gender, String lastname, String middlename, String residence, String studentnr)
    {
        this.education = education;
        this.firstname = firstname;
        this.gender = gender;
        this.lastname = lastname;
        this.middlename = middlename;
        this.residence = residence;
        this.studentnr = studentnr;
    }

    String education, firstname, gender, lastname, middlename, residence, studentnr;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getStudentnr() {
        return studentnr;
    }

    public void setStudentnr(String studentnr) {
        this.studentnr = studentnr;
    }


}
