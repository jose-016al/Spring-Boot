package org.jose.test.springboot.app.services;

import org.jose.test.springboot.app.models.Cuenta;

import java.math.BigDecimal;
import java.util.List;

public interface ICuentaService {
    List<Cuenta> findAll();
    Cuenta findById(Long id);
    Cuenta save(Cuenta cuenta);
    void deleteById(Long id);
    int revisarTotalTransferencias(Long bancoId);
    BigDecimal revisarSaldo(long cuentaId);
    void transferir(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal monto, Long bancoId);
}
