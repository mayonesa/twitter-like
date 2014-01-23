package johnjimenez.usbinterview.twitterlike.messageconsumer

import javax.inject.*
import javax.jms.*

@Named
class FollowListener implements MessageListener {
    @Inject
    def service
    
    void onMessage(final Message message) {
        service.follow message.getString('followerName'), 
            message.getString('followeeName')
    }
}
