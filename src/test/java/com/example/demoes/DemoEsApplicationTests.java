package com.example.demoes;

import com.example.demoes.entity.es.BlogEsDB;
import com.example.demoes.repository.es.BlogEsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoEsApplicationTests {

    @Autowired
    BlogEsRepository blogEsRepository;

    @Test
    void contextLoads() {
        Iterable<BlogEsDB> blogEsDBS = blogEsRepository.findAll();
        System.out.println(blogEsDBS.iterator().next().getTitle());
    }

}
