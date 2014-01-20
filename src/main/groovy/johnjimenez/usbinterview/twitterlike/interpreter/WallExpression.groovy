package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

import static johnjimenez.usbinterview.twitterlike.util.PostPrintHelper.getStringBuilder

@Named
class WallExpression {
    @Inject
    def service
    
    StringBuilder interpret(userName) {
        getStringBuilder service.getWall(userName), { post ->
            "${post.poster} - $post"
        }
    }
}
