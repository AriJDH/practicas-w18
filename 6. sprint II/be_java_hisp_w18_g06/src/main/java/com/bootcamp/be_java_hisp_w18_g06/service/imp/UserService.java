package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersListDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.EmptyException;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.IUserService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    // Mapeo -> No modificar por el momento!
    ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    //userAddedFollower
    List<User> userAddedFollower = new ArrayList<>();
    //
    List<User> userAddedFollowed = new ArrayList<>();


    //US-001
    //userId != userIdToFollow --> Boolean
    private boolean userIdDiffUserIdToFollow(int userId, int userIdToFollow) {
        return userId != userIdToFollow;
    }

    //usFollowed.isPresent()--> Boolean
    public boolean userIsPresent(int id) {
        return userRepository.findUserById(id).isPresent();
    }

    //usFollowed.get().getPosts() != null -->Boolean
    public boolean userFollowedHasPosts(User user) {
        return user.getPosts() != null;
    }
    //Metodo para seguir

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {

        /* Init variables */
        /* Traer la lista de usuarios
        Verificar existencia userId y userIdToFollow
        */
        Optional<User> usFollower = userRepository.findUserById(userId);
        User userFollower = usFollower.get();
        Optional<User> usFollowed = userRepository.findUserById(userIdToFollow);
        User userFollowed = usFollowed.get();
        Boolean usersAreDifferent = userIdDiffUserIdToFollow(userId, userIdToFollow);

        //verificación
        if (!usersAreDifferent) {
            throw new BadRequestException("You can't follow yourself");
        }

        //busca en el repo si están presentes los usuarios
        if (!userIsPresent(usFollowed.get().getUser_id())) {
            throw new BadRequestException("This user doesn't exit");
        }

        //verifica que el usuario tenga post para poder ser seguido
        if (!userFollowedHasPosts(usFollowed.get())) {
            throw new BadRequestException("You can't follow this user because he doesn't have any posts");
        }


        //Agregar a la lista de Followed de userId
         userAddedFollower.add(usFollowed.get());
         usFollower.get().setFollowed(userAddedFollower);  // comprador -> vendedor

        //Agregar a la lista de Followers de userIdToFollow
         userAddedFollowed.add(usFollower.get());
         usFollowed.get().setFollowers(userAddedFollowed);  // vendedor <- comprador

        userRepository.updateUsers(userFollower);
        userRepository.updateUsers(userFollowed);

    }


    //US-007
    private void removeFromFollow(User user) {
        user.getFollowed().remove(user.getUser_id());
    }


    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) {
        if (userIdDiffUserIdToFollow(userId, userIdToUnfollow)) {
            Optional<User> usFollower = userRepository.findUserById(userId);
            Optional<User> usUnfollowed = userRepository.findUserById(userIdToUnfollow);

            boolean isInListToUnfollowed = userRepository.findUserInList(usFollower.get().getFollowed(), userIdToUnfollow).isPresent();
            boolean userIdIsInListToFollowers = userRepository.findUserInList(usUnfollowed.get().getFollowers(), userId).isPresent();

            List<User> listFollowed = usFollower.get().getFollowed();
            List<User> listFollowers = usUnfollowed.get().getFollowers();

            //busca en el repo si estan presentes los usuarios
            if (userIsPresent(usUnfollowed.get().getUser_id()) && userIsPresent(usFollower.get().getUser_id())) {
                //booleans
                if (isInListToUnfollowed && userIdIsInListToFollowers) {
                    listFollowed.remove(usUnfollowed);
                    listFollowers.remove(usFollower);

                } else {
                    throw new BadRequestException("The users don't follow each other");
                }
            }
            else {
                throw new BadRequestException("User doesn't exist");
            }

        } else {
            throw new BadRequestException("You can't unfollow yourself");
        }
    }


    @Override
    public UserFollowersCountDTO getFollowersCount(int userId) {
        User user = userRepository
                .findUserById(userId)
                .orElseThrow(() -> new BadRequestException("The user id" + userId
                        + " does not exist"));

        if (user.getFollowers() == null) {
            throw new EmptyException("This user doesn't have followers");
        }

        // Temporal
        UserFollowersCountDTO userFollowersCountDTO = new UserFollowersCountDTO();
        userFollowersCountDTO.setUser_id(userId);
        userFollowersCountDTO.setUser_name(user.getUser_name());
        userFollowersCountDTO.setFollowers_count(user.getFollowers().size());
        //

        return userFollowersCountDTO;
    }

    @Override
    public UserFollowedListDTO getFollowedList(int userId, String order) {
        User user = userRepository
                .findUserById(userId)
                .orElseThrow(() -> new BadRequestException("The user id" + userId
                        + " does not exist"));

        if (user.getFollowed() == null) {
            throw new EmptyException("This user doesn't have followers");
        }

        if(order != null){
            user.setFollowed(sortList(order, user.getFollowed()));
        }

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UserFollowedListDTO userFollowedListDTO = new UserFollowedListDTO();
        userFollowedListDTO.setUser_id(user.getUser_id());
        userFollowedListDTO.setUser_name(user.getUser_name());
        userFollowedListDTO.setFollowed(user.getFollowed().stream()
                .map( x -> mapper.convertValue(x, UserFollowDTO.class))
                .collect(Collectors.toList()));
        //

        return userFollowedListDTO;
    }

    @Override
    public UserFollowersListDTO getFollowersList(int userId, String order) {
        User user = userRepository
                .findUserById(userId)
                .orElseThrow(() -> new BadRequestException("The user id" + userId
                        + " does not exist"));

        if (user.getFollowers() == null) {
            throw new EmptyException("This user doesn't have followers");
        }

        if(order != null){
            user.setFollowers(sortList(order, user.getFollowers()));
        }

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserFollowersListDTO userFollowersListDTO = new UserFollowersListDTO();
        userFollowersListDTO.setUser_id(user.getUser_id());
        userFollowersListDTO.setUser_name(user.getUser_name());
        userFollowersListDTO.setFollowers(user.getFollowers().stream()
                .map( x -> mapper.convertValue(x, UserFollowDTO.class))
                .collect(Collectors.toList()));

        return userFollowersListDTO;
    }



        //008
        private List<User> sortList(String order, List<User> users) {
            if (order.equals("name_asc")) {
                return users.stream().sorted(Comparator.comparing(User::getUser_name)).collect(Collectors.toList());
            }
            else if(order.equals("name_desc")){
                return users.stream().sorted(Comparator.comparing(User::getUser_name).reversed()).collect(Collectors.toList());
            }
            else {
                throw new EmptyException("Invalid param order");
            }
        }

}
