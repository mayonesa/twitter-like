package twitterlike.clientjms

import javax.inject.*

@Named
class FollowProducer {
    @Inject
    def jmsTemplate
    
    @Inject
    def followDestination
    
    def follow(followerName, followeeName) {
        jmsTemplate.convertAndSend followDestination, 
            ['followerName': followerName, 'followeeName': followeeName]
            
        // give a chance to receive error
        Thread.sleep 2000
    }
}
