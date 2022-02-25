package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomer() {
        UUID uuid = UUID.randomUUID();
        CustomerDTO customerDto = customerClient.getCustomer(uuid);

        assertNotNull(customerDto);
    }

    @Test
    void saveCustomer() {
        CustomerDTO customerDto = CustomerDTO.builder()
                .name("Exel")
                .build();

        URI savedCustomer = customerClient.saveCustomer(customerDto);

        assertNotNull(savedCustomer);
    }
}