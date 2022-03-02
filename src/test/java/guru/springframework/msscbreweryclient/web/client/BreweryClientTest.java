package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer")
                .build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void updateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("UpdatedBeer")
                .id(UUID.randomUUID())
                .build();

        client.updateBeer(beerDto.getId(), beerDto);
    }

    @Test
    void deleteBeer() {
        UUID uuid = UUID.randomUUID();

        client.deleteBeer(uuid);
    }

    @Test
    void getCustomer() {
        UUID uuid = UUID.randomUUID();
        CustomerDTO customerDto = client.getCustomer(uuid);

        assertNotNull(customerDto);
    }

    @Test
    void saveCustomer() {
        CustomerDTO customerDto = CustomerDTO.builder()
                .name("Exel")
                .build();

        URI savedCustomer = client.saveCustomer(customerDto);

        assertNotNull(savedCustomer);
    }

    @Test
    void updateCustomer() {
        CustomerDTO customerDto = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Exel")
                .build();

        client.updateCustomer(customerDto.getId(),customerDto);

    }

    @Test
    void deleteCustomer() {
        UUID uuid = UUID.randomUUID();

        client.deleteCustomer(uuid);
    }
}