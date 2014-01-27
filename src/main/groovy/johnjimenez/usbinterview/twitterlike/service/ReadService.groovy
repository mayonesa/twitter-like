package johnjimenez.usbinterview.twitterlike.service

import javax.inject.Inject
import org.springframework.stereotype.Service

import johnjimenez.usbinterview.twitterlike.repository.*

@Service
class ReadService {
    @Inject
    private PostRepository postRepository
    
    @Inject
    private UserRepository userRepository
    
    List getTimeline(userName) {
        def poster = userRepository.loadUserByName(userName)
        postRepository.getPostsFor poster
    }
}
