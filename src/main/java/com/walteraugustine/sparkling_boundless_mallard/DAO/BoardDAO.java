package com.walteraugustine.sparkling_boundless_mallard.DAO;

import com.walteraugustine.sparkling_boundless_mallard.models.Board;
import com.walteraugustine.sparkling_boundless_mallard.models.BoardUpdatePayload;
import com.walteraugustine.sparkling_boundless_mallard.models.Card;
import com.walteraugustine.sparkling_boundless_mallard.models.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class BoardDAO {
    @Autowired
    private BoardRepository repository;

    public Collection<Board> getBoards() {
        return repository.findAll();
    }

    public Optional<Board> getBoard(String id) {
        return repository.findById(id);
    }

    public Board createBoard(Board board) {
        return repository.insert(board);
    }

    public Optional<Board> updateBoardById(String id, BoardUpdatePayload boardUpdatePayload) {
        Optional<Board> board = repository.findById(id);

        board.ifPresent(b -> b.setName(boardUpdatePayload.getName()));
        board.ifPresent(b -> repository.save(b));

        return board;
    }

    public Optional<Board> deleteBoard(String id) {
        Optional<Board> board = repository.findById(id);

        board.ifPresent(b -> repository.delete(b));

        return board;
    }

    public Optional<Board> addList(String boardId, List list) {
        Optional<Board> board = repository.findById(boardId);

        board.ifPresent(b -> b.addList(list));
        board.ifPresent(b -> repository.save(b));

        return board;
    }

//    public Optional<Board> addCardToList(String boardId, String listName, Card card) {
//        Optional<Board> board = repository.findById(boardId);
//        board.ifPresent(b -> b.addCardToList(listName, card));
//        board.ifPresent(b -> repository.save(b));
//        return board;
//    }
}
