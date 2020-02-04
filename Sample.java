package nhs.cardiff.genetics;

/**
 * @author Sara Rey
 * @Date 28/01/2020
 * @version 1.0.0
 */

public class Sample {
    private String labNo;
    private String position;
    private String worksheet;
    private String test;
    private String updatedDate;
    private String sex;
    private String referralReason;
    private String firstName;
    private String comments;

    public Sample() {

        this.labNo = null;
        this.position = null;
        this.worksheet = null;
        this.test = null;
        this.updatedDate = null;
        this.sex = null;
        this.referralReason = null;
        this.firstName = null;
        this.comments = null;

    }
    public void setLabNo(String labNo){
        this.labNo = labNo;
    }
    public String getLabNo(){
        return this.labNo;
    }
    public void setPosition(String position) {this.position = position;}
    public String getPosition(){
        return this.position;
    }
    public void setWorksheet(String worksheet) {this.worksheet = worksheet;}
    public String getWorksheet(){
        return this.worksheet;
    }
    public void setTest(String test) {this.test = test;}
    public String getTest(){
        return this.test;
    }
    public void setUpdatedDate(String updatedDate) {this.updatedDate = updatedDate;}
    public String getUpdatedDate(){
        return this.updatedDate;
    }
    public void setSex(String sex) {this.sex = sex;}
    public String getSex(){
        return this.sex;
    }
    public void setReferralReason(String referralReason) {this.referralReason = referralReason;}
    public String getReferralReason(){
        return this.referralReason;
    }
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getFirstName(){
        return this.firstName;
    }
    public void setComments(String comments) {this.comments = comments;}
    public String getComments(){
        return this.comments;
    }
}

