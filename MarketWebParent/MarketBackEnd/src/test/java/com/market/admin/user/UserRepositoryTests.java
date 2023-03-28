package com.market.admin.user;

import com.market.common.entity.Role;
import com.market.common.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("testUserWithOneRole")
    public void testCreateNewUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class,1);
        User userMainuddin = new User("mainu97rizvi@gmail.com","passwayne","Mainuddin","Rizvi");
        userMainuddin.addRole(roleAdmin);

        User savedUser = repo.save(userMainuddin);
        assertThat(savedUser.getId()).isGreaterThan(0);

    }
    @Test
    @DisplayName("testUserWithTwoRole")
    public void testCreateNewUserWithTwoRole(){
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);
        User userRavi = new User("ravi@gmail.com","ravi2020","Ravi","Kumar");

        userRavi.addRole(roleEditor);
        userRavi.addRole(roleAssistant);
        User savedUser = repo.save(userRavi);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    @DisplayName("testListAllUsers")
    public void testListAllUsers(){
        Iterable<User> listUsers = repo.findAll();
        listUsers.forEach((user)->System.out.println(user));
    }
    @Test
    public void testGetUserById(){
        User user = repo.findById(1).get();
        assertThat(user).isNotNull();
    }
    @Test
    public void testUpdateUserDetails(){
        User user = repo.findById(1).get();
        user.setEnabled(true);
        user.setEmail("rizvi97mainu@gmail.com");
        repo.save(user);
    }
    @Test
    public void testUpdateUserRoles(){
        User userRavi = repo.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);

        userRavi.getRoles().remove(roleEditor);
        userRavi.addRole(roleSalesperson);

        repo.save(userRavi);
    }
    @Test
    public void testDeleteUser(){
        Integer userId = 2;
        repo.deleteById(userId);
    }

    @Test
    public void testGetUserByEmail(){
        String email = "ravi@gmail.com";
        User user = repo.getUserByEmail(email);

        assertThat(user).isNotNull();
    }

}
