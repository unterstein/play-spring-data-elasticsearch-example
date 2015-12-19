package models;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
public interface PersonRepository extends ElasticsearchRepository<Person, String> {

}
