package johnjimenez.usbinterview.twitterlike.serverjms

import groovy.util.logging.Log4j
import javax.inject.*

@Named
@Log4j
class ReadListener {
    @Inject
    def service
    
    def getTimeline(userName) {
        service.getTimeline userName
    }
}
