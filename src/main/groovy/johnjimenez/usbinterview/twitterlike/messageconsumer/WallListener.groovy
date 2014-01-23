package johnjimenez.usbinterview.twitterlike.messageconsumer

import javax.inject.*

@Named
class WallListener {
    @Inject
    def service
    
    def getWall(message) {
        service.getWall message.text
    }
}
