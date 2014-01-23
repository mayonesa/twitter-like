package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

@Named
class FollowExpression {
    @Inject
    def followProducer
    
    void interpret(followerName, followeeName) {
        followProducer.follow followerName, followeeName
    }
}
