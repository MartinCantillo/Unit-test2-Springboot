/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.CrudEstudiante.demo.Services;

import com.example.CrudEstudiante.demo.Model.Estudiante;
import java.util.List;

/**
 *
 * @author marti
 */
public interface StudentService {

    public List<Estudiante> listarEstudiantes();

    public Estudiante guardar(Estudiante Estudiante);

    public Estudiante eliminar(Estudiante Estudiante);

    public Estudiante encontrarEstudiante(Estudiante Estudiante);
}
