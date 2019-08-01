package com.school.learn.back.entity;

import javax.persistence.*;

/**
 * @author:gdf
 * @date: 2019/7/29
 * @version: 1.0
 */
@Entity
@Table(name="image")
public class Image {
    @Id
    @Column(name="sid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;
    @Column(name = "name")
    private String name;
    @Column(name = "ig")
    private String ig;
    @Column(name = "src")
    private String src;
    @Column(name = "expired")
    private String expired;
    @Column(name = "lastupdate")
    private String lastupdate;
    @Column(name = "lastupdateby")
    private String lastupdateby;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIg() {
        return ig;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getLastupdateby() {
        return lastupdateby;
    }

    public void setLastupdateby(String lastupdateby) {
        this.lastupdateby = lastupdateby;
    }
}
