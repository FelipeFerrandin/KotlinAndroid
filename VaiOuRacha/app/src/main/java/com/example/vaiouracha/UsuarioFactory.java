package com.example.vaiouracha;

public class UsuarioFactory {

    public static UsuarioPOJO createUsuario(String nome, String sobrenome) {
        UsuarioPOJO usuario = new UsuarioPOJO();
        usuario.nome = nome;
        usuario.sobrenome = sobrenome;
        return usuario;
    }

}
