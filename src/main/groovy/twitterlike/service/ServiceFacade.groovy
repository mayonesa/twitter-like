package twitterlike.service

import javax.inject.Inject
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import twitterlike.exception.UserNotFoundException

@Service('service')
@Transactional(readOnly = true)
class ServiceFacade {
    @Inject
    private PostService postService
    
    @Inject
    private ReadService readService
    
    @Inject
    private FollowService followService
    
    @Inject
    private WallService wallService
    
    @Transactional(readOnly = false)
    def post(String message, String posterName) {
        postService.execute message, posterName
    }
    
    def getTimeline(String userName) throws UserNotFoundException {
        readService.getTimeline userName
    }
    
    @Transactional(readOnly = false)
    def follow(String followerName, String followeeName) throws UserNotFoundException {
        followService.execute followerName, followeeName
    }
    
    def getWall(String userName) throws UserNotFoundException {
        wallService.getWall userName
    }
}
