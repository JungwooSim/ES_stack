package com.example.api.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.example.api.entity"])
@ComponentScan(basePackages = ["com.example.api.service"])
class ElasticsearchConfig : AbstractElasticsearchConfiguration() {

    override fun elasticsearchClient(): RestHighLevelClient {
        val clientConfiguration : ClientConfiguration = ClientConfiguration.builder()
            .connectedTo("localhost:9200")
            .build()

        return RestClients.create(clientConfiguration).rest()
    }

    override fun elasticsearchOperations(
        elasticsearchConverter: ElasticsearchConverter,
        elasticsearchClient: RestHighLevelClient
    ): ElasticsearchOperations {
        return ElasticsearchRestTemplate(elasticsearchClient())
    }
}
