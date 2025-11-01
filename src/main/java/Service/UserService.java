package Service;

import Repository.UserRepository;
import User.User;
import dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    // check exist user
    public User registerUser(UserRegistrationDTO userRegistrationDTO){
        if(userRepository.findByEmail(userRegistrationDTO.getEmail()).isPresent()){
            throw new IllegalStateException("Email already existed");
        }
        User newUser = new User();
        newUser.setEmail(userRegistrationDTO.getEmail());
        //has the password
        newUser.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        return userRepository.save(newUser);
    }
}
