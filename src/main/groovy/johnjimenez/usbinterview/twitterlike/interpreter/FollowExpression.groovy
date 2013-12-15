package johnjimenez.usbinterview.twitterlike.interpreter

import groovy.transform.PackageScope

import static johnjimenez.usbinterview.twitterlike.service.ServiceFacade.service

@PackageScope class FollowExpression {
    String followerName, followeeName
    
    @PackageScope void interpret() {
        service.follow followerName, followeeName
    }
}
