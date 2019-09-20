package com.zwb.common.utils.jsonutils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zwb.test.UserEntity;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class JacksonUtil {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    /**
     * 将java对象转换为json字符串
     */
    public static String objToStr(Object obj) {
        try {
            String jsonStr = objectMapper.writeValueAsString(obj);
            return jsonStr;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转换为javaBean
     */
    public static <T> T jsonStrToBean(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转换为json对象
     */
    public static void jsonStrToJsonObj(String jsonObj){


    }

    @Test
    public void test(){
        UserEntity user = new UserEntity();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName("卢员外");
        user.setSex("男");
        user.setDescription("该人是宋江付出了沉重的代价才落草的，108将中武功当属第一，有勇有谋，这样的人最可怕");
        System.out.println(JacksonUtil.objToStr(user));

        String jsonStr = "{\"description\":\"该人是宋江付出了沉重的代价才落草的，108将中武功当属第一\",\"sex\":\"男\",\"userId\":\"fc5c4bc1-2b9e-44f0-8aeb-81ee3a77fd07\",\"userName\":\"卢员外\"}";
        UserEntity userEntity = JacksonUtil.jsonStrToBean(jsonStr, UserEntity.class);
        System.out.println(userEntity.getDescription());
        Map map = JacksonUtil.jsonStrToBean(jsonStr, Map.class);
        System.out.println(map.get("sex"));
    }
}
