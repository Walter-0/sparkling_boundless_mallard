package com.walteraugustine.sparkling_boundless_mallard.DAO;

import com.walteraugustine.sparkling_boundless_mallard.models.Board;
import com.walteraugustine.sparkling_boundless_mallard.models.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BoardRepository extends MongoRepository<Board, Integer> {
    Optional<Board> findById(String id);

}
