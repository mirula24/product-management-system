package enigma.ProductManagementSystem.controller;
import enigma.ProductManagementSystem.service.SaleService;
import enigma.ProductManagementSystem.util.dto.SaleDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
@Validated
public class SaleController {

        private final SaleService saleService;

        @PostMapping
        public ResponseEntity<?> create(@RequestBody SaleDto request){
            return new ResponseEntity<>(
                    saleService.create(request),
                    HttpStatus.CREATED
            );
        }

        @GetMapping
        public  ResponseEntity<?> getAll(){
            return new ResponseEntity<>(
                    saleService.getAll(),
                    HttpStatus.OK
            );
        }

        @GetMapping("/{id}")
        public  ResponseEntity<?> getOne(@PathVariable Long id){
            return new ResponseEntity<>(
                    saleService.getOne(id),
                    HttpStatus.OK
            );
        }

        @PutMapping("/{id}")
        public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody SaleDto request){
            return new ResponseEntity<>(
                    saleService.update(id,request),
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
