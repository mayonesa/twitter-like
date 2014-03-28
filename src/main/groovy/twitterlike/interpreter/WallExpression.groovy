package twitterlike.interpreter

import javax.inject.*

import static twitterlike.util.PostPrintHelper.getConsoleOutput

@Named
class WallExpression {
    @Inject
    def wallProducer
    
    def interpret(userName) {
        getConsoleOutput wallProducer.getWall(userName), { post ->
            "${post.poster} - $post"
        }
    }
}
