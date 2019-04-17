package com.zwb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mymayikt", type = "user")
@Data
public class UserEntity {
    @Id
    private String id;

    private String userName;

    private String sex;

    private int age;
}
