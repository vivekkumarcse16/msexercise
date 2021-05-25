package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.data.P2PService;

public interface P2PServiceRepository extends MongoRepository<P2PService, String> {

}
