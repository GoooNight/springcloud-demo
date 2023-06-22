package com.example.satokendemo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.satokendemo.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SaTokenDemoApplicationTests {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Test
    void contextLoads() throws IOException {
        Book book = Book.builder().id("1222").name("一本有趣的书").build();
        IndexRequest<Book> indexRequest = new IndexRequest.Builder<Book>().document(book).index("demo_message").build();
        // 运行插入语句
        IndexResponse index = elasticsearchClient.index(indexRequest);
        System.out.println(index);
        System.out.println(indexRequest.toString());
    }
    @Test
    void contextLoads_01() throws IOException {
        SearchRequest message = new SearchRequest.Builder().index("demo_message")
                .build();
        SearchResponse<Book> search = elasticsearchClient.search(message, Book.class);
        for (Hit<Book> hit : search.hits().hits()) {
            System.out.println(hit.source());
        }
    }


}
