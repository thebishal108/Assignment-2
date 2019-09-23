package com.example.assignment_2.data;

import java.util.ArrayList;

public class data {
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> genderlist = new ArrayList<String>();
    ArrayList<String> email = new ArrayList<String>();
    ArrayList<String> password = new ArrayList<String>();
    ArrayList<String> usertype = new ArrayList<String>();
    ArrayList<String> occupation = new ArrayList<String>();
    ArrayList<String> dateofbirth = new ArrayList<String>();

    public data() {
    }

    public void adddata(String name, String genderlist, String email, String password, String usertype, String occupation, String dateofbirth) {
        this.name.add(name);
        this.genderlist.add(genderlist);
        this.email.add(email);
        this.password.add(password);
        this.usertype.add(usertype);
        this.occupation.add(occupation);
        this.dateofbirth.add(dateofbirth);
    }

    public boolean matchdata(String na, String pass) {
        for (int i = 0; i < name.size(); i++) {
            if (name.get(i).equals(na)) {
                if (password.get(i).equals(pass))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
