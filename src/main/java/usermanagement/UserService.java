package usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> loginUser(String email, String password) {
        // Call the repository method to find the user
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public void resetPassword(String email) {
        //logic of this
    }



    public User getUserProfile(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUserProfile(User user) {
        return userRepository.save(user);
    }
}
