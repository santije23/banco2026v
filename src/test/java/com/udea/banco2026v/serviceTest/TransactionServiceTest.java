package com.udea.banco2026v.serviceTest;

import com.udea.banco2026v.dto.CustomerDTO;
import com.udea.banco2026v.dto.TransactionDTO;
import com.udea.banco2026v.service.CustomerService;
import com.udea.banco2026v.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;

    // Helper para crear clientes
    private CustomerDTO crearCliente(String balance) {
        String account = "ACC-" + System.currentTimeMillis();

        CustomerDTO dto = new CustomerDTO();
        dto.setAccountNumber(account);
        dto.setFirstName("Juan");
        dto.setLastName("Perez");
        dto.setBalance(balance);

        return customerService.createCustomer(dto);
    }

    @Test
    void testTransferMoney_success() {
        // Crear clientes
        CustomerDTO sender = crearCliente("1000.0");
        CustomerDTO receiver = crearCliente("500.0");

        // Crear transacción
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setSenderAccountNumber(sender.getAccountNumber());
        transactionDTO.setReceiverAccountNumber(receiver.getAccountNumber());
        transactionDTO.setAmount(200.0);

        // Ejecutar
        TransactionDTO resultado = transactionService.transferMoney(transactionDTO);

        // Validar
        assertNotNull(resultado);
        assertEquals(200.0, resultado.getAmount());
        assertEquals(sender.getAccountNumber(), resultado.getSenderAccountNumber());
    }

    @Test
    void testTransferMoney_insufficientBalance() {
        // Crear clientes
        CustomerDTO sender = crearCliente("100.0"); // poco saldo
        CustomerDTO receiver = crearCliente("500.0");

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setSenderAccountNumber(sender.getAccountNumber());
        transactionDTO.setReceiverAccountNumber(receiver.getAccountNumber());
        transactionDTO.setAmount(200.0); // mayor al saldo

        // Validar excepción
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            transactionService.transferMoney(transactionDTO);
        });

        assertEquals("Saldo del remitente no es suficiente", exception.getMessage());
    }
}