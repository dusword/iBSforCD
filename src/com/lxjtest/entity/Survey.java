package com.lxjtest.entity;

import java.util.Date;

public class Survey {
    int SURVEY_ID;
    String SURVEY_NAME;
    int SURVEY_USER_ID;
    Date SURVEY_DATE;
    String SURVEY_PLACE;

    public Survey(String SURVEY_NAME, int SURVEY_USER_ID, String SURVEY_PLACE) {
        this.SURVEY_NAME = SURVEY_NAME;
        this.SURVEY_USER_ID = SURVEY_USER_ID;
        this.SURVEY_PLACE = SURVEY_PLACE;
    }

    public int getSURVEY_ID() {
        return SURVEY_ID;
    }

    public void setSURVEY_ID(int SURVEY_ID) {
        this.SURVEY_ID = SURVEY_ID;
    }

    public String getSURVEY_NAME() {
        return SURVEY_NAME;
    }

    public void setSURVEY_NAME(String SURVEY_NAME) {
        this.SURVEY_NAME = SURVEY_NAME;
    }

    public int getSURVEY_USER_ID() {
        return SURVEY_USER_ID;
    }

    public void setSURVEY_USER_ID(int SURVEYUSER_ID) {
        this.SURVEY_USER_ID = SURVEYUSER_ID;
    }

    public Date getSURVEY_DATE() {
        return SURVEY_DATE;
    }

    public void setSURVEY_DATE(Date SURVEY_DATE) {
        this.SURVEY_DATE = SURVEY_DATE;
    }

    public String getSURVEY_PLACE() {
        return SURVEY_PLACE;
    }

    public void setSURVEY_PLACE(String SURVEY_PLACE) {
        this.SURVEY_PLACE = SURVEY_PLACE;
    }
}
