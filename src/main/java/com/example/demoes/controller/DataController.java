package com.example.demoes.controller;

import com.example.demoes.entity.es.BlogEsDB;
import com.example.demoes.entity.mysql.BlogDB;
import com.example.demoes.repository.es.BlogEsRepository;
import com.example.demoes.repository.mysql.BlogRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.MoreLikeThisQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Mr.PengYY
 * @date 2021-03-02 17:55
 * @description:
 */
@RestController
public class DataController {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    BlogEsRepository blogEsRepository;
    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/blogs")
    public Object blogs(){
        List<BlogDB> blogDBList = blogRepository.findAll();
        return blogDBList;
    }

    @GetMapping("/search")
    public Object search(String keyword, int type){
        Map<String, Object> resultMap = new HashMap<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        if (type == 0){
            List<BlogDB> blogDBList = blogRepository.queryBlogDBs(keyword);
            resultMap.put("list", blogDBList);
        }else if (type == 1){
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("title", keyword));
            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("content", keyword));
            System.out.println(boolQueryBuilder.toString());
            NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(boolQueryBuilder);
            SearchHits<BlogEsDB> search = elasticsearchRestTemplate.search(nativeSearchQuery, BlogEsDB.class);
            List<BlogEsDB> blogEsDBList = new ArrayList<>();
            Iterator<SearchHit<BlogEsDB>> iterator = search.stream().iterator();
            while (iterator.hasNext()){
                SearchHit<BlogEsDB> next = iterator.next();
                BlogEsDB blogEsDB = next.getContent();
                blogEsDBList.add(blogEsDB);
            }
            resultMap.put("list", blogEsDBList);
        }else {
            return "I don't know this type, please pass in either 0 (MySQL) or 1 (Search Engine)!";
        }
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        System.out.println("查询耗时：" + totalTimeMillis + "毫秒");
        resultMap.put("queryTime", totalTimeMillis);
        return resultMap;
    }
}
