/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Drol
 */
public class Questions extends BaseModel {

    private int id; //identity(1,1)
    private String question;
    private Date creationDate;
    private String authorName;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private boolean optionAIsAnswer = false;
    private boolean optionBIsAnswer = false;
    private boolean optionCIsAnswer = false;
    private boolean optionDIsAnswer = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public boolean isOptionAIsAnswer() {
        return optionAIsAnswer;
    }

    public void setOptionAIsAnswer(boolean optionAIsAnswer) {
        this.optionAIsAnswer = optionAIsAnswer;
    }

    public boolean isOptionBIsAnswer() {
        return optionBIsAnswer;
    }

    public void setOptionBIsAnswer(boolean optionBIsAnswer) {
        this.optionBIsAnswer = optionBIsAnswer;
    }

    public boolean isOptionCIsAnswer() {
        return optionCIsAnswer;
    }

    public void setOptionCIsAnswer(boolean optionCIsAnswer) {
        this.optionCIsAnswer = optionCIsAnswer;
    }

    public boolean isOptionDIsAnswer() {
        return optionDIsAnswer;
    }

    public void setOptionDIsAnswer(boolean optionDIsAnswer) {
        this.optionDIsAnswer = optionDIsAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questions other = (Questions) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
