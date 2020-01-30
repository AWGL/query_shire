package nhs.cardiff.genetics;

import sun.text.SupplementaryCharacterData;

import java.util.prefs.PreferenceChangeEvent;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

public class Worksheet {

    private String labNo;
    private String position;
    private String worksheet;
    private String test;
    private String updatedDate;
    private String sex;
    private String referralReason;
    private String firstName;
    private String comments;

    public Worksheet(String labNo){ //, String position, String worksheet, String test, String updatedDate, String sex,
                        //String referralReason, String firstName, String comments){

        this.labNo = labNo;
        //this.position = position;
        //this.worksheet = worksheet;
        //this.test = test;
        //this.updatedDate = updatedDate;
        //this.sex = sex;
        //this.referralReason = referralReason;
        //this.firstName = firstName;
        //this.comments = comments;

    }
    public void setLabNo(String labNo){
        this.labNo = labNo;
    }
    public String getLabNo(){
        return this.labNo;
    }

}
