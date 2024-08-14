package enigma.ProductManagementSystem.service;

import enigma.ProductManagementSystem.util.dto.ShopDto;
import enigma.ProductManagementSystem.util.response.ShopResponse;

import java.util.List;

public interface ShopService {
    ShopResponse create(ShopDto request);

    List<ShopResponse> getAll();

    ShopResponse getOne(Long id);

    ShopResponse update(Long id, ShopDto request);

    void delete (Long id);
}
