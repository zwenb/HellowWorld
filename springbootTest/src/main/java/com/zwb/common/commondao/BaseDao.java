package com.zwb.common.commondao;

import java.util.List;

public interface BaseDao {
    int save(String str, Object obj);
    Object batchSave(String str, List objs);
    int update(String str, Object obj);
    void batchUpdate(String str, List objs);
    Object batchDelete(String str, List objs);
    int delete(String str, Object obj);
    Object findForObject(String str, Object obj);
    Object findForList(String str, Object obj);
    Object findForMap(String str, Object obj, String key, String value);
}
