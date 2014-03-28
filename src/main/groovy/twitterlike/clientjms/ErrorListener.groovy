package twitterlike.clientjms

import groovy.util.logging.Log4j
import javax.inject.Named
import javax.jms.*

@Named
@Log4j
class ErrorListener implements MessageListener {
    
    @Override
    void onMessage(final Message message) {
        def msgStr = message.text
        log.debug msgStr
        println "ERROR: $msgStr"
    }
}
