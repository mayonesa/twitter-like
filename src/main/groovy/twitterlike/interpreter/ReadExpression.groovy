package twitterlike.interpreter

import javax.inject.*

import static twitterlike.util.PostPrintHelper.getConsoleOutput

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
