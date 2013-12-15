package johnjimenez.usbinterview.twitterlike.interpreter

import groovy.transform.PackageScope

import static johnjimenez.usbinterview.twitterlike.service.ServiceFacade.service
import static johnjimenez.usbinterview.twitterlike.util.PostPrintHelper.getStringBuilder

@PackageScope class ReadExpression {
    String userName
    
    @PackageScope StringBuilder interpret() {
        getStringBuilder service.getTimeline(userName), { post ->
            post
        }
    }
}
