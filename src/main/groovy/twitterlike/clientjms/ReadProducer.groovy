package twitterlike.clientjms

import groovy.util.logging.Log4j
import javax.inject.*

@Named
@Log4j
class ReadProducer {
    @Inject
    def jmsTemplate
    
    @Inject
    def readDestination
    
    @Inject
    def timelineDestination
    
    def getTimeline(userName) {
        jmsTemplate.convertAndSend readDestination, userName
        log.debug 'about to receive timeline'
        jmsTemplate.receiveAndConvert timelineDestination
    }
}
