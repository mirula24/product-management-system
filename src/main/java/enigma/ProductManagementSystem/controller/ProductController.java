package enigma.ProductManagementSystem.controller;
import enigma.ProductManagementSystem.service.ProductService;
import enigma.ProductManagementSystem.util.dto.ProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

        private final ProductService productService;

        @PostMapping
        public ResponseEntity<?> createProduct(@RequestBody ProductDto request){

            return new ResponseEntity<>(
                    productService.create(request),
                    HttpStatus.CREATED
            );
        }

        @GetMapping
        public  ResponseEntity<?> getAll(){
            return new ResponseEntity<>(
                    productService.getAll(),
                    HttpStatus.OK
            );
        }@GetMapping("/search")
        public  ResponseEntity<?> getProductWithStockAbove(@RequestParam Integer stock){
            return new ResponseEntity<>(
                    productService.getProductWithStockAbove(stock),
                    HttpStatus.OK
            );
        }
    @GetMapping("/max_stock")
    public  ResponseEntity<?> findProductWithMaxStock(){
        return new ResponseEntity<>(
                productService.getProductWithMaxStock(),
                HttpStatus.OK
        );
    }

        @GetMapping("/{id}")
        public  ResponseEntity<?> getOne(@PathVariable Long id){
            return new ResponseEntity<>(
                    productService.getOne(id),
                    HttpStatus.OK
            );
        }

        @PutMapping("/{id}")
        public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDto request){
            return new ResponseEntity<>(
                    productService.update(id,request),
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
