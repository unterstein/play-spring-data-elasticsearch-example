package modules

import org.elasticsearch.client.Client
import org.elasticsearch.common.settings.{ImmutableSettings, Settings}
import org.elasticsearch.node.Node
import org.elasticsearch.node.NodeBuilder._
import org.springframework.context.annotation.{ComponentScan, Bean, Configuration}
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = Array("models"))
@ComponentScan(Array("models", "controllers"))
class ElasticSearchConfiguration {

  private val elasticsearchSettings: Settings = ImmutableSettings.settingsBuilder.put("path.home", "target/elastic").put("http.port", 8200).build
  private val node: Node = nodeBuilder.local(true).settings(elasticsearchSettings).node
  private val client: Client = node.client

  @Bean
  @throws(classOf[Exception])
  def elasticsearchTemplate: ElasticsearchTemplate = new ElasticsearchTemplate(client)

  @Bean def elasticSearchClient: Client = client

  @throws(classOf[Exception])
  def destroy {
    node.close()
    client.close()
  }
}
