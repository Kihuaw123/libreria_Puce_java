package com.puce.service;

import com.puce.entity.Libro;
import com.puce.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    /*Inyeccion de dependencias*/
    @Autowired
    private LibroRepository LibroRepository;

    //LEER - SELECT
    public List<Libro> leerLibros(){
        return LibroRepository.findAll();
    }

    //BUSCAR(LEER)  LIBRO POR ID - SELECT * FROM LIBROS WHERE ID =100;
    public Optional<Libro> buscarLibroById(Long id){
        return LibroRepository.findById(id);
    }

    //BUSCAR LIBRO POR TITULO - SELECT * FROM LIBROS WHERE TITULO="SPIDERMAN"(TITULO)
    public List<Libro> buscarLibroTitulo(String inputTitulo){
        if (inputTitulo == null || inputTitulo.isEmpty()){
            return  LibroRepository.findAll();
        }else {
            return LibroRepository.findBytituloContainingIgnoreCase(inputTitulo);
        }
    }

    //ACTUALIZAR - UPDATE LIBRO SET TITULO="BATMAN" WHERE ID=102;
    public Libro actualizarLibro(Long id, Libro libro){
        Libro libroExistente = buscarLibroById(id)
                .orElseThrow(()-> new RuntimeException("Libro no existe"));
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setEditorial(libro.getEditorial());
        libroExistente.setGenero(libro.getGenero());
        libroExistente.setNumeroPaginas(libro.getNumeroPaginas());
        return LibroRepository.save(libroExistente);
    }

    //ELIMINAR - DELETE FROM LIBROS WHERE ID=100;
    public void eliminarLibro(Long id){
        Libro libroEliminar = buscarLibroById(id)
                .orElseThrow(()-> new RuntimeException("Libro no existe"));

        LibroRepository.delete(libroEliminar);
    }


    //Guardar
    public Libro guardarLibro(Libro libro){
        LibroRepository.save(libro);
        return libro;
    }

}


