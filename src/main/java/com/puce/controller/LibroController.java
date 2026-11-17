package com.puce.controller;

import com.puce.entity.Libro;
import com.puce.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController {

    //Inyeccion de dependencias por campo
    @Autowired
    private LibroService libroService;

    @GetMapping
    public String mostrarLibros(
            @RequestParam(name = "inputLibro", required = false, defaultValue = "") String inputLibro,
            Model model) {

        List<Libro> libros = libroService.buscarLibroTitulo(inputLibro);

        model.addAttribute("inputLibro", inputLibro);
        model.addAttribute("libros", libros);

        return "pages/libroLista";
    }


    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("libro", new Libro());
        return "pages/libroForm";
    }

}
