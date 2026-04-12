package com.udea.banco2026v.serviceTest;

import com.udea.banco2026v.dto.CustomerDTO;
import com.udea.banco2026v.entity.Customer;
import com.udea.banco2026v.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@org.springframework.test.context.ActiveProfiles("test")
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    private CustomerDTO crearCliente() {
        String account = "ACC-" + System.currentTimeMillis();

        CustomerDTO dto = new CustomerDTO();
        dto.setAccountNumber(account);
        dto.setFirstName("Juan");
        dto.setLastName("Perez");
        dto.setBalance("1000.0");

        return customerService.createCustomer(dto);
    }

    @Test
    public void testAddCustomer() {
        CustomerDTO resultado = crearCliente();

        // Validar
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getFirstName());
    }

    @Test
    public void testGetCustomerById(){
        CustomerDTO creado = crearCliente();

        CustomerDTO obtenido = customerService.getCustomerById(creado.getId());

        assertNotNull(obtenido);
        assertEquals(creado.getId(), obtenido.getId());
    }
}
