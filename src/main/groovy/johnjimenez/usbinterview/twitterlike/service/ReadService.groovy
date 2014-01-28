package johnjimenez.usbinterview.twitterlike.service

import javax.inject.Inject
import org.springframework.stereotype.Service

import johnjimenez.usbinterview.twitterlike.repository.*
import johnjimenez.usbinterview.twitterlike.exception.UserNotFoundException

@Service
class ReadService {
    @Inject
    private PostRepository postRepository
    
    @Inject
    private UserRepository userRepository
    
    List getTimeline(userName) throws UserNotFoundException {
        def poster = userRepository.loadUserByName(userName)
        postRepository.getPostsFor poster
    }
}
