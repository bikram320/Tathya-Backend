package org.example.tathyabackend.repository;

import org.example.tathyabackend.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News, String> {

}