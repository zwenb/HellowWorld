package com.zwb.common.utils.jsonutils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zwb.test.UserEntity;
import org.junit.Test;

import java.util.*;

public class FastJsonUtil {

    /**
     * 将java对象转换为json字符串
     */
    public static String objToStr(Object obj) {
       return JSON.toJSONString(obj);
     }

    /**
     * 将json字符串转换为javaBean
     */
     public static <T> T jsonStrToBean(String jsonStr, Class<T> objClass) {
         return JSON.parseObject(jsonStr, objClass);
     }

    /**
     * 将json字符串转换为json对象
     */
    public static JSONObject jsonStrToJsonObj(String jsonObj){
        return JSON.parseObject(jsonObj);
    }

    /**
     * 将json字符串转换为Map集合
     */
    public static Map jsonStrToMap(String jsonStr){
        return  JSON.parseObject(jsonStr);
    }

    /**
     * 将json字符串转换为List<Map>集合
     */
    public static List<Map<String, Object>>  jsonStrToList(String jsonStr){
       return JSONObject.parseObject(jsonStr, new TypeReference<List<Map<String, Object>>>(){});
    }

    /**
     * 将json字符串转换为List集合(list里面存任意类型，除实体对象以外)
     */
    public static <T> T jsonStrToList2(String jsonStr){
        return JSONObject.parseObject(jsonStr, new TypeReference<T>(){});
    }


    @Test
    public void test() {
        UserEntity user = new UserEntity();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName("卢员外");
        user.setSex("男");
        user.setDescription("该人是宋江付出了沉重的代价才落草的，108将中武功当属第一，有勇有谋，这样的人最可怕");
        System.out.println(FastJsonUtil.objToStr(user));

        String jsonStr = "{\"description\":\"该人是宋江付出了沉重的代价才落草的，108将中武功当属第一\",\"sex\":\"男\",\"userId\":\"fc5c4bc1-2b9e-44f0-8aeb-81ee3a77fd07\",\"userName\":\"卢员外\"}";
        UserEntity userEntity = FastJsonUtil.jsonStrToBean(jsonStr, UserEntity.class);
        System.out.println(userEntity.getDescription());

        JSONObject jsonObj = FastJsonUtil.jsonStrToJsonObj(jsonStr);
        System.out.println(jsonObj.get("userName"));

        Map map = FastJsonUtil.jsonStrToMap(jsonStr);
        System.out.println(map.get("sex"));

        List list = new ArrayList();
        Map map1 = new HashMap();
        map1.put("xiaojhia", "xiaoji");
        map1.put("小摆件", "xiasohjs");
        Map map2 = new HashMap();
        map2.put("www", "wqww");
        map2.put("eee", 123213);
        map2.put("ddd", "张文波");
        list.add(map1);
        list.add(map2);
        System.out.println(FastJsonUtil.objToStr(list));
        String listStr = "[{\"小摆件\":\"xiasohjs\",\"xiaojhia\":\"xiaoji\"},{\"eee\":123213,\"ddd\":\"张文波\",\"www\":\"wqww\"}]";
        List<Map<String, Object>> tmp = new ArrayList<>();
        List resultList = FastJsonUtil.jsonStrToList(listStr);
        System.out.println(resultList);

        List list2 = new ArrayList();
        list2.add("1221221");
        list2.add("dsdsds");
        list2.add(212212);
        list.add("小红");
        System.out.println(FastJsonUtil.objToStr(list2));
        String s = "[\"1221221\",\"dsdsds\",212212]";
        List resultList2 = FastJsonUtil.jsonStrToList2(s);
        System.out.println(resultList2);

        /*String s2 = "[{\"userId\":\"b0bf3bd8-9253-4d52-b2c5-9eb10b8b1a3e\",\"userName\":\"卢员外\",\"sex\":\"男\",\"description\":\"该人是宋江付出了沉重的代价才落草的，108将中武功当属第一，有勇有谋，这样的人最可怕\"}]";
        List<UserEntity> list1 = FastJsonUtil.jsonStrToList2(s2);
        System.out.println(list1.get(0).getDescription());*/
    }

}
