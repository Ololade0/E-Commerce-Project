package africa.semicolon.lumexpress.service;
import africa.semicolon.lumexpress.data.dto.request.CustomerLoginRequest;
import africa.semicolon.lumexpress.data.dto.request.CustomerRegisterRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateCustomerDetails;
import africa.semicolon.lumexpress.data.dto.response.CustomerLoginResponse;
import africa.semicolon.lumexpress.data.dto.response.CustomerRegisterResponse;
import africa.semicolon.lumexpress.data.model.Address;
import africa.semicolon.lumexpress.data.model.Cart;
import africa.semicolon.lumexpress.data.model.Customer;
import africa.semicolon.lumexpress.data.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServicesImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CartService cartService;
   private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public CustomerRegisterResponse registerCUstomer(CustomerRegisterRequest customerRegisterRequest) {
        Customer customer = modelMapper.map(customerRegisterRequest, Customer.class);
        customer.setCart(new Cart());
        var customerAddress = new Address();
        customerAddress.setCountry(customerAddress.getCountry());
        customer.getAddress().add(customerAddress);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("customer to be saved in db::{}", customer);
        return registrationResponseBuilder(savedCustomer);
    }

    private CustomerRegisterResponse registrationResponseBuilder(Customer customer){
        return CustomerRegisterResponse.builder()
                .message("success")
                .code(201)
                .userId(customer.getId())
                .build();



    }


    @Override
    public CustomerLoginResponse login(CustomerLoginRequest loginRequest) {
        return null;
    }

    @Override
    public String completeProfile(UpdateCustomerDetails updateCustomerDetails) {
        return null;
    }



}
