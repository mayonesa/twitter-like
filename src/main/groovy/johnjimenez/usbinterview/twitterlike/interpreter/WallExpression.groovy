package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

import static johnjimenez.usbinterview.twitterlike.util.PostPrintHelper.getStringBuilder

@Named
class WallExpression {
    @Inject
    def wallProducer
    
    def interpret(userName) {
        getStringBuilder wallProducer.getWall(userName), { post ->
            "${post.poster} - $post"
        }
    }
}
