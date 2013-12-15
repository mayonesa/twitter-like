package johnjimenez.usbinterview.twitterlike.service

class ServiceFacade {
    private static ServiceFacade instance = new ServiceFacade()
    
    private ServiceFacade() { }
    
    static ServiceFacade getService() {
        instance
    }
    
    void post(String message, String posterName) {
        PostService.instance.execute message, posterName
    }
    
    List getTimeline(String userName) {
        ReadService.instance.getTimeline userName
    }
    
    void follow(String followerName, String followeeName) {
        FollowService.instance.execute followerName, followeeName
    }
    
    List getWall(String userName) {
        WallService.instance.getWall userName
    }
}
