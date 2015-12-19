package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
@Document(indexName = "person")
public class Person {

  @Id
  public String id;

  public String name;

}
