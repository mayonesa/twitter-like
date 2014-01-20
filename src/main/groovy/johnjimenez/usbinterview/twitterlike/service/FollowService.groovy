package johnjimenez.usbinterview.twitterlike.service

import javax.inject.Inject
import org.springframework.stereotype.Service

import johnjimenez.usbinterview.twitterlike.repository.UserRepository

@Service
class FollowService {
    @Inject
    private UserRepository userRepository
    
    void execute(followerName, followeeName) {
        userRepository.makeFollow followerName, followeeName
    }
}
