package com.moralok.tutorial.service;

import com.moralok.tutorial.pojo.TvSeries;
import com.moralok.tutorial.dao.TvSeriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvSeriesService {

    @Autowired
    TvSeriesDao tvSeriesDao;

    public List<TvSeries> getAllTvSeries() {
        return tvSeriesDao.getAll();
    }
}
