package com.zwb.test;

import com.zwb.common.commondao.BaseDao;
import com.zwb.config.ProjectProperty;
import com.zwb.test.spring_chain_pattern.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlSessionDaoTest {

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private ProjectProperty projectProperty;

    @Autowired
    private ApplicationService applicationService;
    
    @Test
    public void test(){
        /*System.out.println(baseDao);
        List list = (List)baseDao.findForList("com.zwb.mapper.test.selectBySql", null);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }*/

        //System.out.println(projectProperty.getPropByKey("justcall_host"));

    }

}
