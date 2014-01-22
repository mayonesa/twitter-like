package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

import johnjimenez.usbinterview.twitterlike.messageproducer.PostProducer

@Named
class PostExpression {
    @Inject
    PostProducer postProducer
    
    void interpret(message, posterName) {
        postProducer.produceAndSend message, posterName
    }
}
