package johnjimenez.usbinterview.twitterlike.messageconsumer

import javax.inject.*
import javax.jms.*

@Named
class PostListener implements MessageListener {
    @Inject
    def service
    
    void onMessage(final Message message) {
        service.post message.getString('post'), message.getString('poster')
    }
}