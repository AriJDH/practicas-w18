package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.PostPromoDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.exception.UserGenericException;
import com.dh.be_java_hisp_w18_g10.exception.UserNotFoundException;
import com.dh.be_java_hisp_w18_g10.exception.NotFoundException;
import com.dh.be_java_hisp_w18_g10.repository.*;
import com.dh.be_java_hisp_w18_g10.util.DTOMapper;
import com.dh.be_java_hisp_w18_g10.util.DateHandler;
import com.dh.be_java_hisp_w18_g10.util.TypeOrderHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AppService implements IAppService {
    private IUserRepository userRepository;
    private IPostRepository postRepository;

    public AppService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void followUser(int userId, int userIdToFollow) {
        User user1 = userRepository.getUser(userId);
        User user2 = userRepository.getUser(userIdToFollow);

        if (user1 == null) {
            throw new UserGenericException("El usuario con el id: " + userId + " no fue encontrado!");
        }
        if (user2 == null) {
            throw new UserGenericException("El usuario con el id: " + userIdToFollow + " no fue encontrado!");
        }

        if (userId == userIdToFollow) {
            throw new UserGenericException("Un usuario no se puede seguir a si mismo!");
        }

        if (!user2.getPosts().isEmpty()) {
            user1.getFollowed().put(user2.getUserId(), user2);
        } else {
            throw new UserGenericException("El usuario con el id: " + userIdToFollow + " no es un vendedor!");
        }
        user2.getFollowers().put(user1.getUserId(), user1);
    }

    @Override
    public UserFollowersCountDTOres getUserFollowersCount(int userId) {
        User user = userRepository.getUser(userId);
        if (user == null) throw new NotFoundException("El usuario con el id: " + userId + " no fue encontrado!");
        return new UserFollowersCountDTOres(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers().size()
        );
    }

    @Override
    public UserFollowersListDTOres getUserFollowerList(int userId) {
        if (userRepository.getUser(userId) == null) {
            throw new UserNotFoundException("No existe usuario con id " + userId);
        }
        return DTOMapper.mapToUserFollowersRes(userRepository.getUser(userId));
    }

    @Override
    public UserFollowedListDTOres getUserFollowed(int userId) {

        User user = userRepository.getUser(userId);
        if (user == null)
            throw new UserNotFoundException("No existe usuario con id " + userId);

        int userAuxId = user.getUserId();
        String userName = user.getUserName();
        Map<Integer, User> followed = user.getFollowed();


        List<UserDTOres> followedList = new ArrayList<>();

        for (Map.Entry<Integer, User> f : followed.entrySet()) {
            UserDTOres userDTOres = new UserDTOres(f.getValue().getUserId(), f.getValue().getUserName());
            followedList.add(userDTOres);
        }

        return new UserFollowedListDTOres(userAuxId, userName, followedList);
    }


    //Post a usar en el la parte individual
    @Override
    public void createPost(PostDTOreq postDTOreq) {

        int userId = postDTOreq.getUser_id();

        if (userRepository.getUser(userId) == null)
            throw new UserGenericException("Usuario no encontrado!"); //funciona

        Post post = DTOMapper.mapToPost(postDTOreq);

        Integer postId = postRepository.addPost(post);
        post.setPost_id(postId);

        userRepository.getUser(userId).getPosts().put(postId, post);
    }

    @Override
    public UserPostsDTOres getUserPosts(int userId, String order) {
        UserPostsDTOres userPostsDTOres = new UserPostsDTOres();
        //Obtener usuario
        User user = userRepository.getUser(userId);
        if (user == null)
            throw new UserNotFoundException("No existe usuario con id " + userId);
        //Chequear que usuario siga a algun vendedor
        if (user.getFollowed().isEmpty()) {
            throw new UserGenericException(String.format("El usuario %s no sigue vendedeores"
                    , user.getUserName()));
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
            if (!userVendedor.getPosts().isEmpty()) {
                for (Map.Entry<Integer, Post> posts : userVendedor.getPosts().entrySet()) {
                    //Controlo que la fecha de publicacion no se mayor a 2 semanas
                    if (DateHandler.showPostRecently(posts.getValue().getDate()))
                        postListRes.add(DTOMapper.mapTo(posts.getValue()));
                }
            }
        }
        //Chequeo que tengamos algun Post para mostrar
        if (postListRes.isEmpty()) {
            throw new UserGenericException(String.format("Los vendedores que sigue el usuario %s , no tienen publicaciones en las ultimas 2 semanas"
                    , user.getUserName()));
        }

        //descendente  ******** ME QUEDARIA MNAS COMODO QUE EL DATE DE POSTDTO SEA UN LOCALDATE NO UN STRING
        postListRes = postListRes.stream().sorted(Comparator.comparing(PostDTOres::getDate)).collect(Collectors.toList());
        //ascendente
        if (order == null || order.equals(TypeOrderHelper.DATE_DESC))
            postListRes = postListRes.stream().sorted(Comparator.comparing(PostDTOres::getDate).reversed()).collect(Collectors.toList());

        userPostsDTOres.setUser_id(userId);
        userPostsDTOres.setPosts(postListRes);
        return userPostsDTOres;
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        if (userRepository.getUser(userId) == null) {
            throw new UserGenericException("El usuario con el id: " + userId + " no fue encontrado!");
        }
        if (userRepository.getUser(userId).getFollowed().containsKey(userIdToUnfollow)) {
            userRepository.getUser(userId).getFollowed().remove(userIdToUnfollow);
        } else
            throw new UserGenericException("El usuario con el id: " + userId + " no sigue al usuario " + userIdToUnfollow);
    }

    @Override
    public UserFollowersListDTOres getUserFollowerList(int userId, String order) {
        UserFollowersListDTOres res = getUserFollowerList(userId);
        if (order.equals(TypeOrderHelper.NAME_ASC)) {
            res.getFollowers()
                    .sort(Comparator.comparing(UserDTOres::getUser_name));
            return res;
        } else if (order.equals(TypeOrderHelper.NAME_DESC)) {
            res.getFollowers()
                    .sort(Comparator.comparing(UserDTOres::getUser_name).reversed());
            return res;
        } else
            throw new UserGenericException("Parametro no aceptado");
    }

    @Override
    public UserFollowedListDTOres getUserFollowed(int userId, String order) {
        UserFollowedListDTOres res = getUserFollowed(userId);
        if (order.equals(TypeOrderHelper.NAME_ASC)) {
            res.getFollowed()
                    .sort(Comparator.comparing(UserDTOres::getUser_name));
            return res;
        } else if (order.equals(TypeOrderHelper.NAME_DESC)) {
            res.getFollowed()
                    .sort(Comparator.comparing(UserDTOres::getUser_name).reversed());
            return res;
        } else
            throw new UserGenericException("Parametro no aceptado");
    }

    //----------------------------AGREGADO INDIVIDUAL------------------------------
    @Override
    public void createPromoPost(PostPromoDTOreq postPromoDTOreq) {
        int userId = postPromoDTOreq.getUser_id();

        if (userRepository.getUser(userId) == null)
            throw new UserGenericException("Usuario no encontrado!"); //funciona

        Post post = DTOMapper.mapToPostPromo(postPromoDTOreq);

        Integer postId = postRepository.addPost(post);
        post.setPost_id(postId);

        userRepository.getUser(userId).getPosts().put(postId, post);
    }

    @Override
    public PostPromoCountDTOres getPostPromoCount(int userId) {
        User user = userRepository.getUser(userId);

        if (user == null) throw new UserGenericException("Usuario no encontrado!");

        int promo_post = 0;
        for (Post postNew : user.getPosts().values()) {
            if (postNew.getHas_promo() == true) {
                promo_post += 1;
            }
        }
        PostPromoCountDTOres postPromoCountDTOres = new PostPromoCountDTOres(user.getUserId(), user.getUserName(), promo_post);
        return postPromoCountDTOres;
    }

    @Override
    public List<UserDTOres> getAllUsers() {
        List<User> listUser = userRepository.getAllUsers();

        List<UserDTOres> userDTOresList = DTOMapper.mapToLListUser(listUser);

        return userDTOresList;
    }
}
