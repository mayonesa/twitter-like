package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*
import org.springframework.scheduling.annotation.Async

@Named
class FollowExpression {
    @Inject
    def service
    
    @Async
    void interpret(followerName, followeeName) {
        service.follow followerName, followeeName
    }
}
