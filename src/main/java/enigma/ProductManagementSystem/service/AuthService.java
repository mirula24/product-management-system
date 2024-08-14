package enigma.ProductManagementSystem.service;

import enigma.ProductManagementSystem.util.dto.LoginRequest;
import enigma.ProductManagementSystem.util.dto.RegisterRequest;
import enigma.ProductManagementSystem.util.response.LoginResponse;
import enigma.ProductManagementSystem.util.response.RefreshResponse;
import enigma.ProductManagementSystem.util.response.RegisterResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);
    RefreshResponse refreshToken(String refreshToken);
}
