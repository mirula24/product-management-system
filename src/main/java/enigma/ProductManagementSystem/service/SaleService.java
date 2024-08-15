package enigma.ProductManagementSystem.service;

import enigma.ProductManagementSystem.model.Sale;
import enigma.ProductManagementSystem.util.dto.SaleDto;
import enigma.ProductManagementSystem.util.response.SaleResponse;

import java.util.List;

public interface SaleService {
    SaleResponse create(SaleDto request);

    List<SaleResponse> getAll();

    List<SaleResponse> findShopWithHighestQuantity();

    SaleResponse getOne(Long id);

    SaleResponse update(Long id, SaleDto request);

    void delete (Long id);
}
