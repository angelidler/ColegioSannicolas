/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.olivar.datos;

/**
 *
 * @author DANIEL
 */
public class DCursos {
    
    private String Curso,Profesor;
    private int IdCurso;

    public DCursos(String Curso, String Profesor, int IdCurso) {
        this.Curso = Curso;
        this.Profesor = Profesor;
        this.IdCurso = IdCurso;
    }

    public DCursos() {
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public String getProfesor() {
        return Profesor;
    }

    public void setProfesor(String Profesor) {
        this.Profesor = Profesor;
    }

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
    }
    
}
