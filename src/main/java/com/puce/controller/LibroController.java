package com.puce.controller;

import com.puce.entity.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("libro", new Libro());
        return "pages/libroForm";
    }
}
