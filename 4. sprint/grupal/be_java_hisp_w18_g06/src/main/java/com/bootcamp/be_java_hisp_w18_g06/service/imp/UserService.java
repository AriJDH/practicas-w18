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
import com.fasterxml.jackson.databind.ObjectMapper;
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

    //US-001
    //userId != userIdToFollow --> Boolean
    private boolean userIdDiffUserIdToFollow(int userId, int userIdToFollow) {
        return userId != userIdToFollow;
    }

    //usFollowed.isPresent()--> Boolean
    private boolean userIsPresent(int id) {
        return userRepository.findUserById(id).isPresent();
    }

    //usFollowed.get().getPosts() != null -->Boolean
    private boolean userFollowedHasPosts(User user) {
        return user.getPosts() != null;
    }

    @Override
    public void followUser(int userId, int userIdToFollow) {

        if (userIdDiffUserIdToFollow(userId, userIdToFollow)) {

            //Traer la lista de usuarios
            //Verificar existencia userId y userIdToFollow
            Optional<User> usFollower = userRepository.findUserById(userId);
            Optional<User> usFollowed = userRepository.findUserById(userIdToFollow);

            List<User> userAddedFollower = new ArrayList<>();
            List<User> userAddedFollowed = new ArrayList<>();

            if (userIsPresent(usFollowed.get().getUser_id())) {
                if (userFollowedHasPosts(usFollowed.get())) {
                    //Agregar a la lista de Followed de userId
                    userAddedFollower.add(usFollowed.get());
                    usFollower.get().setFollowed(userAddedFollower);  //comprador -> vendedor

                    //Agregar a la lista de Followers de userIdToFollow
                    userAddedFollowed.add(usFollower.get());
                    usFollowed.get().setFollowers(userAddedFollowed);  //vendedor <- comprador

                    userRepository.updateUsers(usFollower.get());
                    userRepository.updateUsers(usFollowed.get());

                } else {
                    throw new BadRequestException("You can't follow this user because he doesn't have any posts");
                }
            } else {
                throw new BadRequestException("This user don't exit");
            }
        } else {
            throw new BadRequestException("You can't follow yourself");
        }
    }

    //US-007
    private void removeFromFollow(User user) {
        user.getFollowed().remove(user.getUser_id());
    }


    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
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
        User user = userRepository.getUser(userId);

        if (user.getFollowers() == null) {
            throw new EmptyException("No es comprador aaaaaaaaaaa");
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
    public UserFollowedListDTO getFollowedList(int userId) {
        User user = userRepository.getUser(userId);

        if (user.getFollowed() == null) {
            throw new EmptyException("aaaaaaaa");
        }

        // Temporal
        ObjectMapper om = new ObjectMapper();  // !!!
        UserFollowedListDTO userFollowedListDTO = new UserFollowedListDTO();
        userFollowedListDTO.setUser_id(user.getUser_id());
        userFollowedListDTO.setUser_name(user.getUser_name());
        userFollowedListDTO.setFollowed(user.getFollowed().stream()
                .map( x -> om.convertValue(x, UserFollowDTO.class))
                .collect(Collectors.toList()));
        //

        return userFollowedListDTO;
    }

    @Override
    public UserFollowersListDTO getFollowersList(int userId) {
        User user = userRepository.getUser(userId);

        if (user.getFollowers() == null) {
            throw new EmptyException("No es comprador aaaaaaaaaaa");
        }

        // Temporal
        ObjectMapper om = new ObjectMapper(); // !!!
        UserFollowersListDTO userFollowersListDTO = new UserFollowersListDTO();
        userFollowersListDTO.setUser_id(user.getUser_id());
        userFollowersListDTO.setUser_name(user.getUser_name());
        userFollowersListDTO.setFollowers(user.getFollowers().stream()
                .map( x -> om.convertValue(x, UserFollowDTO.class))
                .collect(Collectors.toList()));
        //

        return userFollowersListDTO;
    }

    // Falta 008

        @Override
        public void userSortList(String order, int userId) {
            User user = userRepository.getUser(userId);

            if (user.getFollowers() == null) {
                throw new EmptyException("No es comprador");
            }
            user.setFollowers(sortLIst(order, user.getFollowers()));

        }

        private List<User> sortLIst(String order, List<User> users) {
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
