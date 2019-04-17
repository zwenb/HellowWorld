package com.zwb.test;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 实体类
 *
 * @author zhangwenbo
 * @create 2018/5/23
 **/
public class DemoEntity {
    private int id ;
    private String name;

    @JSONField(format="yyyy-MM-dd HH:mm")
    private Date createTime;//创建时间.

    @JSONField(serialize=false)
    private String remarks;//备注信息.

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
