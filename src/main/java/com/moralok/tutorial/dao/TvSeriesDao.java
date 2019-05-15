package com.moralok.tutorial.dao;

import com.moralok.tutorial.pojo.TvSeries;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TvSeriesDao {

    @Select("select * from tv_series")
    public List<TvSeries> getAll();
}
