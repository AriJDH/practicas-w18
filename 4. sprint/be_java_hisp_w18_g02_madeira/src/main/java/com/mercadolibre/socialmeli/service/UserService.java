package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.dto.PromoPostDto;
import com.mercadolibre.socialmeli.dto.response.*;
import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.User;
import com.mercadolibre.socialmeli.exception.BadRequestException;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.repository.IUserRepository;
import com.mercadolibre.socialmeli.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * US0001
     * Follow a Seller
     * @param userId User
     * @param userIdToFollow Seller to Follow
     * @return Success message
     */
    @Override
    public String follow(Integer userId, Integer userIdToFollow) {
        this.userRepository.follow(userId, userIdToFollow);
        return "User " + userId + " is now following user " + userIdToFollow;
    }

    /**
     * US0002
     * Gets how many users follows the seller.
     * @param id Seller ID
     * @return SellerId, Name and Count
     */
    @Override
    public SellerFollowerCountDtoRes getCount(Integer id) {
        List<User> followers = userRepository.getFollowers(id);
        Integer count = followers.size();
        User user = userRepository.findById(id);
        return new SellerFollowerCountDtoRes(id, user.getName(), count);
    }

    /**
     * US0003
     * Gets a list of users that follow the seller. If 'order' is 'name_asc' or 'name_desc',
     * the users are sorted.
     * @param id ID of the Seller
     * @param order Ascending(name_asc) or descending(name_desc)
     * @return SellerId, Name and Followers
     */
    @Override
    public SellerFollowerListDtoRes getFollowers(Integer id, String order) {
        List<User> followers = userRepository.getFollowers(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtoRes = followers.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new SellerFollowerListDtoRes(id, user.getName(), order(usersDtoRes, order));
    }

    /**
     * US0004
     * Gets a list of sellers the user is following. If 'order' is 'name_asc' or 'name_desc',
     * the sellers are sorted.
     * @param id User ID
     * @param order Ascending(name_asc) or descending(name_desc)
     * @return UserId, Name and Followed
     */
    @Override
    public UserFollowedListDtoRes getFollowed(Integer id, String order) {
        List<User> followed = userRepository.getFollowed(id);
        User user = userRepository.findById(id);
        List<UserDtoRes> usersDtoRes = followed.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        return new UserFollowedListDtoRes(id, user.getName(), order(usersDtoRes, order));
    }

    private List<UserDtoRes> order(List<UserDtoRes> usersDtoRes, String order) {
        if (order != null && order.equals("name_asc")) {
            usersDtoRes = usersDtoRes.stream()
                    .sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName()))
                    .collect(Collectors.toList());
        } else if (order != null && order.equals("name_desc")) {
            usersDtoRes = usersDtoRes.stream()
                    .sorted(Comparator.comparing(UserDtoRes::getName).reversed())
                    .collect(Collectors.toList());
        }
        return usersDtoRes;
    }

    /**
     * US0005
     * Creates a Post
     * @param postReq Post to save
     */
    @Override
    public String addPost(PostDtoReq postReq) {
        Post post;
        try {
            post = DTOConverter.dtoToEntity(postReq, userRepository.getNextPostId());
            userRepository.createPost(postReq.getUserId(), post);
        } catch (NotFoundException nf) {
            throw nf;
        } catch (Exception e) {
            throw new BadRequestException("Invalid Post");
        }
        return "Post added successfully.";
    }

    /**
     * US0006 / US0009
     * Gets the most recent Posts (2 weeks). If 'order' is 'date_asc' or 'date_desc',
     * the Posts are sorted.
     * @param userId User following Sellers
     * @param order Sorting criteria
     * @return UserId and Recent Posts
     */
    @Override
    public RecentPostsDtoRes getRecentPosts(Integer userId, String order) {
        List<User> followed = userRepository.getFollowed(userId);
        LocalDate now = LocalDate.now();
        LocalDate twoWeeksAgo = now.minusWeeks(2);

        List<PromoPostDto> postsRes = followed.stream()
                .flatMap(f -> f.getPosts().stream())
                .filter(p -> (p.getDate().isAfter(twoWeeksAgo) && p.getDate().isBefore(now.plusDays(1))))
                .map(p -> DTOConverter.entityToDto(p, userId))
                .collect(Collectors.toList());

        orderByDate(order, postsRes);
        return new RecentPostsDtoRes(userId, postsRes);
    }

    private void orderByDate(String order, List<PromoPostDto> postsRes) {
        if (order != null && order.equals("date_desc")) {
            postsRes.sort(Comparator.comparing(PromoPostDto::getDate).reversed());
        } else if (order != null && order.equals("date_asc")) {
            postsRes.sort(Comparator.comparing(PromoPostDto::getDate));
        }
    }

    /**
     * US0007
     * Unfollow a User
     * @param userId User following the seller
     * @param userIdToUnfollow Seller to Unfollow
     * @return Success message
     */
    @Override
    public String unfollow(Integer userId, Integer userIdToUnfollow) {
        this.userRepository.unfollow(userId, userIdToUnfollow);
        return "User " + userId + " unfollowed user " + userIdToUnfollow;
    }

    //////////////////////////INDIVIDUALES///////////////////////////
    /**
     * US0010
     * Creates a Promo Post
     * @param promoPostDto Promo Post to save
     */
    @Override
    public String addPromoPost(PromoPostDto promoPostDto) {
        Post post;
        try {
            post = DTOConverter.dtoToEntity(promoPostDto, userRepository.getNextPostId());
            userRepository.createPost(promoPostDto.getUserId(), post);
        } catch (NotFoundException nf) {
            throw nf;
        } catch (Exception e) {
            throw new BadRequestException("Invalid post.");
        }
        return "Promo Post added successfully.";
    }

    /**
     * US0011
     * Gets the Seller, filters their Posts if 'hasPromo' and counts how many there are.
     * @param userId Seller ID
     * @return SellerID, Name and Count
     */
    @Override
    public PromoPostCountDtoRes countPromoProducts(Integer userId) {
        User user = userRepository.findById(userId);
        Integer count = Math.toIntExact(user.getPosts().stream()
                .filter(Post::getHasPromo)
                .count());
        return new PromoPostCountDtoRes(userId,
                                        user.getName(),
                                        count);
    }

    // BONUS
    /**
     * US0012
     * Gets a Seller and shows a list of their posts filtered by 'hasPromo'
     * @param userId Seller
     * @param order Sorting criteria
     * @return SellerId, Name and Promo Posts
     */
    @Override
    public PromoPostsDtoRes getPromoProducts(Integer userId, String order) {
        User user = userRepository.findById(userId);
        List<PromoPostDto> promoPosts = user.getPosts().stream()
                .filter(Post::getHasPromo)
                .map(p -> DTOConverter.entityToDto(p, userId))
                .collect(Collectors.toList());
        orderByDate(order, promoPosts);
        return new PromoPostsDtoRes(userId,
                user.getName(),
                promoPosts);
    }

    /**
     * US0013
     * Gets all the sellers that are not followed by the User, returns the seller with
     * the most promo posts and shows the list of promo posts
     * @param userId User that will get the recommendation
     * @param order Sorting criteria
     * @return PromoPostsDtoRes SellerID, Name and list of Posts
     */
    @Override
    public PromoPostsDtoRes getPromoRecommendation(Integer userId, String order) {
        List<User> notFollowed = userRepository.getNotFollowed(userId);

        List<PromoPostDto> postsToRecommend = notFollowed.stream()
                .map(u->u.getPosts().stream()
                        .filter(p-> !u.getId().equals(userId) && p.getHasPromo())
                        .map(p -> DTOConverter.entityToDto(p, u.getId()))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList()).stream()
                .max(Comparator.comparing(List::size))
                .orElseThrow(()-> new NotFoundException("There's no recommendations to be made."));
        orderByDate(order, postsToRecommend);
        Integer sellerId = postsToRecommend.get(0).getUserId();
        String name = userRepository.findById(sellerId).getName();
        return new PromoPostsDtoRes(sellerId, name, postsToRecommend);
    }

}
