package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.SystemDict;
import com.github.mrag.livechat.common.cache.api.DictService;
import com.github.mrag.livechat.common.cache.vo.City;
import com.github.mrag.livechat.common.http.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "缓存服务")
@RestController
@RequestMapping("/cache")
public class CacheController {

    @DubboReference
    private DictService dictService;

    @ApiOperation("通过key查询valueList")
    @GetMapping("/dict/{keyName}")
    HttpResponse getDictList(@ApiParam(value = "键", required = true)
                             @PathVariable String keyName) {
        List<SystemDict> dict = dictService.findByKey(keyName);
        return HttpResponse.ok(dict);
    }

    @ApiOperation("获取所有城市列表")
    @GetMapping("/dict/cities")
    HttpResponse cities() {
        List<City> cities = dictService.allCities();
        return HttpResponse.ok(cities);
    }
}
