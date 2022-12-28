package com.example.springneo4j.entity;

import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@NodeEntity
@Node
public class User
{
	//@GraphId
	@Id
   private Long userId;
   private String name;
   private Integer age;
   @Relationship(type = "RATED",direction = Relationship.INCOMING)
   private List<Movie> movies;
}
