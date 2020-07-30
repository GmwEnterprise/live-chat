package com.github.mrag.livechat.test.consumer.usermsg;

import com.github.mrag.livechat.common.Constants;
import com.github.mrag.livechat.usermsg.api.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UsermsgConsumer {
    @DubboReference(
            timeout = 3000,
            url = "dubbo://172.25.96.1:20880",
            group = Constants.DUBBO_SERV_GROUP,
            version = Constants.DUBBO_SERV_VERSION)
    UserService userService;

    @Bean
    ApplicationRunner runner() {
        return args -> {
            if (userService.findUserById(1L) == null) {
                System.out.println("消费成功");
            }
        };
    }
}
