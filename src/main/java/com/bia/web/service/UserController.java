package com.bia.web.service;

import com.bia.web.ConnnectSql;
import com.bia.web.service.JsonResult;
import com.bia.web.service.Animals;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value="/user")
@ServletComponentScan

public class UserController extends com.bia.web.service.CorsBase {
    @GetMapping("/getUser")
    public String user(){
        ConnnectSql myClass=new ConnnectSql();
        String[] myData = myClass.returnSql();
        StringBuffer str5 = new StringBuffer();
        for (String s : myData) {
            str5.append(s);
        }
        return str5.toString();
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
