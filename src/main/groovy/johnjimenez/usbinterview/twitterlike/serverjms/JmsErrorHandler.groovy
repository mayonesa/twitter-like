package johnjimenez.usbinterview.twitterlike.serverjms

import groovy.util.logging.Log4j
import org.springframework.util.ErrorHandler
import javax.inject.*

@Named
@Log4j
class JmsErrorHandler implements ErrorHandler {
    @Inject
    def errorJmsTemplate
    
    @Override
    void handleError(Throwable t) {
        if (t instanceof Exception) {
            def originalException = t.cause ?: t
            def message = originalException.message
            log.info message
            errorJmsTemplate.convertAndSend message
        } else {
            throw t
        }
    }
}
