package com.zwb.common.utils.jsonutils;

import com.zwb.test.UserEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.*;

public class JsonLibUtil {

    /**
     * 将java对象转换为json字符串
     */
    public static String objToStr(Object obj) {
        JSONObject json = JSONObject.fromObject(obj);
        return json.toString();
    }
    /**
     * 将json字符串转换为javaBean
     */
    public static <T> T jsonStrToBean(String jsonStr, Class<T> objClass) {
        return (T) JSONObject.toBean(jsonStrToJsonObj(jsonStr), objClass);
    }

    /**
     * 将json字符串转换为json对象
     */
    public static JSONObject jsonStrToJsonObj(String jsonObj){
        return JSONObject.fromObject(jsonObj);
    }

    /**
     * 将json字符串转换为Map集合
     */
    public static Map jsonStrToMap(String jsonStr){
        return  JSONObject.fromObject(jsonStr);
    }

    /**
     * 将json字符串转换为List<Map>集合
     */
    public static List<Map<String, Object>> jsonStrToList(String jsonStr){
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);
        List list = new ArrayList();
        Iterator<Object> it = jsonArr.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof JSONObject) {
                list.add(jsonStrToMap(obj.toString()));
            } else {
                list.add(obj);
            }

        }
        return list;
    }

    @Test
    public void test(){
        UserEntity user = new UserEntity();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName("卢员外");
        user.setSex("男");
        user.setDescription("该人是宋江付出了沉重的代价才落草的，108将中武功当属第一，有勇有谋，这样的人最可怕");
        System.out.println(JsonLibUtil.objToStr(user));

        String jsonStr = "{\"description\":\"该人是宋江付出了沉重的代价才落草的，108将中武功当属第一\",\"sex\":\"男\",\"userId\":\"fc5c4bc1-2b9e-44f0-8aeb-81ee3a77fd07\",\"userName\":\"卢员外\"}";
        UserEntity userEntity = JsonLibUtil.jsonStrToBean(jsonStr, UserEntity.class);
        System.out.println(userEntity.getDescription());

        Map map = JsonLibUtil.jsonStrToMap(jsonStr);
        System.out.println(map.get("userId"));
    }
}
