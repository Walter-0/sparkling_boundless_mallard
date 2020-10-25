package com.walteraugustine.sparkling_boundless_mallard.controllers;

import com.walteraugustine.sparkling_boundless_mallard.DAO.BoardRepository;
import com.walteraugustine.sparkling_boundless_mallard.models.Board;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {
    private BoardRepository repository;

    @GetMapping("/boards")
    public Collection<Board> getUserBoards(Principal principal) {
        System.out.println("Fetching boards for user: " + principal.getName());
        return repository.findAllByOwner(principal.getName());
    }

    @GetMapping
    public OidcUser getCurrentUser(@AuthenticationPrincipal OidcUser user) {
        return user;
    }
}
