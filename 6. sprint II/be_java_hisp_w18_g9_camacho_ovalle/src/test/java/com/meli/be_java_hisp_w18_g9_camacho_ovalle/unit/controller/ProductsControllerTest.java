package com.meli.be_java_hisp_w18_g9_camacho_ovalle.unit.controller;

import com.meli.be_java_hisp_w18_g9_camacho_ovalle.controller.ProductsController;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.PostListByFollowedResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Product;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.service.IPostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductsControllerTest {

    // ? ================= Attributes ================= ?

    @Mock
    private IPostService postService;

    @InjectMocks
    private ProductsController productsController;

    // ? ================= Tests ================= ?

    @Test
    @DisplayName("[T005] - Get followed posts by user id - Without order filter")
    void findFollowedByUserId() {

        PostDtoRequest postDtoRequest1 = new PostDtoRequest(1, 1, LocalDate.now(), new Product(), 1, 10.0);
        PostDtoRequest postDtoRequest2 = new PostDtoRequest(1, 1, LocalDate.now().minusDays(5), new Product(), 1, 10.0);

        PostListByFollowedResponse postListByFollowedResponse = new PostListByFollowedResponse(1, List.of(postDtoRequest1, postDtoRequest2));

        when(postService.findPostsByFollowedAndUserId(anyInt())).thenReturn(postListByFollowedResponse);

        ResponseEntity<PostListByFollowedResponse> response = productsController.findFollowedByUserId(1, null);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, Objects.requireNonNull(response.getBody()).getPosts().size());
        assertEquals(LocalDate.now(), response.getBody().getPosts().get(0).getDate());
        assertEquals(LocalDate.now().minusDays(5), response.getBody().getPosts().get(1).getDate());

    }

    // * ============= *

    @Test
    @DisplayName("[T006] - Get followed posts by user id - With order date asc filter")
    void findFollowedByUserIdWithOrderDateAsc() {

        PostDtoRequest postDtoRequest1 = new PostDtoRequest(1, 1, LocalDate.now(), new Product(), 1, 10.0);
        PostDtoRequest postDtoRequest2 = new PostDtoRequest(1, 1, LocalDate.now().minusDays(5), new Product(), 1, 10.0);

        PostListByFollowedResponse postListByFollowedResponse = new PostListByFollowedResponse(1, Stream.of(postDtoRequest1, postDtoRequest2).sorted(Comparator.comparing(PostDtoRequest::getDate)).collect(Collectors.toList()));

        when(postService.findPostsByFollowedAndUserIdOrderByDateAsc(anyInt())).thenReturn(postListByFollowedResponse);

        ResponseEntity<PostListByFollowedResponse> response = productsController.findFollowedByUserId(1, "date_asc");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, Objects.requireNonNull(response.getBody()).getPosts().size());
        assertEquals(LocalDate.now().minusDays(5), response.getBody().getPosts().get(0).getDate());
        assertEquals(LocalDate.now(), response.getBody().getPosts().get(1).getDate());

    }

    // * ============= *

    @Test
    @DisplayName("[T006] - Get followed posts by user id - With order date desc filter")
    void findFollowedByUserIdWithOrderDateDesc() {

        PostDtoRequest postDtoRequest1 = new PostDtoRequest(1, 1, LocalDate.now(), new Product(), 1, 10.0);
        PostDtoRequest postDtoRequest2 = new PostDtoRequest(1, 1, LocalDate.now().minusDays(5), new Product(), 1, 10.0);

        PostListByFollowedResponse postListByFollowedResponse = new PostListByFollowedResponse(1, Stream.of(postDtoRequest1, postDtoRequest2).sorted(Comparator.comparing(PostDtoRequest::getDate).reversed()).collect(Collectors.toList()));

        when(postService.findPostsByFollowedAndUserIdOrderByDateDesc(anyInt())).thenReturn(postListByFollowedResponse);

        ResponseEntity<PostListByFollowedResponse> response = productsController.findFollowedByUserId(1, "date_desc");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, Objects.requireNonNull(response.getBody()).getPosts().size());
        assertEquals(LocalDate.now(), response.getBody().getPosts().get(0).getDate());
        assertEquals(LocalDate.now().minusDays(5), response.getBody().getPosts().get(1).getDate());

    }

    // * ============= *

    @Test
    @DisplayName("[T005] - Get followed posts by user id - With invalid filter")
    void findFollowedByUserIdWithInvalidFilter() {

        BadRequestException exception = assertThrows(BadRequestException.class, () -> productsController.findFollowedByUserId(1, "invalid"));
        assertEquals("The order invalid is not valid, please use date_asc or date_desc", exception.getMessage());

    }


}