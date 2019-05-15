package com.moralok.tutorial.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moralok.tutorial.TvCharacterDto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class TvSeries {
    @Null private Integer id;
    @NotNull private String name;
    @DecimalMin("1") private int seasonCount;
    @Valid @NotNull @Size(min = 2) private List<TvCharacterDto> tvCharacters;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @Past private Date originalRelease;

    public TvSeries() {

    }

    public TvSeries(int id, String name, int seasonCount, Date originalRelease) {
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

    public List<TvCharacterDto> getTvCharacters() {
        return tvCharacters;
    }

    public void setTvCharacters(List<TvCharacterDto> tvCharacters) {
        this.tvCharacters = tvCharacters;
    }

    public Date getOriginalRelease() {
        return originalRelease;
    }

    public void setOriginalRelease(Date originalRelease) {
        this.originalRelease = originalRelease;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{id=" + id + ";name=" + name + "}";
    }
}
