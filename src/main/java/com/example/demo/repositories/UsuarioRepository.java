package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import com.example.demo.models.UsuarioModel;



@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
    public abstract ArrayList<UsuarioModel> findByPrioridad(int prioridad);

    

    
 
    
}
