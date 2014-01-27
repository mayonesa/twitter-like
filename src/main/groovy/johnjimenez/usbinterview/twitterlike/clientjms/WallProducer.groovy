package johnjimenez.usbinterview.twitterlike.clientjms

import javax.inject.*

@Named
class WallProducer {
    @Inject
    def jmsTemplate
    
    @Inject
    def wallDestination
    
    @Inject
    def wallResponseDestination
    
    def getWall(userName) {
        jmsTemplate.convertAndSend wallDestination, userName
        jmsTemplate.receiveAndConvert wallResponseDestination
    }
}
