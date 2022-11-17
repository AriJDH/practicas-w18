package com.mercadolibre.socialmeli.repository;

import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.Product;
import com.mercadolibre.socialmeli.entity.User;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{
    private Map<Integer, User> users;
    private static int nextPostId= 1;

    public UserRepository() {
        this.users = new HashMap<Integer, User>();
        loadUsers();
    }

    public void loadUsers(){
        User u1 = new User(1, "Juan Perez");
        User u2 = new User(2, "Maria Rodriguez");

        Product pr1 = new Product(1, "Mouse inalámbrico", "Acessorio",
                                "Logitech", "Negro", "Usa pila AA.");

        Product pr2 = new Product(2, "Bicicleta de montaña R26", "Rodado",
                "Winner", "Roja", "18 velocidades.");

        Post post1 = new Post(nextPostId++, LocalDate.now(),  1, 15.5, pr1, false, Double.valueOf(0));
        Post post2 = new Post(nextPostId++, LocalDate.now(),  2, 15999.99, pr2, false, Double.valueOf(0));

        User u3 = new User(3, "LaOfertaPerfecta");
        User u4 = new User(4, "MotociclosSA");

        u3.addPost(post1);
        u4.addPost(post2);

        this.users.put(1, u1);
        this.users.put(2, u2);
        this.users.put(3, u3);
        this.users.put(4, u4);

        this.follow(u1.getId(), u3.getId());
        this.follow(u1.getId(), u4.getId());
    }

    @Override
    public User findById(Integer id) {
        return this.users.get(id);
    }

    @Override
    public List<User> getFollowers(Integer id) {
        if(findById(id) == null) throw new NotFoundException("No se pudo encontrar al vendedor " + id);
        List<User> res = new ArrayList<>();

        for(Map.Entry<Integer, User> entry : users.entrySet()) {
            Set<User> followed = entry.getValue().getFollowed();

            for(User u : followed ) {
                if(u.getId() == id) {
                    res.add(entry.getValue());
                }
            }
        }
        return res;
    }

    @Override
    public List<User> getFollowed(Integer id) {
        if(findById(id) == null) throw new NotFoundException("No se pudo encontrar al usuario " + id);
        User user = users.get(id);
        Set<User> users = user.getFollowed();

        List<User> res = new ArrayList<>(users);
        return res;
    }

    @Override
    public void follow(Integer idFollower, Integer idFollow) {
        if(idFollower == idFollow)
            throw new IllegalArgumentException("No es posible seguirse a si mismo.");

        User userFollower = findById(idFollower);
        if(userFollower == null)
            throw new NotFoundException("No se pudo encontrar el usuario seguidor con id "+idFollower);

        User userToBeFollowed = findById(idFollow);
        if(userToBeFollowed == null)
            throw new NotFoundException("No se pudo encontrar el usuario a seguir con id "+idFollow);
        if(!userToBeFollowed.isSeller())
            throw new IllegalArgumentException("No es posible seguir al usuario id "+idFollow+" ya que no es vendedor");

        if(!userFollower.addFollowed(userToBeFollowed))
            throw new IllegalArgumentException("El usuario id "+idFollower+" ya sigue al usuario id "+idFollow);
    }

    @Override
    public void unfollow(Integer idFollower, Integer idUnfollow) {
        User userFollower = findById(idFollower);
        if(userFollower == null)
            throw new NotFoundException("No se pudo encontrar el usuario seguidor con id "+idFollower);

        if(!userFollower.getFollowed().removeIf(f -> f.getId()==idUnfollow))
            throw new NotFoundException("El usuario seguidor con id "+idFollower+ " no sigue al usuario id "+idUnfollow);
    }

    @Override
    public void createPost(Integer userId, Post newPost) {
        User user = findById(userId);
        if (user ==null) {
            throw new NotFoundException("El usuario "+userId+" no existe");
        }
        if (user.getPosts()==null){
            user.setPosts(new ArrayList<Post>());
        }
        user.getPosts().add(newPost);
    }

    @Override
    public List<Post> getPostsFromSeller(Integer id) {
        User user = findById(id);
        if(user == null) {
            throw new NotFoundException("El usuario " + id + " no existe");
        }

        return user.getPosts();
    }

    @Override
    public Integer getNextPostId() {
        return nextPostId++;
    }
}
