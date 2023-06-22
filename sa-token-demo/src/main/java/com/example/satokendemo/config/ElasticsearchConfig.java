package com.example.satokendemo.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 雨天留恋
 * @date 2023-06-12 19:27
 */
@Configuration
public class ElasticsearchConfig {


    // @Bean
    // public ElasticsearchClient elasticsearchClient() {
    //     final CredentialsProvider credentialsProvider =
    //             new BasicCredentialsProvider();
    //     credentialsProvider.setCredentials(AuthScope.ANY,
    //             new UsernamePasswordCredentials("elastic", "1326434036"));
    //
    //     RestClientBuilder builder = RestClient.builder(
    //                     new HttpHost("47.115.215.119", 9200))
    //             .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
    //                     .setDefaultCredentialsProvider(credentialsProvider));
    //     RestClient restClient = builder.build();
    //     RestClientTransport restClientTransport = new RestClientTransport(restClient, new JacksonJsonpMapper());
    //     return new ElasticsearchClient(restClientTransport);
    // }
    @Bean
    public ElasticsearchClient elasticsearchClient() {
        RestClientBuilder builder = RestClient.builder(
                        new HttpHost("47.115.215.119", 9200));
        RestClient restClient = builder.build();
        RestClientTransport restClientTransport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        return new ElasticsearchClient(restClientTransport);
    }

}
