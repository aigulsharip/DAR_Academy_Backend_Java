package kz.daracademy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "post-core-api")
public interface PostFeign {

    @GetMapping("/post/check")
    String checkPostApi();

}
