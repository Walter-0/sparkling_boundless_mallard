package com.walteraugustine.sparkling_boundless_mallard.DAO;

import com.walteraugustine.sparkling_boundless_mallard.models.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.Optional;

public interface BoardRepository extends MongoRepository<Board, Integer> {
    Optional<Board> findById(String id);

    Collection<Board> findAllByOwner(String name);
}
