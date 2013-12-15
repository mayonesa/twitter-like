package johnjimenez.usbinterview.twitterlike.interpreter

import groovy.transform.PackageScope

import static johnjimenez.usbinterview.twitterlike.service.ServiceFacade.service

@PackageScope class PostExpression {
    String message, posterName
    
    @PackageScope void interpret() {
        service.post message, posterName
    }
}
