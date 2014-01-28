package johnjimenez.usbinterview.twitterlike.serverjms

import javax.inject.*
import javax.jms.*

import johnjimenez.usbinterview.twitterlike.exception.UserNotFoundException

@Named
class FollowListener implements MessageListener {
    @Inject
    def service
    
    @Override
    void onMessage(final Message message) throws UserNotFoundException {
        service.follow message.getString('followerName'), 
            message.getString('followeeName')
    }
}
