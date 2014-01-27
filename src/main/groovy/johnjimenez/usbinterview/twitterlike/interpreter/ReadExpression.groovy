package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

import static johnjimenez.usbinterview.twitterlike.util.PostPrintHelper.getConsoleOutput

@Named
class ReadExpression {
    @Inject
    def readProducer
    
    def interpret(userName) {
        getConsoleOutput readProducer.getTimeline(userName), { post ->
            post
        }
    }
}
