package johnjimenez.usbinterview.twitterlike.messageconsumer

import javax.inject.*

@Named
class ReadListener {
    @Inject
    def service
    
    def get(message) {
        service.getTimeline message.text
    }
}
