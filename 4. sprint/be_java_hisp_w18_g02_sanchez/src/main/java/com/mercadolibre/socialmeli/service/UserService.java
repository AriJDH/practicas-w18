package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.ProductDto;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.dto.response.*;
import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.Product;
import com.mercadolibre.socialmeli.entity.User;
import com.mercadolibre.socialmeli.exception.BadRequestException;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    /**
     * US0001
     *
     * @param userId
     * @param userIdToFollow
     * @return
     */
    @Override
    public String follow(Integer userId, Integer userIdToFollow) {
        this.userRepository.follow(userId, userIdToFollow);
        return "El usuario " + userId + " ahora sigue al usuario " + userIdToFollow;
    }

    /**
     * US0002
     *
     * @param id
     * @return
     */
    @Override
    public SellerFollowerCountDtoRes getCount(Integer id) {
        List<User> followers = userRepository.getFollowers(id);
        Integer count = followers.size();

        User user = userRepository.findById(id);

        return new SellerFollowerCountDtoRes(id, user.getName(), count);
    }

    /**
     * US 0003
     *
     * @param id
     * @param order
     * @return
     */
    @Override
    public SellerFollowerListDtoRes getFollowers(Integer id, String order) {
        List<User> followers = userRepository.getFollowers(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followers.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new SellerFollowerListDtoRes(id, user.getName(), order(usersDtosRes, order));
    }

    /**
     * US0004
     *
     * @param id
     * @param order
     * @return
     */
    @Override
    public UserFollowedListDtoRes getFollowed(Integer id, String order) {
        List<User> followed = userRepository.getFollowed(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtosRes = followed.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new UserFollowedListDtoRes(id, user.getName(), order(usersDtosRes, order));
    }

    private List<UserDtoRes> order(List<UserDtoRes> usersDtosRes, String order) {
        if (order != null && order.equals("name_asc")) {
            usersDtosRes = usersDtosRes.stream()
                    .sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName()))
                    .collect(Collectors.toList());
        } else if (order != null && order.equals("name_desc")) {
            usersDtosRes = usersDtosRes.stream()
                    .sorted(Comparator.comparing(UserDtoRes::getName).reversed())
                    .collect(Collectors.toList());
        }
        return usersDtosRes;
    }

    /**
     * US0005 y US0010
     *
     * @param postReq
     */
    @Override
    public void addPost(PostDtoReq postReq) {
        if(postReq.getDiscount()<0 || postReq.getDiscount() > 100)
            throw new IllegalArgumentException("El descuento debe ser un valor entre 0 y 100.");
        if(postReq.getPrice()<0)
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");

        Post post;
        Product prod;
        try {
            prod = new Product(postReq.getProduct().getId(),
                    postReq.getProduct().getName(),
                    postReq.getProduct().getType(),
                    postReq.getProduct().getBrand(),
                    postReq.getProduct().getColor(),
                    postReq.getProduct().getNotes());
            post = new Post(userRepository.getNextPostId(),
                    postReq.getDate(),
                    postReq.getCategory(),
                    postReq.getPrice(),
                    prod,
                    postReq.isHasPromo(),
                    postReq.getDiscount());
            userRepository.createPost(postReq.getUserId(), post);

        } catch (NotFoundException nf) {
            throw nf;
        } catch (Exception e) {
            throw new BadRequestException("Posteo invalido");
        }

    }

    /**
     * US0006 / US0009
     *
     * @param userId
     * @param order
     * @return
     */
    @Override
    public PostsGroupedByUserDtoRes getRecentPosts(Integer userId, String order) {
        List<User> followed = userRepository.getFollowed(userId);
        LocalDate now = LocalDate.now();
        LocalDate twoWeeksAgo = now.minusWeeks(2);

        List<PostDtoRes> postsRes = followed.stream()
                .flatMap(f -> f.getPosts().stream())
                .filter(p -> (p.getDate().isAfter(twoWeeksAgo) && p.getDate().isBefore(now.plusDays(1))))
                .map(p -> getPostDtoRes(p, userId)).collect(Collectors.toList());

        if (order != null && order.equals("date_desc")) {
            postsRes.sort(Comparator.comparing(PostDtoRes::getDate).reversed());
        } else if (order != null && order.equals("date_asc")) {
            postsRes.sort(Comparator.comparing(PostDtoRes::getDate));
        }

        return new PostsGroupedByUserDtoRes(userId, null, postsRes);
    }

    /**
     * US0007
     *
     * @param userId
     * @param userIdToUnfollow
     * @return
     */
    @Override
    public String unfollow(Integer userId, Integer userIdToUnfollow) {
        this.userRepository.unfollow(userId, userIdToUnfollow);
        return "El usuario " + userId + " dejó de seguir al usuario " + userIdToUnfollow;
    }

    /**
     * US0011
     * @param userId
     * @return
     */
    @Override
    public SellerPromoCountDtoRes getSellerPromoCount(Integer userId){
        User seller = this.userRepository.findById(userId);
        if(seller == null) throw new NotFoundException("No se encontró un usuario con id "+userId);
        return new SellerPromoCountDtoRes(seller.getId(), seller.getName(), (int)seller.getPosts().stream().filter(p -> p.isHasPromo()).count());
    }

    /**
     * US0012
     * @param userId
     * @param order
     * @return
     */
    @Override
    public PostsGroupedByUserDtoRes getSellerPromoList(Integer userId, String order){
        User user = this.userRepository.findById(userId);
        if(user == null) throw new NotFoundException("No se encontró un usuario con id "+userId);
        if(!user.isSeller())throw new IllegalArgumentException("El usuario id "+userId+" no es vendedor");

        List<Post> promos = user.getPromoPosts();
        if(promos.size() == 0) throw new NotFoundException("El vendedor con id "+userId+" no tiene ninguna promoción actualmente.");

        List<PostDtoRes> promosDto = promos.stream().map(p -> getPostDtoRes(p, userId)).collect(Collectors.toList());
        sortPostByName(promosDto, order);
        return new PostsGroupedByUserDtoRes(user.getId(), user.getName(), promosDto);
    }

    /**
     * US0013 Get All Promos.
     * @param order
     * @return
     */
    @Override
    public List<PostDtoRes> getAllPromos(String order){
        List<User> sellers = userRepository.getAllSellers();
        List<PostDtoRes> promos = new ArrayList<>();

        for(User seller : sellers){
            for(Post p : seller.getPosts()){
                if(p.isHasPromo())promos.add(getPostDtoRes(p, seller.getId()));
            }
        }
        if(promos.size()== 0)throw new NotFoundException("No hay promociones para mostrar.");
        sortPostByName(promos, order);
        return promos;
    }

    private PostDtoRes getPostDtoRes(Post p, Integer userId){
        return new PostDtoRes(
                userId,
                p.getId(),
                p.getDate(),
                new ProductDto(p.getProduct().getId(),
                        p.getProduct().getName(),
                        p.getProduct().getType(),
                        p.getProduct().getBrand(),
                        p.getProduct().getColor(),
                        p.getProduct().getNotes()),
                p.getCategory(),
                p.getPrice(),
                p.isHasPromo(),
                p.getDiscount());
    }

    private void sortPostByName(List<PostDtoRes> postsRes, String order){
        if (order != null && order.equals("name_desc")) {
            postsRes.sort((x, y) ->-1* x.getProduct().getName().compareToIgnoreCase(y.getProduct().getName()));
        } else if (order != null && order.equals("name_asc")) {
            postsRes.sort((x, y) -> x.getProduct().getName().compareToIgnoreCase(y.getProduct().getName()));
        }
    }

}
