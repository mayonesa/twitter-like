package twitterlike.serverjms

import javax.inject.*

import twitterlike.exception.UserNotFoundException

@Named
class WallListener {
    @Inject
    def service
    
    def getWall(userName) throws UserNotFoundException {
        service.getWall userName
    }
}
