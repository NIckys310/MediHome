package com.medihome;

import java.time.LocalDateTime;

public class ProfesionalSalud extends Usuario implements Notificable {
    private String numeroRegistroProfesional;
    private String especialidad;

    public ProfesionalSalud() { super(); }

    public ProfesionalSalud(String identificacion, String nombre, String correo, String numeroRegistroProfesional, String especialidad) {
        super(identificacion, nombre, correo);
        this.numeroRegistroProfesional = numeroRegistroProfesional;
        this.especialidad = especialidad;
    }

    public String getNumeroRegistroProfesional() { return numeroRegistroProfesional; }
    public void setNumeroRegistroProfesional(String numeroRegistroProfesional) { this.numeroRegistroProfesional = numeroRegistroProfesional; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public boolean estaDisponible(LocalDateTime fecha) {
        return true;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("[Notificación a Profesional " + nombre + "]: " + mensaje);
    }
}
