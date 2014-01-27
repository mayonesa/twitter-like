package johnjimenez.usbinterview.twitterlike.serverjms

import javax.inject.*
import javax.jms.*

@Named
class PostListener implements MessageListener {
    @Inject
    def service
    
    @Override
    void onMessage(final Message message) {
        service.post message.getString('post'), message.getString('poster')
    }
}
