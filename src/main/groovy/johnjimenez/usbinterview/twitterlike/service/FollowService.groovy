package johnjimenez.usbinterview.twitterlike.service

import javax.inject.Inject
import org.springframework.stereotype.Service

import johnjimenez.usbinterview.twitterlike.repository.UserRepository
import johnjimenez.usbinterview.twitterlike.exception.UserNotFoundException

@Service
class FollowService {
    @Inject
    private UserRepository userRepository
    
    void execute(followerName, followeeName) throws UserNotFoundException {
        userRepository.makeFollow followerName, followeeName
    }
}
