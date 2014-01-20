package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

@Named
class FollowExpression {
    @Inject
    def service
    
    def interpret(followerName, followeeName) {
        service.follow followerName, followeeName
    }
}
