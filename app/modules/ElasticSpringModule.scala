package modules

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.guice.module.SpringModule


class ElasticSpringModule extends SpringModule(new AnnotationConfigApplicationContext(classOf[ElasticSearchConfiguration]))
