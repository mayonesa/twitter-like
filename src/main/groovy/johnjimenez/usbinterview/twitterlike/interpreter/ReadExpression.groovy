package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

import static johnjimenez.usbinterview.twitterlike.util.PostPrintHelper.getStringBuilder

@Named
class ReadExpression {
    @Inject
    def readProducer
    
    def interpret(userName) {
        getStringBuilder readProducer.getTimeline(userName), { post ->
            post
        }
    }
}
