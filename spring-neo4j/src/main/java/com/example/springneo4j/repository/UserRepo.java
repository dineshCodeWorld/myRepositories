package com.example.springneo4j.repository;

import java.util.Collection;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import com.example.springneo4j.entity.User;

public interface UserRepo extends Neo4jRepository<User, Long>
{
//    @Query("MATCH (u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
//	Collection<User> getAll();
//  
}
