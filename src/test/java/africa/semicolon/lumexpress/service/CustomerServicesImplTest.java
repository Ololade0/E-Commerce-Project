package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CustomerRegisterRequest;
import africa.semicolon.lumexpress.data.dto.response.CustomerRegisterResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CustomerServicesImplTest {
    @Autowired
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {
        CustomerRegisterRequest customerRegisterRequest =  CustomerRegisterRequest
                .builder()
                .email("test@gmail.com")
                .password("ololade")
                .country("NIgeria")
                .build();
        CustomerRegisterResponse customerRegisterResponse =  customerService.registerCUstomer(customerRegisterRequest);
        assertThat(customerRegisterResponse).isNotNull();
        assertThat(customerRegisterResponse.getMessage()).isNotNull();
        assertThat(customerRegisterResponse.getUserId()).isGreaterThan(0);
        assertThat(customerRegisterResponse.getCode()).isEqualTo(201);

    }

    @Test
    void login() {
    }

    @Test
    void completeProfile() {
    }
}