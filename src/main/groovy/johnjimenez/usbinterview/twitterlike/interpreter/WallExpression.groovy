package johnjimenez.usbinterview.twitterlike.interpreter

import groovy.transform.PackageScope

import static johnjimenez.usbinterview.twitterlike.service.ServiceFacade.service
import static johnjimenez.usbinterview.twitterlike.util.PostPrintHelper.getStringBuilder

@PackageScope class WallExpression {
    String userName
    
    @PackageScope StringBuilder interpret() {
        getStringBuilder service.getWall(userName), { post ->
            "${post.poster} - $post"
        }
    }
}
