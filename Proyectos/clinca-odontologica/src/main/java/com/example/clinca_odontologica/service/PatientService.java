package com.example.clinca_odontologica.service;

import com.example.clinca_odontologica.dto.PatientRequestDTO;
import com.example.clinca_odontologica.dto.PatientResponseDTO;
import com.example.clinca_odontologica.exception.EntityHasAppointmentsException;
import com.example.clinca_odontologica.exception.ResourceNotFoundException;
import com.example.clinca_odontologica.model.Patient;
import com.example.clinca_odontologica.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService implements IPatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientResponseDTO save(PatientRequestDTO request) {
        Patient patient = Patient.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dni(request.getDni())
                .admissionDate(LocalDate.now())
                .build();
        patientRepository.save(patient);
        return buildPatientResponse(patient);
    }

    @Override
    public List<PatientResponseDTO> findAll() {
        return patientRepository.findAll().stream()
                .map(this::buildPatientResponse)
                .toList();
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
    }

    @Override
    public PatientResponseDTO update(Long id, PatientRequestDTO request) {
        Patient patient = findById(id);

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setDni(request.getDni());

        patientRepository.save(patient);

        return buildPatientResponse(patient);
    }

    @Override
    public void delete(Long id) {
        Patient patient = findById(id);

        if (!patient.getAppointments().isEmpty()) {
            throw new EntityHasAppointmentsException("No se puede eliminar un paciente con turnos registrados");
        }

        patientRepository.delete(patient);
    }

    private PatientResponseDTO buildPatientResponse(Patient patient) {
        return PatientResponseDTO.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .dni(patient.getDni())
                .admissionDate(patient.getAdmissionDate())
                .build();
    }
}
