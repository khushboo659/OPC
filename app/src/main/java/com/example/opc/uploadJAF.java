package com.example.opc;

public class uploadJAF {
    public String name,stipend,profile,link,jaf;
    public uploadJAF() {
    }

    public uploadJAF(String name, String stipend, String profile, String link, String jaf) {
        this.name = name;
        this.stipend = stipend;
        this.profile = profile;
        this.link = link;
        this.jaf = jaf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStipend() {
        return stipend;
    }

    public void setStipend(String stipend) {
        this.stipend = stipend;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getJaf() {
        return jaf;
    }

    public void setJaf(String jaf) {
        this.jaf = jaf;
    }
}
