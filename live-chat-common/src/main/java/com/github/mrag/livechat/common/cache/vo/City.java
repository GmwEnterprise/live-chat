package com.github.mrag.livechat.common.cache.vo;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer cityId;
    private String cityName;
    private Integer levelId; // 层级
    private List<City> subCities;

    public Integer getCityId() {
        return cityId;
    }

    public City setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public City setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public City setLevelId(Integer levelId) {
        this.levelId = levelId;
        return this;
    }

    public List<City> getSubCities() {
        return subCities;
    }

    public City setSubCities(List<City> subCities) {
        this.subCities = subCities;
        return this;
    }
}
