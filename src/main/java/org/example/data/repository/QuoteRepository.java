package org.example.data.repository;

import org.example.data.model.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends MongoRepository<Quote, String> {
    Quote findQuoteById(String id);

    boolean existsById(String id);


    void deleteById(String id);

    @Override
    long count();
}

