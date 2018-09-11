package com.derily.ch4.bean;

public class Student extends Person {
    public long getEnrolledsince() {
        return enrolledsince;
    }

    public void setEnrolledsince(long enrolledsince) {
        this.enrolledsince = enrolledsince;
    }

    private long enrolledsince;


}
