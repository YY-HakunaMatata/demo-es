package com.example.demoes.entity.mysql;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Mr.PengYY
 * @date 2021-03-02 16:35
 * @description:
 * CREATE TABLE `t_blog` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
 *   `title` varchar(60) DEFAULT NULL COMMENT '博客标题',
 *   `author` varchar(60) DEFAULT NULL COMMENT '博客作者',
 *   `content` mediumtext COMMENT '博客内容',
 *   `list_image_url` varchar(255) DEFAULT NULL COMMENT '列表图片',
 *   `like_count` int(255) DEFAULT NULL COMMENT '点赞数',
 *   `comments_count` int(255) DEFAULT NULL COMMENT '评论数',
 *   `forward_count` int(255) DEFAULT NULL COMMENT '转发数',
 *   `read_count` int(255) DEFAULT NULL COMMENT '阅读数',
 *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 *   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=392 DEFAULT CHARSET=utf8mb4;
 */
@Data
@Entity
@Table(name = "t_blog")
public class BlogDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    @Column(columnDefinition = "mediumtext")
    private String content;
    private String listImageUrl;
    private Integer likeCount;
    private Integer commentsCount;
    private Integer forwardCount;
    private Integer readCount;
    private Date createTime;
    private Date updateTime;

}

