package com.example.act2full.controller;

import com.example.act2full.entidad.Curso;
import com.example.act2full.entidad.Estudiante;
import com.example.act2full.repos.CursoRepo;
import com.example.act2full.repos.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class Controllers {
    @Autowired
    private CursoRepo cursoRepo;

    @Autowired
    private EstudianteRepo estudianteRepo;

    //CURSO
    @GetMapping("/cursos")
    public String mostrarCursos(Model model) {
        List<Curso> cursos = cursoRepo.findAll();
        model.addAttribute("cursos", cursos);
        model.addAttribute("nuevoCurso", new Curso());
        return "lista-cursos";
    }

    @PostMapping("/cursos/agregar")
    public String agregarCurso(@ModelAttribute Curso nuevoCurso) {
        cursoRepo.save(nuevoCurso);
        return "redirect:/cursos";
    }

    //ESTUDIANTE

    @GetMapping("/estudiantes")
    public String mostrarEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteRepo.findAll();
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("nuevoEstudiante", new Estudiante());
        return "lista-estudiantes";
    }

    @PostMapping("/estudiantes/agregar")
    public String agregarEstudiante(@ModelAttribute Estudiante nuevoEstudiante) {
        estudianteRepo.save(nuevoEstudiante);
        return "redirect:/estudiantes";
    }
}
