package com.socialmeli.be_java_hisp_w18g05.unit.service;

import com.socialmeli.be_java_hisp_w18g05.dto.response.PostDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.ProductDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerPostListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Post;
import com.socialmeli.be_java_hisp_w18g05.entity.Product;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import com.socialmeli.be_java_hisp_w18g05.exceptions.InvalidException;
import com.socialmeli.be_java_hisp_w18g05.exceptions.InvalidParameterException;
import com.socialmeli.be_java_hisp_w18g05.exceptions.NotFoundException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli.be_java_hisp_w18g05.repository.IRepository;
import com.socialmeli.be_java_hisp_w18g05.service.ServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static com.socialmeli.be_java_hisp_w18g05.utils.UtilsTest.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    IRepository iRepository;
    @InjectMocks
    ServiceImp serviceImp;

    @Test
    @DisplayName("T-0001 // Add follow, OK")
    public void addFollowOk(){
        Seller seller = new Seller(10,"Seller10");
        Buyer buyer = new Buyer(1,"Buyer1");

        lenient().when(iRepository.getByIdSeller(seller.getUser_id())).thenReturn(seller);
        lenient().when(iRepository.getByIdBuyer(buyer.getUser_id())).thenReturn(buyer);

        iRepository.addFollowed(buyer, seller);
        iRepository.addFollower(buyer, seller);
        verify(iRepository,times(1)).addFollower(buyer, seller);
        verify(iRepository,times(1)).addFollowed(buyer, seller);
    }

    @Test
    @DisplayName("T-0001 // Add follow, seller doesn't exist")
    public void addFollowSellerDoesntExist(){
        lenient().when(iRepository.getByIdSeller(1)).thenReturn(null); // averiguar que es lenient

        Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(1, 10));
    }

    @Test
    @DisplayName("T-0001 // Add follow, buyer doesn't exist")
    public void addFollowBuyerDoesntExist(){
        lenient().when(iRepository.getByIdBuyer(10)).thenReturn(null); // averiguar que es lenient

        Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(1, 10));
    }

    @Test
    @DisplayName("T-0001 // Add follow, buyer and seller don't exist")
    public void addFollowBuyerAndSellerDontExist(){
        lenient().when(iRepository.getByIdSeller(1)).thenReturn(null);
        lenient().when(iRepository.getByIdBuyer(10)).thenReturn(null);

        Assertions.assertAll(
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(1, null)),
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(null, 10))
        );
    }

    @Test
    @DisplayName("T-0002 // Unfollow, OK")
    public void unFollowOk(){
        Seller seller = new Seller(10,"Seller10");
        Buyer buyer = new Buyer(1,"Buyer1");
        lenient().when(iRepository.getByIdSeller(seller.getUser_id())).thenReturn(seller);
        lenient().when(iRepository.getByIdBuyer(buyer.getUser_id())).thenReturn(buyer);
        iRepository.unfollow(buyer,seller);
        verify(iRepository,times(1)).unfollow(buyer,seller);
    }
    @Test
    @DisplayName("T-0002 // Unfollow, not found")
    public void unFollowDontExist() {
        lenient().when(iRepository.getByIdSeller(1)).thenReturn(null);
        lenient().when(iRepository.getByIdBuyer(10)).thenReturn(null);
        Assertions.assertAll(
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.unfollow(1, null)),
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.unfollow(null, 10)));
    }

    @Test
    @DisplayName("T-0004 - Verificar el correcto ordenamiento ascendente por nombre. (US-0008 - US-0003)")
    void test0004Asc0803() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "name_asc";
        Seller sellerMock = getSellerWithListOrderAsc(userId); // utils static method
        List<Buyer> expected = sellerMock.getFollowers();
        //========= Mock =============
        when(iRepository.getByIdSeller(userId)).thenReturn(sellerMock);
        //========= Act  =============
        List<BuyerDTOResponse> result = serviceImp.followersFilter(userId, order).getFollowers();
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
        );
    }

    @Test
    @DisplayName("T-0004 - Verificar el correcto ordenamiento descendente por nombre. (US-0008 - US-0003)")
    void test0004Desc0803() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "name_desc";
        Seller sellerMock = getSellerWithListOrderDesc(userId); // utils static method
        List<Buyer> expected = sellerMock.getFollowers();
        //========= Mock =============
        when(iRepository.getByIdSeller(userId)).thenReturn(sellerMock);
        //========= Act  =============
        List<BuyerDTOResponse> result = serviceImp.followersFilter(userId, order).getFollowers();
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
        );
    }

    @Test
    @DisplayName("T-0004 - Verificar el correcto ordenamiento ascendente por nombre. (US-0008 - US-0004)")
    void test0004Asc0804() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "name_asc";
        Buyer buyerMock = getBuyerWithListOrderAsc(userId); // utils static method
        List<Seller> expected = buyerMock.getFolloweds();
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        List<SellerDTOResponse> result = serviceImp.followedsFilter(userId, order).getFollowed();
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
        );
    }

    @Test
    @DisplayName("T-0004 - Verificar el correcto ordenamiento descendente por nombre. (US-0008 - US-0004)")
    void test0004Desc0804() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "name_desc";
        Buyer buyerMock = getBuyerWithListOrderDesc(userId); // utils static method
        List<Seller> expected = buyerMock.getFolloweds();
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        List<SellerDTOResponse> result = serviceImp.followedsFilter(userId, order).getFollowed();
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
        );
    }

    @Test
    @DisplayName("T-0006 - Verificar el correcto ordenamiento por fecha ascendente. (US-0009)")
    void test0006Asc(){
        //========= Arrange =============
        Integer userId = 1;
        String order = "date_asc";
        List<Seller> sellerList = new ArrayList<>();
        // Utilizamos un objectMapper
        ObjectMapper op = new ObjectMapper();
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // lista de post del seller 10
        List<Post> postList1 = new ArrayList<>();
        Post post1 = new Post(1, LocalDate.now().minusDays(11), new Product(10, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post2 = new Post(2, LocalDate.now().minusDays(10), new Product(22, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post3 = new Post(3, LocalDate.now().minusDays(6), new Product(33, "Name", "type", "brand", "color", "notes"), 100, 25D);
        postList1.add(post1);
        postList1.add(post2);
        postList1.add(post3);
        // lista de post del seller 20
        List<Post> postList2 = new ArrayList<>();
        Post post4 = new Post(4, LocalDate.now().minusDays(4), new Product(44, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post5 = new Post(5, LocalDate.now().minusDays(1), new Product(55, "Name", "type", "brand", "color", "notes"), 100, 25D );
        postList2.add(post4);
        postList2.add(post5);
        // Creación de los sellers
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        // asignamos post a los sellers
        sellerList.get(0).setPosts(postList1);
        sellerList.get(1).setPosts(postList2);
        // Creamos comprador con la lista de sellers que sigue
        Buyer buyerMock = new Buyer(userId, "Buyer1", sellerList);
        // Creamos el expected con los post como deberían estar ordenados.
        List<PostDTOResponse> postDTOResponseList = new ArrayList<>();
        postDTOResponseList.add(new PostDTOResponse(10, post1.getPost_id(), post1.getDate().toString(), op.convertValue(post1.getProduct(), ProductDTOResponse.class), post1.getCategory(), post1.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post2.getPost_id(), post2.getDate().toString(), op.convertValue(post2.getProduct(), ProductDTOResponse.class), post2.getCategory(), post2.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post3.getPost_id(), post3.getDate().toString(), op.convertValue(post3.getProduct(), ProductDTOResponse.class), post3.getCategory(), post3.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post4.getPost_id(), post4.getDate().toString(), op.convertValue(post4.getProduct(), ProductDTOResponse.class), post4.getCategory(), post4.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post5.getPost_id(), post5.getDate().toString(), op.convertValue(post5.getProduct(), ProductDTOResponse.class), post5.getCategory(), post5.getPrice()));
        SellerPostListDTOResponse expected = new SellerPostListDTOResponse(userId, postDTOResponseList);
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        SellerPostListDTOResponse result = serviceImp.followedPostList(userId, order);
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.getPosts().get(0).getPost_id(), expected.getPosts().get(0).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(1).getPost_id(), expected.getPosts().get(1).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(2).getPost_id(), expected.getPosts().get(2).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(3).getPost_id(), expected.getPosts().get(3).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(4).getPost_id(), expected.getPosts().get(4).getPost_id())
        );
    }

    @Test
    @DisplayName("T-0006 - Verificar el correcto ordenamiento por fecha descendente. (US-0009)")
    void test0006Desc(){
        //========= Arrange ==========
        Integer userId = 1;
        String order = "date_desc";
        List<Seller> sellerList = new ArrayList<>();
        // Utilizamos un objectMapper
        ObjectMapper op = new ObjectMapper();
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // lista de post del seller 10
        List<Post> postList1 = new ArrayList<>();
        Post post1 = new Post(1, LocalDate.now().minusDays(6), new Product(10, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post2 = new Post(2, LocalDate.now().minusDays(8), new Product(22, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post3 = new Post(3, LocalDate.now().minusDays(10), new Product(33, "Name", "type", "brand", "color", "notes"), 100, 25D);
        postList1.add(post1);
        postList1.add(post2);
        postList1.add(post3);
        // lista de post del seller 20
        List<Post> postList2 = new ArrayList<>();
        Post post4 = new Post(4, LocalDate.now().minusDays(11), new Product(44, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post5 = new Post(5, LocalDate.now().minusDays(13), new Product(55, "Name", "type", "brand", "color", "notes"), 100, 25D );
        postList2.add(post4);
        postList2.add(post5);
        // Creación de los sellers
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        // asignamos post a los sellers
        sellerList.get(0).setPosts(postList1);
        sellerList.get(1).setPosts(postList2);
        // Creamos comprador con la lista de sellers que sigue
        Buyer buyerMock = new Buyer(userId, "Buyer1", sellerList);
        // Creamos el expected con los post como deberían estar ordenados.
        List<PostDTOResponse> postDTOResponseList = new ArrayList<>();
        postDTOResponseList.add(new PostDTOResponse(10, post1.getPost_id(), post1.getDate().toString(), op.convertValue(post1.getProduct(), ProductDTOResponse.class), post1.getCategory(), post1.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post2.getPost_id(), post2.getDate().toString(), op.convertValue(post2.getProduct(), ProductDTOResponse.class), post2.getCategory(), post2.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post3.getPost_id(), post3.getDate().toString(), op.convertValue(post3.getProduct(), ProductDTOResponse.class), post3.getCategory(), post3.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post4.getPost_id(), post4.getDate().toString(), op.convertValue(post4.getProduct(), ProductDTOResponse.class), post4.getCategory(), post4.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post5.getPost_id(), post5.getDate().toString(), op.convertValue(post5.getProduct(), ProductDTOResponse.class), post5.getCategory(), post5.getPrice()));
        SellerPostListDTOResponse expected = new SellerPostListDTOResponse(userId, postDTOResponseList);
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        SellerPostListDTOResponse result = serviceImp.followedPostList(userId, order);
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.getPosts().get(0).getPost_id(), expected.getPosts().get(0).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(1).getPost_id(), expected.getPosts().get(1).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(2).getPost_id(), expected.getPosts().get(2).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(3).getPost_id(), expected.getPosts().get(3).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(4).getPost_id(), expected.getPosts().get(4).getPost_id())
        );
    }
    @DisplayName("T-0007 // Followers count is correct, user id exists")
    public void followersCountTest(){
        //Arrange
        Seller seller = new Seller(10,"Seller10");
        Buyer buyer = new Buyer(1,"Buyer1");
        Buyer buyer2 = new Buyer(2,"Buyer2");

        when(iRepository.getByIdSeller(seller.getUser_id())).thenReturn(seller);

        List<Buyer> listaFollowers =new ArrayList<>();
        listaFollowers.add(buyer);
        listaFollowers.add(buyer2);
        Integer tamano= listaFollowers.size();

        SellerFollowersCountDTOResponse expected= new SellerFollowersCountDTOResponse(seller.getUser_id(), seller.getName(), tamano);

        //Act
        seller.addFollower(buyer);
        seller.addFollower(buyer2);
        SellerFollowersCountDTOResponse result= serviceImp.followersCount(seller.getUser_id());

        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("T-0007 // Followers count is correct, user id not exists")
    public void followersCountTestNotExist(){
        //Arrange
        when(iRepository.getByIdSeller(1)).thenReturn(null);

        //Act
        //Assert

        Assertions.assertThrows(NotFoundException.class, () -> serviceImp.followersCount(1));
    }

    @Test
    @DisplayName("T-0008 // Verify post since 2 weeks ago")
    public void postTwoWeeks(){
        //Arrange

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d-MM-uuuu");
        LocalDate date =LocalDate.now().minusDays(7);
        LocalDate date2 =LocalDate.now().minusDays(30);
        LocalDate date3 =LocalDate.now().minusDays(11);

        String datetext = date.format(formatters);
        String datetext2 = date2.format(formatters);
        String datetext3 = date3.format(formatters);

        Buyer buyer = new Buyer(1,"Buyer1");
        Seller seller = new Seller(10,"Seller10");
        Seller seller2 = new Seller(20,"Seller20");

        Product product1= new Product(1,"silla","gamer","racer","red","special");
        Product product2= new Product(1,"silla2","gamer2","racer2","red2","special2");
        Post post1=new Post(1,LocalDate.now().minusDays(7),product1,100,1500.50);
        Post post3=new Post(2,LocalDate.now().minusDays(30),product2,100,1500.50);
        Post post2=new Post(3,LocalDate.now().minusDays(11),product2,200,2500.50);

        ProductDTOResponse product11= new ProductDTOResponse(1,"silla","gamer","racer","red","special");
        ProductDTOResponse product22= new ProductDTOResponse(1,"silla2","gamer2","racer2","red2","special2");
        PostDTOResponse post11=new PostDTOResponse(10,1,datetext,product11,100,1500.50);
        PostDTOResponse post33=new PostDTOResponse(10,2,datetext2,product22,100,1500.50);
        PostDTOResponse post22=new PostDTOResponse(20,3,datetext3,product22,200,2500.50);

        seller.addPost(post1);
        seller.addPost(post3);
        seller2.addPost(post2);

        List<PostDTOResponse> listexpected=new ArrayList<>();
        listexpected.add(post22);
        listexpected.add(post11);
        //listexpected.add(post33);


        when(iRepository.getByIdBuyer(1)).thenReturn(buyer);
        SellerPostListDTOResponse expected = new SellerPostListDTOResponse(buyer.getUser_id(),listexpected);

        buyer.addFollowed(seller);
        buyer.addFollowed(seller2);
        
        //Act
        SellerPostListDTOResponse result= serviceImp.orderByDate(buyer.getUser_id(),"date_asc");

        //Assert
        Assertions.assertEquals(expected,result);
    }


    @Test
    @DisplayName("T-0005 - OK -Verificar que el tipo de ordenamiento por fecha exista (US-0009)")
    void test0005Ok(){
        //========= Arrange ==========
        Integer userId = 1;
        String order = "date_desc";
        List<Seller> sellerList = new ArrayList<>();
        // Utilizamos un objectMapper
        ObjectMapper op = new ObjectMapper();
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // lista de post del seller 10
        List<Post> postList1 = new ArrayList<>();
        Post post1 = new Post(1, LocalDate.now().minusDays(6), new Product(10, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post2 = new Post(2, LocalDate.now().minusDays(8), new Product(22, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post3 = new Post(3, LocalDate.now().minusDays(10), new Product(33, "Name", "type", "brand", "color", "notes"), 100, 25D);
        postList1.add(post1);
        postList1.add(post2);
        postList1.add(post3);
        // lista de post del seller 20
        List<Post> postList2 = new ArrayList<>();
        Post post4 = new Post(4, LocalDate.now().minusDays(11), new Product(44, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post5 = new Post(5, LocalDate.now().minusDays(13), new Product(55, "Name", "type", "brand", "color", "notes"), 100, 25D );
        postList2.add(post4);
        postList2.add(post5);
        // Creación de los sellers
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        // asignamos post a los sellers
        sellerList.get(0).setPosts(postList1);
        sellerList.get(1).setPosts(postList2);
        // Creamos comprador con la lista de sellers que sigue
        Buyer buyerMock = new Buyer(userId, "Buyer1", sellerList);
        // Creamos el expected con los post como deberían estar ordenados.
        List<PostDTOResponse> postDTOResponseList = new ArrayList<>();
        postDTOResponseList.add(new PostDTOResponse(10, post1.getPost_id(), post1.getDate().toString(), op.convertValue(post1.getProduct(), ProductDTOResponse.class), post1.getCategory(), post1.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post2.getPost_id(), post2.getDate().toString(), op.convertValue(post2.getProduct(), ProductDTOResponse.class), post2.getCategory(), post2.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post3.getPost_id(), post3.getDate().toString(), op.convertValue(post3.getProduct(), ProductDTOResponse.class), post3.getCategory(), post3.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post4.getPost_id(), post4.getDate().toString(), op.convertValue(post4.getProduct(), ProductDTOResponse.class), post4.getCategory(), post4.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post5.getPost_id(), post5.getDate().toString(), op.convertValue(post5.getProduct(), ProductDTOResponse.class), post5.getCategory(), post5.getPrice()));
        SellerPostListDTOResponse expected = new SellerPostListDTOResponse(userId, postDTOResponseList);
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        SellerPostListDTOResponse result = serviceImp.followedPostList(userId, order);
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.getPosts().get(0).getPost_id(), expected.getPosts().get(0).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(1).getPost_id(), expected.getPosts().get(1).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(2).getPost_id(), expected.getPosts().get(2).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(3).getPost_id(), expected.getPosts().get(3).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(4).getPost_id(), expected.getPosts().get(4).getPost_id())
        );
    }

    @Test
    @DisplayName("T-0005 - NO OK - Verificar que el tipo de ordenamiento por fecha exista (US-0009)")
    void test0005NotOk(){
        //========= Arrange ==========
        String order = "not_valid";
        int userId = 1;
        List<Seller> sellerList = new ArrayList<>();
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        Buyer buyerMock = new Buyer(userId, "Buyer1",sellerList );
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act & Asserts ====
        Assertions.assertThrows(InvalidException.class, () -> serviceImp.followedPostList(userId, order));
    }

    @Test
    @DisplayName("T-0003 - OK -Verificar que el tipo de ordenamiento alfabético exista (US-0008)")
    void test0003Ok() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "name_desc";
        Buyer buyerMock = getBuyerWithListOrderDesc(userId); // utils static method
        List<Seller> expected = buyerMock.getFolloweds();
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        List<SellerDTOResponse> result = serviceImp.followedsFilter(userId, order).getFollowed();
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
        );
    }

    @Test
    @DisplayName("T-0003 - NO OK - Verificar que el tipo de ordenamiento alfabético exista (US-0008)")
    void test0003NotOk() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "not_valid";
        Buyer buyerMock = getBuyerWithListOrderDesc(userId); // utils static method
        List<Seller> expected = buyerMock.getFolloweds();
        //========= Mock =============
        lenient().when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act Asserts ==============
        Assertions.assertThrows(InvalidParameterException.class, () -> serviceImp.followedsFilter(userId, order));
    }
}

