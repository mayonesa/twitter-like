package johnjimenez.usbinterview.twitterlike.service

import static johnjimenez.usbinterview.twitterlike.repository.PostRepository.postRepository
import static johnjimenez.usbinterview.twitterlike.repository.UserRepository.userRepository

class WallService {
    private static WallService instance = new WallService()
    
    private WallService() { }
    
    static getInstance() {
        instance
    }
    
    List getWall(String userName) {
        def user = userRepository.getUserByName(userName)
        Set users = new HashSet(user.followees)
        users.add user
        postRepository.getPostsFor users
    }
}
