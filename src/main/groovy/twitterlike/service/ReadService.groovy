package twitterlike.service

import javax.inject.Inject
import org.springframework.stereotype.Service

import twitterlike.repository.*
import twitterlike.exception.UserNotFoundException

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
