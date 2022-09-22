package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.CustomerLoginRequest;
import africa.semicolon.lumexpress.data.dto.request.CustomerRegisterRequest;
import africa.semicolon.lumexpress.data.dto.response.CustomerLoginResponse;
import africa.semicolon.lumexpress.data.dto.response.CustomerRegisterResponse;

public interface CustomerService {
    CustomerRegisterResponse register(CustomerRegisterRequest customerRegisterRequest);
    CustomerLoginResponse login(CustomerLoginRequest loginRequest);
}
