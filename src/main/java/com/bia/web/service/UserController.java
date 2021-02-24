package com.bia.web.service;

import com.bia.web.ConnnectSql;
import com.bia.web.service.JsonResult;
import com.bia.web.service.Animals;
import com.bia.web.service.SendPost;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping(value="/user")
@ServletComponentScan

public class UserController extends com.bia.web.service.CorsBase {
    @GetMapping("/getUser")
    public com.bia.web.service.JsonResult user(){
        ConnnectSql myClass=new ConnnectSql();
        String sql = "SELECT ID, ProdName FROM a";
        List<Map<String,Object>> myData = myClass.returnSql(sql);
        try {
            String myPost=new SendPost().load("http://localhost:8085/user/get/a","a");
            return new com.bia.web.service.JsonResult(myPost);
        }catch (Exception e){
            return new com.bia.web.service.JsonResult(e);
        }
    }

    @RequestMapping(value="myInterface",method = RequestMethod.GET)
    public com.bia.web.service.JsonResult myInterface(){
        Animals myObject=new Animals();
        myObject.setName("shabi");
        myObject.setAge(5);
        return new com.bia.web.service.JsonResult<>(myObject);
    }
    @RequestMapping(value="/get/{username}",method = RequestMethod.GET)
    public String get(@PathVariable String username){
        Map<String,Object> myMap=new HashMap<>();
        myMap.put("test",2);
        Set<String> keySet=myMap.keySet();
        Iterator<String> child=keySet.iterator();
        myMap.get("test");
        System.out.println(myMap.get(child.next()));
        while(child.hasNext()){
            System.out.println(myMap.get(child.next()));
        }
        return "welcome," + username;
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(@RequestParam String username,@RequestParam String pwd){
        return "user:" + username + ",password:" + pwd;
    }
}
