package com.wzzy.virtualmovies.unit.cadastrar.service;

import com.wzzy.virtualmovies.usuarios.cadastrar.model.CadastrarUserModel;
import com.wzzy.virtualmovies.usuarios.cadastrar.repository.CadastrarUserRepository;
import com.wzzy.virtualmovies.usuarios.cadastrar.services.CadastrarUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CadastrarUserServiceTest {

    @Mock
    private CadastrarUserRepository cadastrarUserRepository;

    @InjectMocks
    private CadastrarUserService cadastrarUserService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarUserSuccess() {
        CadastrarUserRepository mockRepository = Mockito.mock(CadastrarUserRepository.class);
        CadastrarUserService service = new CadastrarUserService(mockRepository);
        CadastrarUserModel userModel = new CadastrarUserModel();
        userModel.setEmail("test@test.com");
        userModel.setPassword("password");
        when(mockRepository.existsByEmail(userModel.getEmail())).thenReturn(false);
        when(mockRepository.existsByCpf(userModel.getCpf())).thenReturn(false);
        when(mockRepository.save(userModel)).thenReturn(userModel);

        boolean result = service.cadastrarUser(userModel);

        assertEquals(true, result);
    }

    @Test
    public void testCadastrarUserFailure() {
        doReturn(true).when(cadastrarUserRepository).existsByEmail("test@example.com");

        CadastrarUserModel newUser = new CadastrarUserModel();
        newUser.setEmail("test@example.com");
        newUser.setCpf("12345678900");
        boolean result = cadastrarUserService.cadastrarUser(newUser);

        assertFalse(result);
    }

    @Test
    public void testCadastrarUserException() {
        doThrow(new RuntimeException("Erro ao cadastrar usuário")).when(cadastrarUserRepository).save(any(CadastrarUserModel.class));

        CadastrarUserModel newUser = new CadastrarUserModel();
        newUser.setEmail("new@example.com");
        newUser.setCpf("12345678900");

        assertThrows(RuntimeException.class, () -> {
            cadastrarUserService.cadastrarUser(newUser);
        });
    }
}