package com.lxjtest.entity;

public class Record {
    int RECORD_ID;
    int SURVEY_ID;
    String BIRD_NAME;
    String BIRD_NUMBER;
    String BIRD_PICTURE_URL;

    public Record(int SURVEY_ID,String BIRD_NAME, String BIRD_NUMBER,String BIRD_PICTURE_URL) {
        this.SURVEY_ID=SURVEY_ID;
        this.BIRD_NAME = BIRD_NAME;
        this.BIRD_NUMBER = BIRD_NUMBER;
        this.BIRD_PICTURE_URL=BIRD_PICTURE_URL;
    }

    public int getRECORD_ID() {
        return RECORD_ID;
    }

    public void setRECORD_ID(int RECORD_ID) {
        this.RECORD_ID = RECORD_ID;
    }

    public int getSURVEY_ID() {
        return SURVEY_ID;
    }

    public void setSURVEY_ID(int SURVEY_ID) {
        this.SURVEY_ID = SURVEY_ID;
    }

    public String getBIRD_NAME() {
        return BIRD_NAME;
    }

    public void setBIRD_NAME(String BIRD_NAME) {
        this.BIRD_NAME = BIRD_NAME;
    }

    public String getBIRD_NUMBER() {
        return BIRD_NUMBER;
    }

    public void setBIRD_NUMBER(String BIRD_NUMBER) {
        this.BIRD_NUMBER = BIRD_NUMBER;
    }

    public String getBIRD_PICTURE_URL() {
        return BIRD_PICTURE_URL;
    }

    public void setBIRD_PICTURE_URL(String BIRD_PICTURE_URL) {
        this.BIRD_PICTURE_URL = BIRD_PICTURE_URL;
    }
}
