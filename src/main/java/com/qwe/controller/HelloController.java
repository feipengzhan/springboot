package com.qwe.controller;

import com.qwe.pojo.User;
import com.qwe.service.UserService;
import com.qwe.utils.JedisClient;
import com.qwe.utils.JsonUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    JedisClient jedisClient;

    @Value("${name}")
    private String name;



    @RequestMapping("/he")
    //@ResponseBody
    @ApiOperation(value="该方法的作用")
    //@ApiParam("该参数是Long id")
    public  String showMessage(Long id , Model model){
       System.out.println(name+"0000000000");
       model.addAttribute(name);
        return "hello";
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers(){
        return userService.getAllUser();
    }

    @RequestMapping("/getUserRedis")
    @ResponseBody
    public List<User> getUserList(){
        String str = jedisClient.get("111");
        System.out.println("利用编写的工具类获得的值"+str);
        String jsonStr=redisTemplate.boundValueOps("111").get();
        List<User> allUser=null;
        if (jsonStr== null || jsonStr.equals("")){
            allUser=userService.getAllUser();
            String json=JsonUtils.objectToJson(allUser);
            redisTemplate.boundValueOps("111").set(json);
        }else {
            allUser=JsonUtils.jsonToList(jsonStr,User.class);
        }
        return allUser;
    }
}
