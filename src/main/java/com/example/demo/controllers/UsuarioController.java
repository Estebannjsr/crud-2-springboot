package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;





@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
        public ArrayList<UsuarioModel> obtenerUsuarios(){
            return usuarioService.obtenerUsuarios();
            }
    
    @PostMapping()
    public UsuarioModel guardaUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    @GetMapping("/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id")Long id) {  
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") int prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@RequestParam("id")Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
            if (ok) {
                return "Se elimino el usuario con id " + id;
            }else{
                return "No se pudo eliminar el usuario con id " + id;
            }
    }

}
    
    

