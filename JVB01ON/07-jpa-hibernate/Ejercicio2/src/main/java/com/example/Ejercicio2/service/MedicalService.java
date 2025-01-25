package com.example.Ejercicio2.service;

import com.example.Ejercicio2.dto.MedicalDTO;
import com.example.Ejercicio2.model.Medical;
import com.example.Ejercicio2.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {

    @Autowired
    private MedicalRepository repository;

    @Override
    public void save(Medical medical) {
        repository.save(medical);
    }

    @Override
    public List<MedicalDTO> findAll() {
        return repository.findAll().stream()
                .map(medical -> new MedicalDTO(
                        medical.getName(),
                        medical.getDescription(),
                        medical.getCost()
                )).toList();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public MedicalDTO findById(Long id) {
        return repository.findById(id)
                .map(medical -> new MedicalDTO(
                        medical.getName(),
                        medical.getDescription(),
                        medical.getCost()
                ))
                .orElse(null);
    }

    @Override
    public MedicalDTO edit(Long id, String name, String description, double cost) {
        Medical updateMedical = repository.findAll().stream()
                .filter(medical -> medical.getId().equals(id))
                .peek(medical -> {
                    medical.setName(name);
                    medical.setDescription(description);
                    medical.setCost(cost);
                })
                .findFirst()
                .orElse(new Medical());

        repository.save(updateMedical);
        return new MedicalDTO(updateMedical.getName(), updateMedical.getDescription(), updateMedical.getCost());
    }
}
