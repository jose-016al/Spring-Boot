package com.example.clinca_odontologica.service;

import com.example.clinca_odontologica.dto.AppointmentRequestDTO;
import com.example.clinca_odontologica.dto.AppointmentResponseDTO;
import com.example.clinca_odontologica.model.Appointment;
import com.example.clinca_odontologica.model.Dentist;
import com.example.clinca_odontologica.model.Patient;
import com.example.clinca_odontologica.repository.AppointmentRepository;
import com.example.clinca_odontologica.repository.DentistRepository;
import com.example.clinca_odontologica.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final IPatientService patientService;
    private final IDentistService dentistService;

    @Override
    public AppointmentResponseDTO save(AppointmentRequestDTO request) {
        Appointment appointment = Appointment.builder()
                .patient(patientService.findById(request.getPatientId()))
                .dentist(dentistService.findById(request.getDentistId()))
                .appointmentDate(request.getAppointmentDate())
                .build();
        appointmentRepository.save(appointment);
        return buildAppointmentResponse(appointment);
    }

    @Override
    public List<AppointmentResponseDTO> findAll() {
        return appointmentRepository.findAll().stream()
                .map(this::buildAppointmentResponse)
                .toList();
    }

    @Override
    public AppointmentResponseDTO update(Long id, AppointmentRequestDTO request) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turno no encontrado"));

        appointment.setPatient(patientService.findById(request.getPatientId()));
        appointment.setDentist(dentistService.findById(request.getDentistId()));
        appointment.setAppointmentDate(request.getAppointmentDate());

        appointmentRepository.save(appointment);

        return buildAppointmentResponse(appointment);
    }

    @Override
    public void delete(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turno no encontrado"));

        appointmentRepository.delete(appointment);
    }

    private AppointmentResponseDTO buildAppointmentResponse(Appointment appointment) {
        return AppointmentResponseDTO.builder()
                .patient(appointment.getPatient().getId())
                .dentist(appointment.getDentist().getId())
                .appointmentDate(appointment.getAppointmentDate())
                .build();
    }

}
