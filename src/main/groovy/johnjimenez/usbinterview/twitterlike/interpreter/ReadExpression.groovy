package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

import static johnjimenez.usbinterview.twitterlike.util.PostPrintHelper.getStringBuilder

@Named
class ReadExpression {
    @Inject
    def service
    
    StringBuilder interpret(userName) {
        getStringBuilder service.getTimeline(userName), { post ->
            post
        }
    }
}
