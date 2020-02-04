package nhs.cardiff.genetics;

import java.util.ArrayList;


/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

public class Worksheet {

    private String worksheet;
    private String user;
    private ArrayList<Sample> samples;

    public Worksheet(String worksheet) {

        this.worksheet = worksheet;
        this.user = null;
        this.samples = new ArrayList<Sample>();

    }
    public void setWorksheet(String worksheet){
        this.worksheet = worksheet;
    }
    public String getWorksheet(){
        return this.worksheet;
    }
    public void setUser(String user){this.user = user; }
    public String getUser(){
        return this.user;
    }
    public void setSamples(Sample sample){this.samples.add(sample); }
    public ArrayList<Sample> getSamples(){
        return this.samples;
    }
}
