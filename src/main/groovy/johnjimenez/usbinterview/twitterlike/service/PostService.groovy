package johnjimenez.usbinterview.twitterlike.service

import static johnjimenez.usbinterview.twitterlike.repository.PostRepository.postRepository
import static johnjimenez.usbinterview.twitterlike.repository.UserRepository.userRepository

class PostService {
    private static PostService instance = new PostService()
    
    private PostService() { }
    
    static getInstance() {
        instance
    }
    
    void execute(String message, String posterName) {
        postRepository.addPost message, userRepository.getUserByName(posterName)
    }
}
