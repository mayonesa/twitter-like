package twitterlike.service

import javax.inject.Inject
import org.springframework.stereotype.Service

import twitterlike.repository.*

@Service
class PostService {
    @Inject
    private PostRepository postRepository
    
    @Inject
    private UserRepository userRepository
    
    def execute(message, posterName) {
        postRepository.addPost message, userRepository.getUserByName(posterName)
    }
}
