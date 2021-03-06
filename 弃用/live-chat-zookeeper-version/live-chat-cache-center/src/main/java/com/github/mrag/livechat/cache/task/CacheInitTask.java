// 弃用   觉得枚举就不需要写进数据库好了
/*
package com.github.mrag.livechat.cache.task;

import com.github.mrag.livechat.common.SystemDict;
import com.github.mrag.livechat.common.cache.api.DictService;
import com.github.mrag.livechat.common.constant.enums.DictEnumInterface;
import com.github.mrag.livechat.common.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;

*/
/**
 * @author Gmw
 *//*

@Component
public class CacheInitTask {
    private static final Logger log = LoggerFactory.getLogger(CacheInitTask.class);

    @Resource
    private DictService dictService;

    @PostConstruct
    public void init() {
        // 加载common module下的enums常量，获取其数据，提取，并用来初始化数据库
        String common = Arrays.stream(System.getProperty("java.class.path").split(";"))
                .filter(path -> path.contains("live-chat-common")).findFirst().orElse(null);
        if (common == null) {
            return;
        }
        String packagePath = common + "\\com\\github\\mrag\\livechat\\common\\constant\\enums\\";
        Tools.handleFiles(new File(packagePath), file -> {
            try {
                String className = file.getName().replace(".class", "");
                Class<?> enumClass = Class.forName("com.github.mrag.livechat.common.constant.enums." + className);
                boolean isEnum = enumClass.getSuperclass() != null && enumClass.getSuperclass().equals(Enum.class);
                boolean isDictEnum = Arrays.asList(enumClass.getInterfaces()).contains(DictEnumInterface.class);
                if (isDictEnum && isEnum) {
                    Method valuesMethod = enumClass.getMethod("values");
                    DictEnumInterface[] dictInstances = (DictEnumInterface[]) valuesMethod.invoke(null);
                    for (DictEnumInterface dictEnum : dictInstances) {
                        // 更新数据库字典表
                        SystemDict dictItem = new SystemDict();
                        dictItem.setKey(dictEnum.getKey());
                        dictItem.setKeyDesc(dictEnum.getKeyDesc());
                        dictItem.setValueNo(dictEnum.getValueNo());
                        dictItem.setValueDesc(dictEnum.getValueDesc());
                        // 枚举属性没有依赖关系
                        dictItem.setDependencyOnId(0);
                        // 枚举属性不允许后期修改
                        dictItem.setCanModify(SystemDict.CANNOT_MODIFY);
                        dictItem.setValueMoreDetail(null);
                        dictService.save(dictItem);
                    }
                }
            } catch (Exception e) {
                log.error("Error[{}]: {}", e.getClass(), e.getMessage());
            }
            return null;
        });
    }
}
*/
