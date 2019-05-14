package com.moralok.tutorial;

import java.util.Date;

public class TvSeriesDto {
    private int id;
    private String name;
    private int seasonCount;
    private Date originalRelease;

    public TvSeriesDto() {

    }

    public TvSeriesDto(int id, String name, int seasonCount, Date originalRelease) {
        this.id = id;
        this.name = name;
        this.seasonCount = seasonCount;
        this.originalRelease = originalRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
    }

    public Date getOriginalRelease() {
        return originalRelease;
    }

    public void setOriginalRelease(Date originalRelease) {
        this.originalRelease = originalRelease;
    }


}
