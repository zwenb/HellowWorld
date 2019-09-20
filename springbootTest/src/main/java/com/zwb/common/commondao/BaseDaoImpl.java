package com.zwb.common.commondao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("baseDao")
public class BaseDaoImpl implements BaseDao {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public int save(String str, Object obj) {
        return sqlSessionTemplate.insert(str, obj);
    }

    /**
     * 批量插入
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public Object batchSave(String str, List objs) {
        return sqlSessionTemplate.insert(str, objs);
    }

    /**
     * 更新
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public int update(String str, Object obj) {
        return sqlSessionTemplate.update(str, obj);
    }

    /**
     * 批量更新
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public void batchUpdate(String str, List objs){
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        // 批量执行器
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            if (objs != null) {
                for (int i = 0, size = objs.size(); i < size; i++) {
                    sqlSession.update(str, objs.get(i));
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 批量删除
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public Object batchDelete(String str, List objs) {
        return sqlSessionTemplate.delete(str, objs);
    }

    /**
     * 删除
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public int delete(String str, Object obj) {
        return sqlSessionTemplate.delete(str, obj);
    }

    /**
     * 查询单条记录
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForObject(String str, Object obj) {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    /**
     * 查询--List
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForList(String str, Object obj) {
        return sqlSessionTemplate.selectList(str, obj);
    }

    /**
     * 查询--Map
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForMap(String str, Object obj, String key, String value) {
        return sqlSessionTemplate.selectMap(str, obj, key);
    }
}
