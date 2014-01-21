package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*
import org.springframework.scheduling.annotation.Async

@Named
class PostExpression {
    @Inject
    def service
    
    @Async
    void interpret(message, posterName) {
        service.post message, posterName
    }
}
