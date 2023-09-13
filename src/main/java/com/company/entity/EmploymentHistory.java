package com.company.entity;

import java.sql.Date;

public class EmploymentHistory{
    int id;
    String header;
    Date begin_date;
    Date end_date;
    String jobDescriptoin;
    int user_id;

    public EmploymentHistory() {

    }

    public EmploymentHistory(int id, String header, Date begin_date, Date end_date, String jobDescriptoin, int user_id) {
        this.id = id;
        this.header = header;
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.jobDescriptoin = jobDescriptoin;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getJobDescriptoin() {
        return jobDescriptoin;
    }

    public void setJobDescriptoin(String jobDescriptoin) {
        this.jobDescriptoin = jobDescriptoin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", begin_date=" + begin_date +
                ", end_date=" + end_date +
                ", jobDescriptoin='" + jobDescriptoin + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
