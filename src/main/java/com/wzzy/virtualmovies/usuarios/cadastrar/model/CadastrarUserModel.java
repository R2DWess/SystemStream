package com.wzzy.virtualmovies.usuarios.cadastrar.model;

import com.wzzy.virtualmovies.movie.Movie;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "TB_USERS_STREAM")
public class CadastrarUserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 255)
    private String cpf;

    @Column(nullable = false, length = 255)
    private String fullname;

    @Column(length = 255)
    private String socialname;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(length = 255)
    private String rg;

    @Column(nullable = false, length = 255)
    private String cellphone;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @OneToMany
    private List<Movie> movieList;

    @OneToMany
    private List<Movie> favoriteMovies;

    @Column(nullable = false)
    private boolean isAdmin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSocialname() {
        return socialname;
    }

    public void setSocialname(String socialname) {
        this.socialname = socialname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setFavoriteMovies(List<Movie> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }
}
