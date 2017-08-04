package cn.wean2016.springcloud.eurekaclient.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


/**
 * @version V1.0.0
 * @Description
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/8/3 11:36
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();

        // 让处理线程等待几秒钟
        int sleepTime = new Random().nextInt (3000);
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);

            logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

        return "hello world";
    }

}
