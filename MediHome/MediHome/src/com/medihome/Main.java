package com.medihome;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIALIZANDO SISTEMA MEDIHOME ===\n");

        Paciente paciente = new Paciente("1085234567", "Carlos Pérez", "carlos.perez@email.com", "3104567890", "Calle 18 # 20-45");
        ProfesionalSalud profesional = new ProfesionalSalud("98765432", "Dra. María Gómez", "maria.gomez@medihome.com", "RM-998822", "Medicina General");

        LocalDateTime fechaProg = LocalDateTime.now().plusHours(2);
        ServicioDomiciliario servicio = new ServicioDomiciliario("SERV-001", fechaProg, paciente.getDireccion(), "Fiebre alta y malestar general", paciente);

        servicio.programar(fechaProg);
        servicio.asignarProfesional(profesional);

        LocalDateTime horaInicio = LocalDateTime.now();
        servicio.iniciarAtencion(horaInicio);

        MedicionSignosVitales medicion = new MedicionSignosVitales(
                LocalDateTime.now(),
                38.5,
                98,
                120,
                80,
                96.5
        );
        medicion.realizarMedicion();

        if (servicio.getAtencionMedica() != null) {
            servicio.getAtencionMedica().agregarMedicion(medicion);
        }

        LocalDateTime horaFin = LocalDateTime.now().plusMinutes(45);
        servicio.finalizar(horaFin, "Paciente presenta cuadro febril agudo de vías respiratorias superiores.", "Reposo absoluto por 3 días, acetaminofén cada 8 horas y abundante hidratación.");

        System.out.println("\n==================================================");
        System.out.println("            REPORTE DE ATENCIÓN MÉDICA            ");
        System.out.println("==================================================");
        System.out.println("Código de Servicio : " + servicio.getCodigo());
        System.out.println("Estado del Servicio: " + servicio.getEstado());
        System.out.println("Motivo             : " + servicio.getMotivo());
        System.out.println("Dirección          : " + servicio.getDireccionAtencion());
        System.out.println("--------------------------------------------------");
        System.out.println("PACIENTE:");
        System.out.println(" - Nombre          : " + paciente.getNombre());
        System.out.println(" - Identificación  : " + paciente.getIdentificacion());
        System.out.println(" - Teléfono        : " + paciente.getTelefono());
        System.out.println("--------------------------------------------------");
        System.out.println("PROFESIONAL ASIGNADO:");
        System.out.println(" - Nombre          : " + profesional.getNombre());
        System.out.println(" - Especialidad    : " + profesional.getEspecialidad());
        System.out.println(" - Registro Prof.  : " + profesional.getNumeroRegistroProfesional());
        System.out.println("--------------------------------------------------");
        System.out.println("DETALLES DE LA ATENCIÓN:");
        System.out.println(" - Hora Inicio     : " + servicio.getAtencionMedica().getFechaHoraInicio());
        System.out.println(" - Hora Fin        : " + servicio.getAtencionMedica().getFechaHoraFin());
        System.out.println(" - Observaciones   : " + servicio.getAtencionMedica().getObservaciones());
        System.out.println(" - Recomendaciones : " + servicio.getAtencionMedica().getRecomendaciones());
        System.out.println("--------------------------------------------------");
        System.out.println("SIGNOS VITALES REGISTRADOS:");
        for (MedicionSignosVitales m : servicio.getAtencionMedica().getMediciones()) {
            System.out.println(" - Temperatura     : " + m.getTemperatura() + " °C");
            System.out.println(" - Frec. Cardíaca  : " + m.getFrecuenciaCardiaca() + " lpm");
            System.out.println(" - Presión Arterial: " + m.getPresionSistolica() + "/" + m.getPresionDiastolica() + " mmHg");
            System.out.println(" - Sat. de Oxígeno : " + m.getSaturacionOxigeno() + " %");
        }
        System.out.println("==================================================");
    }
}
