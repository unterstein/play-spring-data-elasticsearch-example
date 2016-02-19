package modules;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import
import org.elasticsearch.node.NodeBuilder;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "models")
@ComponentScan({"models", "controllers"})
public class JavaElasticSearchConfiguration implements DisposableBean {

  private Settings elasticsearchSettings = ImmutableSettings.settingsBuilder().put("path.home", "target/elastic").put("http.port", 8200).build();
  private Node node = NodeBuilder.nodeBuilder().local(true).settings(elasticsearchSettings).node();
  private Client client = node.client();

  @Bean
  public ElasticsearchTemplate elasticsearchTemplate() {
    return new ElasticsearchTemplate(client);
  }

  @Bean
  public Client elasticSearchClient() {
    return client;
  }


  @Override
  public void destroy() throws Exception {
    node.close();
    client.close();
  }
}
