package pl.awieczarek.ozwebsocket.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class UserService {

    private final UserRepository userRepository;

    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    public void disconnectUser(User user) {
        var storedUser = userRepository.findById(user.getIndex()).orElse(null);

        if(storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        }
    }

    public List<User> getConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
