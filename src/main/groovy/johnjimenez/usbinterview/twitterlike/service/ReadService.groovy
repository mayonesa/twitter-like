package johnjimenez.usbinterview.twitterlike.service

import static johnjimenez.usbinterview.twitterlike.repository.PostRepository.postRepository
import static johnjimenez.usbinterview.twitterlike.repository.UserRepository.userRepository

class ReadService {
    private static ReadService instance = new ReadService()
    
    private ReadService() { }
    
    static getInstance() {
        instance
    }
    
    List getTimeline(String userName) {
        postRepository.getPostsFor userRepository.getUserByName(userName)
    }
}
