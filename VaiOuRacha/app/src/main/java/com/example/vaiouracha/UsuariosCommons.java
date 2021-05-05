package com.example.vaiouracha;

import java.util.ArrayList;
import java.util.List;

public class UsuariosCommons {

    public static List<UsuarioPOJO> getUsuarios(){
        // TODO: 03/11/2020 AQUI USA LISTA
        List<UsuarioPOJO> usuarios = new ArrayList<>();
        usuarios.add(UsuarioFactory.createUsuario("Silva","Gustavo"));
        usuarios.add(UsuarioFactory.createUsuario("Felipe","Foda"));
        usuarios.add(UsuarioFactory.createUsuario("Mathias","Milico"));
        return usuarios;
    }

}
