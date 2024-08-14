package enigma.ProductManagementSystem.service;

import enigma.ProductManagementSystem.model.Inventory;
import enigma.ProductManagementSystem.util.dto.InventoryDto;
import enigma.ProductManagementSystem.util.response.InventoryResponse;

import java.util.List;

public interface InventoryService {
InventoryResponse create(InventoryDto request);
List<Inventory> getAll();
InventoryResponse getOne(Long id);
InventoryResponse update(Long id, InventoryDto request);
void delete (Long id);
}
