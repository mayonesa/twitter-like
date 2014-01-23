package johnjimenez.usbinterview.twitterlike.messageproducer

import javax.inject.*

@Named
class PostProducer {
    @Inject
    def jmsTemplate
    
    @Inject
    def postDestination
    
    void post(post, poster) {
        jmsTemplate.convertAndSend postDestination, ['post': post, 'poster': poster]
        
        // to allow for slower computers
        jmsTemplate.receive postDestination
    }
}
