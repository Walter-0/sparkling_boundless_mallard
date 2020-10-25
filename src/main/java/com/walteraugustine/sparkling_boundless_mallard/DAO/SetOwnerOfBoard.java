package com.walteraugustine.sparkling_boundless_mallard.DAO;

import com.walteraugustine.sparkling_boundless_mallard.models.Board;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Board.class)
public class SetOwnerOfBoard {
    @HandleBeforeCreate
    public void handleCreate(Board board) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Creating board " + board.getName() + " with user: " + username);
        board.setOwner(username);
    }
}
