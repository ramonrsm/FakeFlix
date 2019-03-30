package com.example.fakeflix.Util;

import android.content.Context;
import android.content.Intent;

import com.example.fakeflix.Models.Exceptions.DomainException;

public class Helpers {

    public static boolean IsEmpty(String email, String senha) throws DomainException {

        if(email.isEmpty() && senha.isEmpty()){
            return true;
        }

        if(email.isEmpty()){
            throw new DomainException("Digite seu e-mail");
        }

        if(senha.isEmpty()){
            throw new DomainException("Digite sua senha");
        }
        return false;
    }

    public static void forActivity(Context context, Class<?> cls){

        Intent mainActivityIntent = new Intent(context, cls);
        context.startActivity(mainActivityIntent);
    }
}
