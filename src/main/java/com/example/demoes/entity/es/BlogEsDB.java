package com.example.demoes.entity.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author Mr.PengYY
 * @date 2021-03-02 17:38
 * @description:
 */
@Data
@Document(indexName = "blog", useServerConfiguration = true,createIndex = false)
public class BlogEsDB {
    @Id
    private Integer id;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String author;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String listImageUrl;
    @Field(type = FieldType.Integer)
    private Integer likeCount;
    @Field(type = FieldType.Integer)
    private Integer commentsCount;
    @Field(type = FieldType.Integer)
    private Integer forwardCount;
    @Field(type = FieldType.Integer)
    private Integer readCount;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || epoch_millis")
    private Date createTime;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || epoch_millis")
    private Date updateTime;
}
