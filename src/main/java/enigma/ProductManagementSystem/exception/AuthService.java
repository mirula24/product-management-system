package enigma.ProductManagementSystem.exception;


import enigma.ProductManagementSystem.util.dto.LoginRequest;
import enigma.ProductManagementSystem.util.dto.RegisterRequest;
import enigma.ProductManagementSystem.util.response.LoginResponse;
import enigma.ProductManagementSystem.util.response.RegisterResponse;
import jakarta.validation.Valid;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse refreshToken(String refreshToken);
}