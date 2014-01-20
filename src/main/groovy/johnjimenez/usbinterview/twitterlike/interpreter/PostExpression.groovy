package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

@Named
class PostExpression {
    @Inject
    def service
    
    def interpret(message, posterName) {
        service.post message, posterName
    }
}
