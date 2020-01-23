package br.com.wexigor.wexigor.controller;

import br.com.wexigor.wexigor.models.User;
import br.com.wexigor.wexigor.models.UserMovie;
import br.com.wexigor.wexigor.repository.UsersRepository;
import br.com.wexigor.wexigor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UsersController {

    public static int counter = 0;

    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    public User postUserList(@PathVariable int id) {

        try {
            return this.userService.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found :)");
        }

    }

    @GetMapping("/movies")
    public List<UserMovie> postUserMoviesList() {
        //return usersRepository.getMovieByUser();
        return this.userService.getUsersAndMovies();
    }

}
