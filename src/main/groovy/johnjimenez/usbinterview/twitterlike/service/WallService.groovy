package johnjimenez.usbinterview.twitterlike.service

import javax.inject.Inject
import org.springframework.stereotype.Service

import johnjimenez.usbinterview.twitterlike.repository.*

@Service
class WallService {
    @Inject
    private PostRepository postRepository
    
    @Inject
    private UserRepository userRepository
    
    def getWall(userName) {
        def user = userRepository.loadUserByName(userName)
        def users = new HashSet(user.followees)
        users.add user
        postRepository.getPostsFor users
    }
}
