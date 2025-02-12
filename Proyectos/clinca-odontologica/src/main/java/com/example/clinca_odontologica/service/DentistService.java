package com.example.clinca_odontologica.service;

import com.example.clinca_odontologica.dto.DentistRequestDTO;
import com.example.clinca_odontologica.dto.DentistResponseDTO;
import com.example.clinca_odontologica.exception.EntityHasAppointmentsException;
import com.example.clinca_odontologica.exception.ResourceNotFoundException;
import com.example.clinca_odontologica.model.Dentist;
import com.example.clinca_odontologica.repository.DentistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DentistService implements IDentistService {

    private final DentistRepository dentistRepository;

    @Override
    public DentistResponseDTO save(DentistRequestDTO request) {
        Dentist dentist = Dentist.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .licenseNumber(request.getLicenseNumber())
                .build();
        dentistRepository.save(dentist);
        return buildDentistResponse(dentist);
    }

    @Override
    public List<DentistResponseDTO> findAll() {
        return dentistRepository.findAll().stream()
                .map(this::buildDentistResponse)
                .toList();
    }

    @Override
    public Dentist findById(Long id) {
        return dentistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dentista no encontrado"));
    }

    @Override
    public DentistResponseDTO update(Long id, DentistRequestDTO request) {
        Dentist dentist = findById(id);

        dentist.setFirstName(request.getFirstName());
        dentist.setLastName(request.getLastName());
        dentist.setLicenseNumber(request.getLicenseNumber());

        dentistRepository.save(dentist);

        return buildDentistResponse(dentist);
    }

    @Override
    public void delete(Long id) {
        Dentist dentist = findById(id);

        if (!dentist.getAppointments().isEmpty()) {
            throw new EntityHasAppointmentsException("No se puede eliminar un dentista con turnos registrados");
        }

        dentistRepository.delete(dentist);
    }

    private DentistResponseDTO buildDentistResponse(Dentist dentist) {
        return DentistResponseDTO.builder()
                .firstName(dentist.getFirstName())
                .lastName(dentist.getLastName())
                .licenseNumber(dentist.getLicenseNumber())
                .build();
    }
}
