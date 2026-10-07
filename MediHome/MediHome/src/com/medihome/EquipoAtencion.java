package com.medihome;

import java.util.ArrayList;
import java.util.List;

public class EquipoAtencion {
    private String codigo;
    private String nombre;
    private String zonaCobertura;
    private List<ProfesionalSalud> profesionales;

    public EquipoAtencion(String codigo, String nombre, String zonaCobertura) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.zonaCobertura = zonaCobertura;
        this.profesionales = new ArrayList<>();
    }

    public void agregarProfesional(ProfesionalSalud profesional) {
        if (!profesionales.contains(profesional)) {
            profesionales.add(profesional);
        }
    }

    public void retirarProfesional(ProfesionalSalud profesional) {
        profesionales.remove(profesional);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getZonaCobertura() { return zonaCobertura; }
    public void setZonaCobertura(String zonaCobertura) { this.zonaCobertura = zonaCobertura; }
}
