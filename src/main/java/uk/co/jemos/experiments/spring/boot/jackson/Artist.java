package uk.co.jemos.experiments.spring.boot.jackson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tedonema on 09/05/2015.
 */
public class Artist {

    public String name;
    public Date birthDate;
    public int age;
    public String homeTown;
    public List<String> awardsWon = new ArrayList<String>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
