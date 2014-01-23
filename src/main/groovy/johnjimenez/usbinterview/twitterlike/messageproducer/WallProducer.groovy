package johnjimenez.usbinterview.twitterlike.messageproducer

import javax.inject.*

@Named
class WallProducer {
    @Inject
    def jmsTemplate
    
    @Inject
    def wallDestination
    
    def getWall(userName) {
        jmsTemplate.convertAndSend wallDestination, userName
        jmsTemplate.receiveAndConvert wallDestination
    }
}
