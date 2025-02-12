package com.example.clinca_odontologica.service;

import com.example.clinca_odontologica.dto.AppointmentRequestDTO;
import com.example.clinca_odontologica.dto.AppointmentResponseDTO;

import java.util.List;

public interface IAppointmentService {
    public AppointmentResponseDTO save(AppointmentRequestDTO request);
    public List<AppointmentResponseDTO> findAll();
    public AppointmentResponseDTO update(Long id, AppointmentRequestDTO request);
    public void delete(Long id);
}
