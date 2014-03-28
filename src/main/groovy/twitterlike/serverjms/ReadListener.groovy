package twitterlike.serverjms

import groovy.util.logging.Log4j
import javax.inject.*

import twitterlike.exception.UserNotFoundException

@Named
@Log4j
class ReadListener {
    @Inject
    def service
    
    def getTimeline(userName) throws UserNotFoundException {
        service.getTimeline userName
    }
}
