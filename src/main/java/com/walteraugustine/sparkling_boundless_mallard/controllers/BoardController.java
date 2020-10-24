package com.walteraugustine.sparkling_boundless_mallard.controllers;

import com.walteraugustine.sparkling_boundless_mallard.models.Board;
import com.walteraugustine.sparkling_boundless_mallard.models.BoardUpdatePayload;
import com.walteraugustine.sparkling_boundless_mallard.models.Card;
import com.walteraugustine.sparkling_boundless_mallard.models.List;
import com.walteraugustine.sparkling_boundless_mallard.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public Collection<Board> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping(value="/{id}")
    public Optional<Board> getBoard(@PathVariable("id") String id) {
        return boardService.getBoard(id);
    }

    @PostMapping
    public Board postBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    @PutMapping(value="/{id}")
    public Optional<Board> updateBoardById(@PathVariable("id") String id, @RequestBody BoardUpdatePayload boardUpdatePayload) {
        return boardService.updateBoardById(id, boardUpdatePayload);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Board> deleteBoardById(@PathVariable("id") String id) {
        return boardService.deleteBoardById(id);
    }

    @PostMapping(value="/{id}")
    public Optional<Board> addList(@PathVariable("id") String boardId, @RequestBody List list) {
        return boardService.addList(boardId, list);
    }

//    @PostMapping(value="/{id}/list/{listName}")
//    public Optional<Board> addCardToList(@PathVariable("id") String boardId, @PathVariable("listName") String listName, @RequestBody Card card) {
//        return boardService.addCardToList(boardId, listName, card);
//    }
}
