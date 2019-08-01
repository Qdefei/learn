package com.school.learn.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author:gdf
 * @date: 2019/7/30
 * @version: 1.0
 */
@Table(name = "mv_country")
@Entity
public class MvCountry {
    @Id
    @Column(name = "sid")
    private String sid;
    @Column(name = "sname")
    private String sname;
    @Column(name = "sdesc")
    private String sdesc;
    @Column(name = "smv")
    private String smv;
    @Column(name = "sexpired")
    private String sexpired;
    @Column(name = "slastupdate")
    private String slastupdate;
    @Column(name = "slastupdateby")
    private String slastupdateby;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public String getSmv() {
        return smv;
    }

    public void setSmv(String smv) {
        this.smv = smv;
    }

    public String getSexpired() {
        return sexpired;
    }

    public void setSexpired(String sexpired) {
        this.sexpired = sexpired;
    }

    public String getSlastupdate() {
        return slastupdate;
    }

    public void setSlastupdate(String slastupdate) {
        this.slastupdate = slastupdate;
    }

    public String getSlastupdateby() {
        return slastupdateby;
    }

    public void setSlastupdateby(String slastupdateby) {
        this.slastupdateby = slastupdateby;
    }
}
