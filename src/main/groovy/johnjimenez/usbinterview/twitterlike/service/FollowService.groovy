package johnjimenez.usbinterview.twitterlike.service

import static johnjimenez.usbinterview.twitterlike.repository.UserRepository.userRepository

class FollowService {
    private static FollowService instance = new FollowService()
    
    private FollowService() { }
    
    static getInstance() {
        instance
    }
    
    void execute(String followerName, String followeeName) {
        userRepository.getUserByName(followerName).follow \
          userRepository.getUserByName(followeeName)
    }
}
