package com.walteraugustine.sparkling_boundless_mallard.services;

import com.walteraugustine.sparkling_boundless_mallard.DAO.BoardDAO;
import com.walteraugustine.sparkling_boundless_mallard.models.Board;
import com.walteraugustine.sparkling_boundless_mallard.models.BoardUpdatePayload;
import com.walteraugustine.sparkling_boundless_mallard.models.Card;
import com.walteraugustine.sparkling_boundless_mallard.models.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardDAO boardDAO;

    public Collection<Board> getBoards() {
        return boardDAO.getBoards();
    }

    public Optional<Board> getBoard(String id) {
        return boardDAO.getBoard(id);
    }

    public Board createBoard(Board board) {
        return boardDAO.createBoard(board);
    }

    public Optional<Board> updateBoardById(String id, BoardUpdatePayload boardUpdatePayload) {
        return boardDAO.updateBoardById(id, boardUpdatePayload);
    }

    public Optional<Board> deleteBoardById(String id) {
        return boardDAO.deleteBoard(id);
    }

    public Optional<Board> addList(String boardId, List list) {
        return boardDAO.addList(boardId, list);
    }

//    public Optional<Board> addCardToList(String boardId, String listName, Card card) {
//        return boardDAO.addCardToList(boardId, listName, card);
//    }
}
