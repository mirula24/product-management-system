package enigma.ProductManagementSystem.controller;
import enigma.ProductManagementSystem.service.ShopService;
import enigma.ProductManagementSystem.util.dto.ShopDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shops")
@RequiredArgsConstructor
@Validated
public class ShopController {

        private final ShopService shopService;

        @PostMapping
        public ResponseEntity<?> create(@RequestBody ShopDto request){
            return new ResponseEntity<>(
                    shopService.create(request),
                    HttpStatus.CREATED
            );
        }

        @GetMapping
        public  ResponseEntity<?> getAll(){
            return new ResponseEntity<>(
                    shopService.getAll(),
                    HttpStatus.OK
            );
        }

        @GetMapping("/{id}")
        public  ResponseEntity<?> getOne(@PathVariable Long id){
            return new ResponseEntity<>(
                    shopService.getOne(id),
                    HttpStatus.OK
            );
        }

        @PutMapping("/{id}")
        public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody ShopDto request){
            return new ResponseEntity<>(
                    shopService.update(id,request),
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
