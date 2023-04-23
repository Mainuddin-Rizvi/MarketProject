package com.market.admin.user;

import com.market.common.entity.Role;
import com.market.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }
    public List<Role> listRoles(){
        return (List<Role>) roleRepository.findAll();
    }


    public User save(User user) {
        boolean isUpdatingUser = (user.getId() != null);
        if (isUpdatingUser){
            User existingUser = userRepository.findById(user.getId()).get();
            if (user.getPassword().isEmpty()){
                user.setPassword(existingUser.getPassword());
            }else{
                encodePassword(user);
            }
        }else{
            encodePassword(user);
        }
        userRepository.save(user);
        return user;
    }
//public void save(User user) {
//    boolean isUpdatingUser = (user.getId() != null);
//    if (isUpdatingUser) {
//        Optional<User> existingUserOpt = userRepository.findById(user.getId());
//        if (existingUserOpt.isPresent()) {
//            User existingUser = existingUserOpt.get();
//            if (user.getPassword().isEmpty()) {
//                user.setPassword(existingUser.getPassword());
//            } else {
//                encodePassword(user);
//            }
//        }
//    } else {
//        encodePassword(user);
//    }
//    userRepository.save(user);
//}


    private void encodePassword(User user){
        String encodedPassword =  passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
    public boolean isEmailUnique(Integer id,String email) {
        User userByEmail = userRepository.getUserByEmail(email);

        if(userByEmail == null){return true;}
        boolean isCreatingNew = (id==null);
        if (isCreatingNew){
            if (userByEmail != null) return false;
        }else{
            if (userByEmail.getId() != id){
                return false;
            }
        }
        return true;
    }

    public User get(Integer id) throws UserNotFoundException {
        try {
            return userRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new UserNotFoundException("Could Not find any user with Id");
        }
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long countById = userRepository.countById(id);
        if (countById == null || countById == 0){
            throw new UserNotFoundException("could not find any user with this Id "+id);
        }
        userRepository.deleteById(id);
    }

    public  void updateUserEnabledStatus(Integer id,boolean enabled){
        userRepository.updateEnabledStatus(id,enabled);
    }
}
