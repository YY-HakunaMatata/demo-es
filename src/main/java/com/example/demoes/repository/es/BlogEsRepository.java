package com.example.demoes.repository.es;

import com.example.demoes.entity.es.BlogEsDB;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Mr.PengYY
 * @date 2021-03-02 17:49
 * @description:
 */
public interface BlogEsRepository extends ElasticsearchRepository<BlogEsDB, Integer> {

}
