package johnjimenez.usbinterview.twitterlike.messageproducer

import javax.inject.*

@Named
class FollowProducer {
    @Inject
    def jmsTemplate
    
    @Inject
    def followDestination
    
    def follow(followerName, followeeName) {
        jmsTemplate.convertAndSend readDestination, 
            ['followerName': followerName, 'followeeName': followeeName]
    }
}