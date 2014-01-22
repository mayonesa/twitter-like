package johnjimenez.usbinterview.twitterlike.messageproducer

import javax.inject.*
import javax.jms.Destination
import org.springframework.jms.core.JmsTemplate

@Named
class PostProducer {
    @Inject
    JmsTemplate jmsTemplate
    
    @Inject
    Destination postDestination
    
    def produceAndSend(post, poster) {
        jmsTemplate.send postDestination, ['post': post, 'poster': poster]
    }
}
