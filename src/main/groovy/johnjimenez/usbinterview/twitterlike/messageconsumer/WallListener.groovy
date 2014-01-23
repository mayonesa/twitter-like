package johnjimenez.usbinterview.twitterlike.messageconsumer

import javax.inject.*

@Named
class WallListener {
    @Inject
    def service
    
    def getWall(userName) {
        service.getWall userName
    }
}
