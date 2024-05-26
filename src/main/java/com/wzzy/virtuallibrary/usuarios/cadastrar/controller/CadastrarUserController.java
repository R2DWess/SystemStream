package com.wzzy.virtuallibrary.usuarios.cadastrar.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.wzzy.virtuallibrary.usuarios.cadastrar.services.CadastrarUserService;
import com.wzzy.virtuallibrary.usuarios.login.services.LoginUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wzzy.virtuallibrary.usuarios.cadastrar.model.CadastrarUserModel;

@RestController
@CrossOrigin("*")
@RequestMapping("/cadastrar")
public class CadastrarUserController {

    final CadastrarUserService cadastrarUserService;

    @Autowired
    LoginUserService loginUserService;

    public CadastrarUserController(CadastrarUserService cadastrarUserService) {
        this.cadastrarUserService = cadastrarUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CadastrarUserModel CadastrarUserDto) {
        boolean isRegistered = loginUserService.cadastrarUser(CadastrarUserDto);
        if (isRegistered) {
            return ResponseEntity.ok("Registration successful");
        } else {
            return ResponseEntity.status(400).body("Registration failed");
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Validated CadastrarUserModel cadastrarUserModel) {

        if (cadastrarUserService.existsByCpf(cadastrarUserModel.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF is already in use!");
        }

        if (cadastrarUserService.existsByEmail(cadastrarUserModel.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Email is already in use!");
        }

        if (cadastrarUserService.existsBySocialname(cadastrarUserModel.getSocialname())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Social name is already in use!");
        }

        CadastrarUserModel newUserModel = new CadastrarUserModel();
        BeanUtils.copyProperties(cadastrarUserModel, newUserModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastrarUserService.save(newUserModel));
    }

    @GetMapping
    public ResponseEntity<List<CadastrarUserModel>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(cadastrarUserService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id) {
        Optional<CadastrarUserModel> userModelOptional = cadastrarUserService.findById(id);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id) {
        Optional<CadastrarUserModel> userModelOptional = cadastrarUserService.findById(id);
        if (userModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        cadastrarUserService.delete(userModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Validated CadastrarUserModel cadastrarUserModel) {
        Optional<CadastrarUserModel> userModelOptional = cadastrarUserService.findById(id);
        if (userModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        CadastrarUserModel existingUserModel = userModelOptional.get();
        BeanUtils.copyProperties(cadastrarUserModel, existingUserModel);
        cadastrarUserService.save(existingUserModel);
        return ResponseEntity.status(HttpStatus.OK).body(cadastrarUserService.save(existingUserModel));
    }
}