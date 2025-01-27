package com.example.Ejercicio2.service;

import com.example.Ejercicio2.dto.PatientDTO;
import com.example.Ejercicio2.model.Patient;
import com.example.Ejercicio2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository repository;

    @Override
    public void save(Patient patient) {
        repository.save(patient);
    }

    @Override
    public List<PatientDTO> findAll() {
        return repository.findAll().stream()
                .map(patient -> new PatientDTO(
                        patient.getName(),
                        patient.getSurname(),
                        patient.getAge()
                )).toList();
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PatientDTO findById(Long id) {
        return repository.findById(id)
                .map(patient -> new PatientDTO(
                        patient.getName(),
                        patient.getSurname(),
                        patient.getAge()
                ))
                .orElse(null);
    }

    @Override
    public PatientDTO edit(Long id, String name, String surname, int age) {
        Patient updatedPatient = repository.findAll().stream()
                .filter(patient -> patient.getId().equals(id))
                .peek(patient -> {
                    patient.setName(name);
                    patient.setSurname(surname);
                    patient.setAge(age);
                })
                .findFirst()
                .orElse(new Patient());

        repository.save(updatedPatient);
        return new PatientDTO(updatedPatient.getName(), updatedPatient.getSurname(), updatedPatient.getAge());
    }
}
