package com.example.opc;

public class uploadPDF {
    public String company,year,url,name;
    public uploadPDF(){}
    public uploadPDF(String company, String year, String name,String url) {
        this.company = company;
        this.year = year;
        this.url = url;
        this.name=name;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
