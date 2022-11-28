package com.sprint1.be_java_hisp_w18_g03.units.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponsePostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.Category;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.Product;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * T-0008, escenario exitoso
     */
    @Test
    @DisplayName("Verificar que las publicaciones sean de las ultimas dos semanas")
    public void getPostSellers() {
        //Arrange
        User user = UserFactory.getUserPostSeller();
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellers());

        //Act
        SellersPostDTO sellersPostDTO = postServiceImp.getPostSellers(1, null);

        //Assert
        assertNotNull(sellersPostDTO.getUserId(), "El id del usuario no debe ser nulo");
        assertNotNull(sellersPostDTO.getPosts(), "La lista de post no debe ser nula");
        assertFalse(sellersPostDTO.getPosts().isEmpty(), "La lista de post no debe venir vacia");

        //Obtener post que este entre las dos semanas y la actual
        LocalDate fechaSin2Semana = LocalDate.now().minusDays(14);

        List<ResponsePostDTO> postFilter = sellersPostDTO.getPosts().stream()
                .filter(x -> x.getDate().isAfter(fechaSin2Semana))
                .collect(Collectors.toList());

        assertFalse(postFilter.isEmpty(), "La lista de post entre las dos semanas y la fecha actual no debe ser vacia");
        assertEquals(postFilter.size(), 1, "Solo debe haber un post en la lista filtrada");
        assertEquals(postFilter.get(0).getDate(), LocalDate.now(), "La fecha de post debe ser igual a la del sistema");
    }

    @Test
    @DisplayName("T-0005 - Verificar que el tipo de ordenamiento por fecha exista - OK")
    public void getPostSellersOrderOk(){
        //Arrange
        User user = UserFactory.getUserPostSeller();
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellers());
        //Act
        SellersPostDTO sellersPostDTO = postServiceImp.getPostSellers(1, "date_asc");
        assertNotNull(sellersPostDTO);
    }

    @Test
    @DisplayName("T-0005 - Verificar que el tipo de ordenamiento por fecha exista - NO OK")
    public void getPostSellersOrderNoOk(){
        //Arrange
        User user = UserFactory.getUserPostSeller();
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellers());
        //Act
        ParamException paramException = assertThrows(ParamException.class,()->postServiceImp.getPostSellers(1, anyString()));
        assertNotNull(paramException);
    }

    @Test
    @DisplayName("Verificar el correcto ordenamiento ascendente por fecha. ")
    public void getPostSellersOrderByDateASC() {

        //Arrange
        User user = UserFactory.getUserPostSeller();
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellersOrder());

        //Act
        SellersPostDTO sellersPostDTO = postServiceImp.getPostSellers(1, "date_asc");

        //Assert
        assertNotNull(sellersPostDTO.getUserId(), "El id del usuario no debe ser nulo");
        assertNotNull(sellersPostDTO.getPosts(), "La lista de post no debe ser nula");
        assertFalse(sellersPostDTO.getPosts().isEmpty(), "La lista de post no debe venir vacia");
        assertEquals(sellersPostDTO.getPosts().size(), 2, "La lista de post debe traer dos registros");

        ResponsePostDTO postMenosReciente = sellersPostDTO.getPosts().get(0);
        ResponsePostDTO postMasReciente = sellersPostDTO.getPosts().get(1);

        boolean isAscendente = postMenosReciente.getDate().isBefore(postMasReciente.getDate());
        
        assertTrue(isAscendente, "El indicador debe indicar verdadero");
    }

    @Test
    @DisplayName("Verificar el correcto ordenamiento descendente por fecha. ")
    public void getPostSellersOrderByDateDESC() {

        //Arrange
        User user = UserFactory.getUserPostSeller();
        when(userRepository.findById(any())).thenReturn(user);
        when(postRepository.findByUser(any())).thenReturn(PostFactory.getPostSellersOrder());

        //Act
        SellersPostDTO sellersPostDTO = postServiceImp.getPostSellers(1, "date_desc");

        //Assert
        assertNotNull(sellersPostDTO.getUserId(), "El id del usuario no debe ser nulo");
        assertNotNull(sellersPostDTO.getPosts(), "La lista de post no debe ser nula");
        assertFalse(sellersPostDTO.getPosts().isEmpty(), "La lista de post no debe venir vacia");
        assertEquals(sellersPostDTO.getPosts().size(), 2, "La lista de post debe traer dos registros");

        ResponsePostDTO postMasReciente = sellersPostDTO.getPosts().get(0);
        ResponsePostDTO postMenosReciente = sellersPostDTO.getPosts().get(1);

        boolean isAscendente = postMasReciente.getDate().isAfter(postMenosReciente.getDate());

        assertTrue(isAscendente, "El indicador debe indicar verdadero");
    }
}
