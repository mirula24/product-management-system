package enigma.ProductManagementSystem.controller;

import enigma.ProductManagementSystem.service.InventoryService;
import enigma.ProductManagementSystem.util.dto.InventoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
@Validated
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody InventoryDto request){
        return new ResponseEntity<>(
                inventoryService.create(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public  ResponseEntity<?> getAll(){
        return new ResponseEntity<>(
                inventoryService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getOne(@PathVariable Long id){
        return new ResponseEntity<>(
                inventoryService.getOne(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody InventoryDto request){
        return new ResponseEntity<>(
                inventoryService.update(id,request),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(Long id){
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

}
