package com.wzzy.virtualmovies.movie.controller;

import com.wzzy.virtualmovies.movie.Movie;
import com.wzzy.virtualmovies.movie.service.MoviesService;
import com.wzzy.virtualmovies.usuarios.cadastrar.model.CadastrarUserModel;
import com.wzzy.virtualmovies.usuarios.cadastrar.services.CadastrarUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/movies")
public class MoviesController {

    final MoviesService moviesService;
    final CadastrarUserService cadastrarUserService;

    public MoviesController(MoviesService moviesService, CadastrarUserService cadastrarUserService) {
        this.moviesService = moviesService;
        this.cadastrarUserService = cadastrarUserService;
    }

    // Faz uma requisição e salva o filme
    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(moviesService.save(movie));
    }

    // Faz uma requisição e trás todos os filmes
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findAll());
    }

    // Faz uma requisição e trás o filme pelo id usando id
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findById(id));
    }

    // Faz uma requisição e trás o filme pelo gênero usando category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Movie>> getMoviesByCategory(@PathVariable String category) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findByCategory(category));
    }

    // Faz uma requisição e adiciona o filme aos favoritos usando o id do filme e o id do usuário
    @PostMapping("/{movieId}/favorite/{userId}")
    public ResponseEntity<Movie> favoriteMovie(@PathVariable UUID movieId, @PathVariable UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.favoriteMovie(movieId, userId));
    }

    // Faz uma requisição e adiciona o filme a lista de filmes e id do usuário
    @PostMapping("/{movieId}/addToList/{userId}")
    public ResponseEntity<Movie> addMovieToList(@PathVariable UUID movieId, @PathVariable UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.addMovieToList(movieId, userId));
    }

    // Faz uma requisição e remove o filme da lista usando id
    @GetMapping("/{id}/watch")
    public ResponseEntity<String> watchMovie(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.getMovieVideoUrl(id));
    }

    // Faz uma requisição e trás a lista de filmes usando o id do usuário
    @GetMapping("/user/{userId}/list")
    public ResponseEntity<List<Movie>> getMovieList(@PathVariable UUID userId) {
        CadastrarUserModel user = cadastrarUserService.findById(userId).orElse(null);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user.getMovieList());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Faz uma requisição e trás os filmes favoritos usando o id do usuário e o id do filme
    @GetMapping("/user/{userId}/favorites")
    public ResponseEntity<List<Movie>> getFavoriteMovies(@PathVariable UUID userId) {
        CadastrarUserModel user = cadastrarUserService.findById(userId).orElse(null);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user.getFavoriteMovies());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    // Faz uma requisição e trás o filme pelo título uando title
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findByTitulo(title));
    }

    @GetMapping("/generos")
    public ResponseEntity<List<String>> getAllGenres() {
        return ResponseEntity.status(HttpStatus.OK).body(moviesService.findAllGenres());
    }
}