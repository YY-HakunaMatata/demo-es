package com.example.demoes.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author Mr.PengYY
 * @date 2021-03-02 17:29
 * @description:
 */
@Configuration
@EnableElasticsearchRepositories
public class RestClientConfig extends AbstractElasticsearchConfiguration {
    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedToLocalhost().build();
        return RestClients.create(clientConfiguration).rest();
    }
}
