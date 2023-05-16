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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Controllers {
    @Autowired
    private CursoRepo cursoRepo;

    @Autowired
    private EstudianteRepo estudianteRepo;

    //CURSO
    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoRepo.findAll();
        model.addAttribute("cursos", cursos);
        return "lista-cursos";
    }

    @PostMapping("/cursos-add")
    public String agregarCurso(@RequestParam("titulo") String titulo,
                               @RequestParam("descripcion") String descripcion,
                               @RequestParam("url") String url) {
        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescripcion(descripcion);
        curso.setUrl(url);

        cursoRepo.save(curso);

        return "redirect:/cursos";
    }

    //ESTUDIANTE

    @GetMapping("/estudiantes")
    public String listarEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteRepo.findAll();
        List<Curso> cursos = cursoRepo.findAll();

        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("cursos", cursos);

        return "lista-estudiantes";
    }

    @PostMapping("/estudiantes-add")
    public String agregarEstudiante(@RequestParam("nombre") String nombre,
                                    @RequestParam("apellido") String apellido,
                                    @RequestParam("cursoId") Long cursoId) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);

        Curso curso = cursoRepo.findById(cursoId).orElse(null);
        if (curso != null) {
            estudiante.getCursos().add(curso);
            curso.getEstudiantes().add(estudiante);
        }

        estudianteRepo.save(estudiante);

        return "redirect:/estudiantes";
    }
}
