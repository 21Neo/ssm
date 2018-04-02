package com.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

public class TMember implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer mId;
    private String mName;
    private String mPhone;
    private Integer mLevel;
    private Date mInTime;
    private String mCardNo;

    public TMember(Integer mId, String mName, String mPhone, Integer mLevel, Date mInTime, String mCardNo) {
        this.mId = mId;
        this.mName = mName;
        this.mPhone = mPhone;
        this.mLevel = mLevel;
        this.mInTime = mInTime;
        this.mCardNo = mCardNo;
    }

    public TMember() {
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public Integer getmLevel() {
        return mLevel;
    }

    public void setmLevel(Integer mLevel) {
        this.mLevel = mLevel;
    }

    public Date getmInTime() {
        return mInTime;
    }

    public void setmInTime(Date mInTime) {
        this.mInTime = mInTime;
    }

    public String getmCardNo() {
        return mCardNo;
    }

    public void setmCardNo(String mCardNo) {
        this.mCardNo = mCardNo;
    }
}
