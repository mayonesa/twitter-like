package johnjimenez.usbinterview.twitterlike.messageconsumer

import javax.inject.*

@Named
class ReadListener {
    @Inject
    def service
    
    def getTimeline(userName) {
        service.getTimeline userName
    }
}
