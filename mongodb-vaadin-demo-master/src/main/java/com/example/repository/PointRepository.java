package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.data.Point;

public interface PointRepository extends MongoRepository<Point, String> {

}
