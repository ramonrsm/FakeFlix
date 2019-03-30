package com.example.fakeflix.Models.Entities;

import com.example.fakeflix.Models.Exceptions.DomainException;

public class Authentication {

    private static final String EMAIL = "ramonmourarsm@outlook.com";
    private static final String SENHA = "123456";

    public static boolean SignIn(String email, String senha) throws DomainException {

        if(!email.equals(EMAIL) || !senha.equals(SENHA)){
            throw new DomainException("Usuário ou senha inválidos!");
        }
        return true;
    }
}
