package com.sprint1.be_java_hisp_w18_g03.units.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponsePostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.exception.ParamException;
import com.sprint1.be_java_hisp_w18_g03.service.PostServiceImp;
import com.sprint1.be_java_hisp_w18_g03.utils.PostFactory;
import com.sprint1.be_java_hisp_w18_g03.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    IUserRepository userRepository;

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    PostServiceImp postServiceImp;

    @Test
    @DisplayName("T-0008 Verificar que las publicaciones sean de las ultimas dos semanas US0006- OK")
    public void getPostSellersOk() {
        //Arrange
        User user = UserFactory.getUserPostSeller();

        //Mock
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellers());

        //Act
        SellersPostDTO sellersPostDTO = postServiceImp.getPostSellers(1, null);

        //Assert
        assertFalse(sellersPostDTO.getPosts().isEmpty(), "La lista de post no debe venir vacia");

        assertAll(
                () -> assertFalse(sellersPostDTO.getPosts().isEmpty(), "La lista de post entre las dos semanas y la fecha actual no debe ser vacia"),
                () -> assertEquals(2, sellersPostDTO.getPosts().size(), "Solo debe haber un post en la lista filtrada"),
                () -> assertEquals(LocalDate.now(), sellersPostDTO.getPosts().get(0).getDate(), "La fecha de post debe ser igual a la del sistema"),
                () -> assertEquals(2, sellersPostDTO.getPosts().get(0).getPostId() , "El id del post debe ser 2")

        );

    }

    @Test
    @DisplayName("T-0005 - Verificar que el tipo de ordenamiento por fecha exista US0009- OK")
    public void getPostSellersOrderOk() {
        //Arrange
        User user = UserFactory.getUserPostSeller();
        //Mock
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellers());
        //Act
        SellersPostDTO sellersPostDTO = postServiceImp.getPostSellers(1, "date_asc");
        //Assert
        assertNotNull(sellersPostDTO, "Se espera un tipo de ordenamiento valido");
    }

    @Test
    @DisplayName("T-0005 - Verificar que el tipo de ordenamiento por fecha exista US0009- No existe el tipo de ordenamiento")
    public void getPostSellersOrderNoOk() {
        //Arrange
        User user = UserFactory.getUserPostSeller();
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellers());
        //Act
        ParamException paramException = assertThrows(ParamException.class, () -> postServiceImp.getPostSellers(1, anyString()));
        assertNotNull(paramException, "Se espera un tipo de ordenamiento invalido");
    }

    @Test
    @DisplayName("T-0006 Verificar el correcto ordenamiento ascendente por fecha. US0009 - OK Ascendente")
    public void getPostSellersOrderByDateAscOK() {

        //Arrange
        User user = UserFactory.getUserPostSeller();

        //Mock
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellersOrder());

        //Act
        SellersPostDTO sellersPostDTO = postServiceImp.getPostSellers(1, "date_asc");

        //Assert
        assertFalse(sellersPostDTO.getPosts().isEmpty(), "La lista de post no debe venir vacia");
        assertEquals(2, sellersPostDTO.getPosts().size(), "La lista de post debe traer dos registros");

        ResponsePostDTO postMenosReciente = sellersPostDTO.getPosts().get(0);
        ResponsePostDTO postMasReciente = sellersPostDTO.getPosts().get(1);

        assertTrue(postMenosReciente.getDate().isBefore(postMasReciente.getDate()), "El indicador debe indicar verdadero");
    }

    @Test
    @DisplayName("T-0006 Verificar el correcto ordenamiento descendente por fecha. US0009 - OK desc")
    public void getPostSellersOrderByDateDescOk() {

        //Arrange
        User user = UserFactory.getUserPostSeller();

        //Mok
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellersOrder());

        //Act
        SellersPostDTO sellersPostDTO = postServiceImp.getPostSellers(1, "date_desc");

        //Assert
        assertFalse(sellersPostDTO.getPosts().isEmpty(), "La lista de post no debe venir vacia");
        assertEquals(2, sellersPostDTO.getPosts().size(),"La lista de post debe traer dos registros");

        ResponsePostDTO postMasReciente = sellersPostDTO.getPosts().get(0);
        ResponsePostDTO postMenosReciente = sellersPostDTO.getPosts().get(1);

        assertTrue(postMasReciente.getDate().isAfter(postMenosReciente.getDate()), "El indicador debe indicar verdadero");
    }
}
