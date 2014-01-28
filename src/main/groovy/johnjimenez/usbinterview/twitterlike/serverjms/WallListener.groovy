package johnjimenez.usbinterview.twitterlike.serverjms

import javax.inject.*

import johnjimenez.usbinterview.twitterlike.exception.UserNotFoundException

@Named
class WallListener {
    @Inject
    def service
    
    def getWall(userName) throws UserNotFoundException {
        service.getWall userName
    }
}
