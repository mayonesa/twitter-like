package twitterlike.service

import javax.inject.Inject
import org.springframework.stereotype.Service

import twitterlike.repository.UserRepository
import twitterlike.exception.UserNotFoundException

@Service
class FollowService {
    @Inject
    private UserRepository userRepository
    
    void execute(followerName, followeeName) throws UserNotFoundException {
        userRepository.makeFollow followerName, followeeName
    }
}
