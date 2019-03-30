package com.example.fakeflix.Util;

import com.example.fakeflix.Models.Entities.Client;
import com.example.fakeflix.Models.Exceptions.DomainException;

public class Helpers {

    public static boolean IsEmpty(Client client) throws DomainException {

        if(client.getEmail().isEmpty() && client.getPassword().isEmpty()){
            throw new DomainException("Digite seu e-mail e senha");
        }

        if(client.getEmail().isEmpty()){
            throw new DomainException("Digite seu e-mail");
        }

        if(client.getPassword().isEmpty()){
            throw new DomainException("Digite sua senha");
        }

        return true;
    }
}
