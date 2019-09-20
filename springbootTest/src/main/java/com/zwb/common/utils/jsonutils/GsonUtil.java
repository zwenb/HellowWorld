package com.zwb.common.utils.jsonutils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.zwb.test.UserEntity;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GsonUtil {

    private static Gson gson;
    private static JsonParser jsonParser;

    static {
        gson = new Gson();
        jsonParser = new JsonParser();
    }

    /**
     * 将java对象转换为json字符串
     */
    public static String objToStr(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * 将json字符串转换为javaBean
     */
    public static <T> T jsonStrToBean(String jsonStr, Class<T> objClass) {
        return gson.fromJson(jsonStr, objClass);
    }

    /**
     * 将json字符串转换为json对象
     */
    public static JsonObject jsonStrToJsonObj(String jsonObj){
        return jsonParser.parse(jsonObj).getAsJsonObject();
    }

    /**
     * 将json字符串转换为Map集合(可以用 jsonStrToBean 方法代替)
     */
    public static Map jsonStrToMap(String jsonStr){
        return  gson.fromJson(jsonStr,Map.class);
    }

    /**
     * 将json字符串转换为List<Map>集合
     */
    public static List<Map<String, Object>> jsonStrToList(String jsonStr){
        return gson.fromJson(jsonStr, new TypeToken<List<Map>>(){}.getType());
    }

    /**
     * 将json字符串转换为List集合(list里面存任意类型，除实体对象以外)
     */
    public static <T> List<T> jsonStrToList2(String jsonStr) {
        Type type = new TypeToken<List<T>>(){}.getType();
        List<T> list = gson.fromJson(jsonStr,type);
        return list;
    }

    @Test
    public void test(){
        UserEntity user = new UserEntity();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName("卢员外");
        user.setSex("男");
        user.setDescription("该人是宋江付出了沉重的代价才落草的，108将中武功当属第一，有勇有谋，这样的人最可怕");
        System.out.println(GsonUtil.objToStr(user));

        String s1 = "{\"userId\":\"c099788d-09a5-46d7-aeae-094b3228d7c3\",\"userName\":\"卢员外\",\"sex\":\"男\",\"description\":\"该人是宋江付出了沉重的代价才落草的，108将中武功当属第一，有勇有谋，这样的人最可怕\"}";
        UserEntity u = GsonUtil.jsonStrToBean(s1, UserEntity.class);
        System.out.println(u.getDescription());

        System.out.println(GsonUtil.jsonStrToJsonObj(s1).get("userId"));

        Map map = FastJsonUtil.jsonStrToBean(s1, Map.class);
        System.out.println(map.get("sex"));

        String listStr = "[{\"小摆件\":\"xiasohjs\",\"xiaojhia\":\"xiaoji\"},{\"eee\":123213,\"ddd\":\"张文波\",\"www\":\"wqww\"}]";
        System.out.println(GsonUtil.jsonStrToList(listStr));

        String s = "[\"1221221\",\"dsdsds\",212212]";
        List resultList = GsonUtil.jsonStrToList2(s);
        System.out.println(resultList);

        List list = new ArrayList();
        list.add(user);
        System.out.println(GsonUtil.objToStr(list));

        /*String s2 = "[{\"userId\":\"b0bf3bd8-9253-4d52-b2c5-9eb10b8b1a3e\",\"userName\":\"卢员外\",\"sex\":\"男\",\"description\":\"该人是宋江付出了沉重的代价才落草的，108将中武功当属第一，有勇有谋，这样的人最可怕\"}]";
        List<UserEntity> list1 = GsonUtil.jsonStrToList2(s2);
        UserEntity user1 = list1.get(0);
        System.out.println(list1.get(0));*/

    }
}
