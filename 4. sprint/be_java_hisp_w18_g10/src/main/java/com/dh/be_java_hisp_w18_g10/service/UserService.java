package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.exception.UserGenericException;
import com.dh.be_java_hisp_w18_g10.exception.UserNotFoundException;
import com.dh.be_java_hisp_w18_g10.exception.ProductNotFoundException;
import com.dh.be_java_hisp_w18_g10.exception.UserIdNullException;
import com.dh.be_java_hisp_w18_g10.exception.UserNotFoundException;
import com.dh.be_java_hisp_w18_g10.exception.NotFoundException;
import com.dh.be_java_hisp_w18_g10.repository.*;
import com.dh.be_java_hisp_w18_g10.util.DTOMapper;
import com.dh.be_java_hisp_w18_g10.util.DateHandler;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.dh.be_java_hisp_w18_g10.util.DTOMapper.mapToUserFollowedRes;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;
    private IProductRepository productRepository;
    private IPostRepository postRepository;

    public UserService(UserRepository userRepository, ProductRepository productRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.postRepository = postRepository;
    }

    public void addPost(PostDTOreq postDTO){
        //TODO implement
        Post post = new Post();
        int userId = postDTO.getUser_id();
        userRepository
                .getUser(userId)
                .getPosts()
                .put(userId, post);

        postRepository.addPost(post);
    }
    @Override
    public void followUser(int userId, int userIdToFollow) {
        User user1 = userRepository.getUser(userId);
        User user2 = userRepository.getUser(userIdToFollow);

        if(user1 == null){
            throw new NotFoundException("El usuario con el id: "+userId+" no fue encontrado!");
        }
        if(user2 == null){
            throw new NotFoundException("El usuario con el id: "+userId+" no fue encontrado!");
        }

        user1.getFollowed().put(user2.getUserId(),user2);
        user2.getFollowers().put(user1.getUserId(), user1);
    }

    @Override
    public UserFollowersCountDTOres getUserFollowersCount(int userId) {
        User user = userRepository.getUser(userId);
        if(user == null){
            throw new NotFoundException("El usuario con el id: "+userId+" no fue encontrado!");
        }
        return new UserFollowersCountDTOres(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers().size()
        );
    }

    @Override
    public UserFollowersListDTOres getUserFollowerList(int userId) {
       return DTOMapper.mapToUserFollowersRes(userRepository.getUserFollowers(userId));
    }

    @Override
    public UserFollowedListDTOres getUserFollowed(int userId) {

        User user = userRepository.getUser(userId);

        int userAuxId = user.getUserId();
        String userName = user.getUserName();
        Map<Integer, User> followed = user.getFollowed();


        List<UserDTOres> followedList = new ArrayList<>();

        for (Map.Entry<Integer, User> f : followed.entrySet()) {
            UserDTOres userDTOres = new UserDTOres(f.getValue().getUserId(), f.getValue().getUserName());
            followedList.add(userDTOres);
        }

        return new UserFollowedListDTOres(userAuxId, userName, followedList);

       /* User user = userRepository.getUser(userId);
        UserFollowedListDTOres userFollowedDTOres = mapToUserFollowedRes(user);
        return userFollowedDTOres;*/
    }

    @Override
    public void createPost(PostDTOreq postDTOreq) {
        try {
            int userId = postDTOreq.getUser_id();
            int productId = postDTOreq.getProduct().getProduct_id();
            if (userRepository.getUsers().get(userId) == null)
                throw new UserNotFoundException("Usuario no encontrado!");
            if (productRepository.getProductById(productId) == null)
                throw new ProductNotFoundException("Producto no encontrado.");

            Post post = DTOMapper.mapToPost(postDTOreq);

            Integer postId = postRepository.addPost(post);
            userRepository
                    .getUser(userId)
                    .getPosts()
                    .put(postId, post);
        }
        catch (NullPointerException e) {
             throw new UserIdNullException("Atributo null en user");
        }

    }

    @Override
    public UserPostsDTOres getUserPosts(int userId) {
        UserPostsDTOres userPostsDTOres = new UserPostsDTOres();
        //Obtener usuario
        User user = userRepository.getUser(userId);
        if(user == null)
            throw new UserNotFoundException("No existe usuario con id " + userId);
        //Chequear que usuario siga a algun vendedor
        if(user.getFollowed().isEmpty()){
            throw new UserGenericException(String.format("El usuario %s no sigue vendedeores"
                    ,user.getUserName()));
        }
        //
        //Lista de Post de vendedores que el usaurio sigue
        List<PostDTOres> postListRes = new ArrayList<>();
        /*Recorro cada vendedor que el usuario sigue
        * Recorro sus Post en caso de tener
        * Asigno los post a la lista postListRes*/
        for (Map.Entry<Integer, User> entry : user.getFollowed().entrySet()) {
            User userVendedor = userRepository.getUser(entry.getKey());
            //Recorro Post para mapearlo y agregarlo a la lista
            if(!userVendedor.getPosts().isEmpty()){
                for (Map.Entry<Integer, Post> posts : userVendedor.getPosts().entrySet()){
                    //Controlo que la fecha de publicacion no se mayor a 2 semanas
                    if(DateHandler.showPostRecently(posts.getValue().getDate()))
                        postListRes.add(DTOMapper.mapTo(posts.getValue()));
                }
            }
        }
        //Chequeo que tengamos algun Post para mostrar
        if (postListRes.isEmpty()){
            throw new UserGenericException(String.format("Los vendedores que sigue el usuario %s , no tienen publicaciones en las ultimas 2 semanas"
                    ,user.getUserName()));
        }

        //descendente  ******** ME QUEDARIA MNAS COMODO QUE EL DATE DE POSTDTO SEA UN LOCALDATE NO UN STRING
        postListRes = postListRes.stream().sorted(Comparator.comparing(PostDTOres::getDate).reversed()).collect(Collectors.toList());
        //ascendente
        if(false)
            postListRes = postListRes.stream().sorted(Comparator.comparing(PostDTOres::getDate)).collect(Collectors.toList());

        userPostsDTOres.setUser_id(userId);
        userPostsDTOres.setPosts(postListRes);
        return userPostsDTOres;
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        userRepository.getUser(userId).getFollowed().remove(userIdToUnfollow);
    }


}
