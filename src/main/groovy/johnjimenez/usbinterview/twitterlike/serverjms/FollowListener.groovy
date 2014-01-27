package johnjimenez.usbinterview.twitterlike.serverjms

import javax.inject.*
import javax.jms.*

@Named
class FollowListener implements MessageListener {
    @Inject
    def service
    
    @Override
    void onMessage(final Message message) {
        service.follow message.getString('followerName'), 
            message.getString('followeeName')
    }
}
