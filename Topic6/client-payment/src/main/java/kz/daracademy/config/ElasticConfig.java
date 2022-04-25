package kz.daracademy.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticConfig extends AbstractElasticsearchConfiguration {
    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("client-payment.es.us-central1.gcp.cloud.es.io:9243")
                //.connectedTo(("localhost:9200"))
                .usingSsl()
                .withBasicAuth("elastic", "FStB0yVJkuSR7EGV72ZtVoj6")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
