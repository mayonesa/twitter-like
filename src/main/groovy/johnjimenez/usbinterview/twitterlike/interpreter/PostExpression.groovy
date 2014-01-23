package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

@Named
class PostExpression {
    @Inject
    def postProducer
    
    void interpret(message, posterName) {
        postProducer.post message, posterName
    }
}
