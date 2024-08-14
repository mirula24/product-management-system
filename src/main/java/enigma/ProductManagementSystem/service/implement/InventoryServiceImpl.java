package enigma.ProductManagementSystem.service.implement;

import enigma.ProductManagementSystem.model.Inventory;
import enigma.ProductManagementSystem.repository.InventoryRepository;
import enigma.ProductManagementSystem.service.InventoryService;
import enigma.ProductManagementSystem.util.dto.InventoryDto;
import enigma.ProductManagementSystem.util.response.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    @Override
    public InventoryResponse create(InventoryDto request) {
        Inventory newInv = Inventory.builder()
                .name(request.getName())
                .city(request.getCity())
                .address(request.getAddress())
                .build();
        inventoryRepository.save(newInv);
        return new InventoryResponse(newInv);
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        return inventoryList;
    }

    @Override
    public InventoryResponse getOne(Long id) {
        Inventory getInv = inventoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Inventory not found"));
        return new InventoryResponse(getInv);
    }

    @Override
    public InventoryResponse update(Long id, InventoryDto request) {
        Inventory updateInv = inventoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Inventory not found"));
        updateInv.setAddress(request.getAddress());
        updateInv.setCity(request.getCity());
        updateInv.setName(request.getName());
        inventoryRepository.save(updateInv);
        return new InventoryResponse(updateInv);
    }

    @Override
    public void delete(Long id) {
        Inventory delInv = inventoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Inventory not found"));
        inventoryRepository.delete(delInv);
    }
}
