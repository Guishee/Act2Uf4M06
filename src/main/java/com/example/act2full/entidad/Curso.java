package com.example.act2full.entidad;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String url;


    //probando relacion onetomany manytoone
    /*@OneToMany(mappedBy = "curso")
    private List<Estudiante> estudiantes = new ArrayList<>();*/

    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes = new ArrayList<>();

    public Curso(String titulo, String descripcion, String url) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;

    }

    public Curso() {
    }


    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
