package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.SystemDict;
import com.github.mrag.livechat.common.cache.api.DictService;
import com.github.mrag.livechat.common.cache.vo.City;
import com.github.mrag.livechat.common.http.HttpResponse;
import com.github.mrag.livechat.rest.OpenApi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @DubboReference(timeout = 200000)
    private DictService dictService;

    @GetMapping("/dict/{keyName}")
    @OpenApi
    HttpResponse getDictList(@PathVariable String keyName) {
        List<SystemDict> dict = dictService.findByKey(keyName);
        return HttpResponse.ok(dict);
    }

    @GetMapping("/dict/cities")
    @OpenApi
    HttpResponse cities() {
        List<City> cities = dictService.allCities();
        return HttpResponse.ok(cities);
    }
}
