package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

}
