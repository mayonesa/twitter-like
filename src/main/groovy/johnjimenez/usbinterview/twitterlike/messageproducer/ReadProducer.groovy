package johnjimenez.usbinterview.twitterlike.messageproducer

import javax.inject.*

@Named
class ReadProducer {
    @Inject
    def jmsTemplate
    
    @Inject
    def readDestination
    
    def getTimeline(userName) {
        jmsTemplate.convertAndSend readDestination, userName
        jmsTemplate.receiveAndConvert readDestination
    }
}
