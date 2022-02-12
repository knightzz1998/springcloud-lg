package cn.knightzz.page.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 王天赐
 * @title: MetadataController
 * @projectName springcloud-lg
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2022/2/12 10:51
 */
@RestController
@RequestMapping("/metadata")
public class MetadataController {

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("show")
    public String showMetaData() {

        StringBuilder result = new StringBuilder();
        // 获取实例, 因为是集群方式, 所以一个微服务可能会有多个服务
        List<ServiceInstance> instances = discoveryClient.getInstances("lg-service-page");
        for (ServiceInstance instance : instances) {
            // 获取服务元数据
            Map<String, String> metadata = instance.getMetadata();
            Set<Map.Entry<String, String>> entries = metadata.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                String key = entry.getKey();
                String value = entry.getValue();
                result.append("key:").append(key).append(",value:").append(value);
            }
        }
        return result.toString();
    }
}
