package com.zwb.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * test
 *
 *  ps:@RestController 相当于 @Controller 和 @RequestBody）
 *
 * @author zhangwenbo
 * @create 2018/5/22
 **/
@Controller
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "helloWorld!";
    }

    @RequestMapping("/getDemo")
    @ResponseBody
    public DemoEntity getDemo(){
        DemoEntity demo = new DemoEntity();
        demo.setId(1);
        demo.setName("zhangsan");
        demo.setCreateTime(new Date());
        demo.setRemarks("hisdjdcs");
        return demo;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<HashMap<String, Object>> list(){
        HashMap map = new HashMap(16);
        map.put("id", "123");
        map.put("sex","female");
        List list = new ArrayList();
        list.add(map);
        return list;
    }
}
