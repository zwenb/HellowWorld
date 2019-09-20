package com.zwb.config;

import com.zwb.common.commondao.BaseDao;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 获取属性配置
 *
 * @author liwei
 * @create 2018-11-01 17:10
 */
@Component
public class ProjectProperty {

    private static Logger logger = LoggerFactory.getLogger(ProjectProperty.class);

    /*@Autowired
    private BaseAnnotationMapper baseAnnotationMapper;

    private static BaseAnnotationMapper baseAnnotationMapper_static;*/

    @Autowired
    private BaseDao baseDao;

    private static BaseDao baseDaoTmp;

    @PostConstruct
    public void beforeInit() {
        //baseAnnotationMapper_static = baseAnnotationMapper;
        baseDaoTmp = baseDao;
    }


    public static Map<String, String> prop_map = new ConcurrentHashMap<>();

    public static synchronized void init_memory_cache_data() {

        try {
            if(prop_map.size()>0)return;
            //List<Map<String, Object>> list = baseAnnotationMapper_static.selectBySql("select * from justcall_project_config");
            List<Map<String, Object>> list = (List<Map<String, Object>>) baseDaoTmp.findForList("com.zwb.mapper.test.selectBySql", null);
            if (null != list && list.size() > 0) {
                for (Map<String, Object> map : list) {
                    String prop_key = map.get("prop_key") + "";
                    String prop_value = map.get("prop_value") + "";
                    prop_map.put(prop_key, prop_value);
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static  String getPropByKey(String field) {
        String back = "";
        if (prop_map.isEmpty() || prop_map.size() == 0) {
            logger.info("-----------------no init----------------->>>>>>>>>>>>>>");
            init_memory_cache_data();
            return getPropByKey(field);
        }
        back = prop_map.get(field);
        if(!TextUtils.isEmpty(back)){
            back = back.replace("{openfire_host}", prop_map.get("openfire_host"))
                    .replace("{openfire_domain_name}", prop_map.get("openfire_domain_name"))
                    .replace("{justcall_host}", prop_map.get("justcall_host"))
                    .replace("{justcall_domain_name}", prop_map.get("justcall_domain_name"))
            ;
        }
        return back;
    }
}

