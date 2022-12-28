package com.example.springneo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories;

@SpringBootApplication
//@EnableNeo4jRepositories
//@EnableReactiveNeo4jRepositories
//@EnableNeo4jAuditing
public class SpringNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNeo4jApplication.class, args);
	}

}
