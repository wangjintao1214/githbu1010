package com.kgc.springssm.pojo;

import java.util.Date;

public class Standard {
    private Integer id;

    private String stdNum;

    private String zhname;

    private String versionn;

    private String keyss;

    private Date releaseDate;

    private Date implDate;

    private String packagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStdNum() {
        return stdNum;
    }

    public void setStdNum(String stdNum) {
        this.stdNum = stdNum == null ? null : stdNum.trim();
    }

    public String getZhname() {
        return zhname;
    }

    public void setZhname(String zhname) {
        this.zhname = zhname == null ? null : zhname.trim();
    }

    public String getVersionn() {
        return versionn;
    }

    public void setVersionn(String versionn) {
        this.versionn = versionn == null ? null : versionn.trim();
    }

    public String getKeyss() {
        return keyss;
    }

    public void setKeyss(String keyss) {
        this.keyss = keyss == null ? null : keyss.trim();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getImplDate() {
        return implDate;
    }

    public void setImplDate(Date implDate) {
        this.implDate = implDate;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath == null ? null : packagePath.trim();
    }
}