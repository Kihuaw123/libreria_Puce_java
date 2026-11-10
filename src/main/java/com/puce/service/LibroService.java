package com.puce.service;

import com.puce.entity.Libro;
import com.puce.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    /*Inyeccion de dependencias*/
    @Autowired
    private LibroRepository LibroRepository;

    //Guardar
    public Libro guardarLibro(Libro libro){
        LibroRepository.save(libro);
        return libro;
    }

}
