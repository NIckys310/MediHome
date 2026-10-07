package com.medihome;

import java.time.LocalDateTime;

public class ServicioDomiciliario {
    private String codigo;
    private LocalDateTime fechaProgramada;
    private String direccionAtencion;
    private String motivo;
    private String estado;
    private Paciente paciente;
    private ProfesionalSalud profesional;
    private AtencionMedica atencionMedica;

    public ServicioDomiciliario(String codigo, LocalDateTime fechaProgramada, String direccionAtencion, String motivo, Paciente paciente) {
        this.codigo = codigo;
        this.fechaProgramada = fechaProgramada;
        this.direccionAtencion = direccionAtencion;
        this.motivo = motivo;
        this.estado = "Solicitado";
        this.paciente = paciente;
    }

    public void programar(LocalDateTime fecha) {
        this.fechaProgramada = fecha;
        this.estado = "Programado";
        if (paciente != null) {
            paciente.notificar("Su servicio domiciliario con código " + codigo + " ha sido programado para el " + fecha);
        }
    }

    public void asignarProfesional(ProfesionalSalud profesional) {
        this.profesional = profesional;
        if (profesional != null) {
            profesional.notificar("Se le ha asignado el servicio domiciliario " + codigo + " en la dirección " + direccionAtencion);
        }
    }

    public void iniciarAtencion(LocalDateTime horaInicio) {
        this.estado = "En atención";
        this.atencionMedica = new AtencionMedica(horaInicio, null, "", "");
    }

    public void finalizar(LocalDateTime horaFin, String observaciones, String recomendaciones) {
        this.estado = "Finalizado";
        if (this.atencionMedica != null) {
            this.atencionMedica.setFechaHoraFin(horaFin);
            this.atencionMedica.setObservaciones(observaciones);
            this.atencionMedica.setRecomendaciones(recomendaciones);
        }
    }

    public void cancelar() {
        this.estado = "Cancelado";
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public LocalDateTime getFechaProgramada() { return fechaProgramada; }
    public void setFechaProgramada(LocalDateTime fechaProgramada) { this.fechaProgramada = fechaProgramada; }

    public String getDireccionAtencion() { return direccionAtencion; }
    public void setDireccionAtencion(String direccionAtencion) { this.direccionAtencion = direccionAtencion; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public ProfesionalSalud getProfesional() { return profesional; }
    public AtencionMedica getAtencionMedica() { return atencionMedica; }
    public void setAtencionMedica(AtencionMedica atencionMedica) { this.atencionMedica = atencionMedica; }
}
