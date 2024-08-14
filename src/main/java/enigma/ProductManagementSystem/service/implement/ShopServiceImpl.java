package enigma.ProductManagementSystem.service.implement;

import enigma.ProductManagementSystem.model.Shop;
import enigma.ProductManagementSystem.repository.ShopRepository;
import enigma.ProductManagementSystem.service.ShopService;
import enigma.ProductManagementSystem.util.dto.ShopDto;
import enigma.ProductManagementSystem.util.response.ShopResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    @Override
    public ShopResponse create(ShopDto request) {
        Shop newShop = Shop.builder()
                .name(request.getName())
                .city(request.getCity())
                .address(request.getAddress())
                .build();
        shopRepository.save(newShop);

        return new ShopResponse(newShop);

    }

    @Override
    public List<ShopResponse> getAll() {
        List<Shop> shopList = shopRepository.findAll();
        List<ShopResponse> shopResponses = shopList.stream().map(ShopResponse::new).toList();
        return shopResponses;
    }

    @Override
    public ShopResponse getOne(Long id) {
        Shop getOne = shopRepository.findById(id).orElseThrow(()-> new RuntimeException("Shop not found"));

        return new ShopResponse(getOne);
    }

    @Override
    public ShopResponse update(Long id, ShopDto request) {
        Shop updateShop = shopRepository.findById(id).orElseThrow(()-> new RuntimeException("Shop not found"));
        updateShop.setName(request.getName());
        updateShop.setCity(request.getCity());
        updateShop.setAddress(request.getAddress());
        shopRepository.save(updateShop);
        return new ShopResponse(updateShop);
    }

    @Override
    public void delete(Long id) {
        Shop delShop = shopRepository.findById(id).orElseThrow(()-> new RuntimeException("Shop not found"));
        shopRepository.delete(delShop);
    }
}
