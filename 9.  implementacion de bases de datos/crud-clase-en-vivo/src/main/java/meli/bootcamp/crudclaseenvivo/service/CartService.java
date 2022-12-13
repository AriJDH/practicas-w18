package meli.bootcamp.crudclaseenvivo.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import meli.bootcamp.crudclaseenvivo.dto.req.CartDto;
import meli.bootcamp.crudclaseenvivo.dto.res.ResponseCartDto;
import meli.bootcamp.crudclaseenvivo.entity.Cart;
import meli.bootcamp.crudclaseenvivo.entity.Item;
import meli.bootcamp.crudclaseenvivo.repository.ICartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService implements ICartService {
    private final ICartRepository cartRepository;
    private final ObjectMapper mapper;

    public CartService(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
        mapper = JsonMapper.builder()
                .findAndAddModules()
                .build()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<CartDto> findAllCarts() {
        // ModelMapper mapper = new ModelMapper();

        List<Cart> cartList = cartRepository.findAll();
        // List<CartDto> cartDtoList =
        List<CartDto> cartDtoList = cartList.stream()
                .map( cart -> mapper.convertValue(cart, CartDto.class))
                .collect(Collectors.toList());
        return cartDtoList;
    }

    @Override
    public ResponseCartDto saveCart(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setItems(cartDto.getItems()
                .stream()
                .map( itemDto -> {
                    Item item = new Item();
                    item.setNote(itemDto.getNote());
                    item.setCart(cart);
                    return item;
                })
                .collect(Collectors.toSet()));
        cartRepository.save(cart);
        return new ResponseCartDto(cartDto, "Cart saved!");
    }
}
