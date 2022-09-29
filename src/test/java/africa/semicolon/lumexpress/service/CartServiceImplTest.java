package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.model.Cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CartServiceImplTest {
    @Autowired
    private CartService cartService;

    @BeforeEach
    void setUp() {

    }
    @Test
    @DisplayName("test that cart can be created")
    public void creatCartTest(){
       Cart cart =  cartService.create();
        System.out.println(cart.getId());
       assertThat(cart).isNotNull();

    }
}