package meli.bootcamp.crudclaseenvivo.controller;

import meli.bootcamp.crudclaseenvivo.dto.req.CartDto;
import meli.bootcamp.crudclaseenvivo.service.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    ICartService cartService;

    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getCarts(){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.findAllCarts());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCart(@RequestBody CartDto cartDto){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.saveCart(cartDto));
    }
}
