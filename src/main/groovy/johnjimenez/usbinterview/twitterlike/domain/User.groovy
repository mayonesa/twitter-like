package johnjimenez.usbinterview.twitterlike.domain

class User {
    String name
    final Set<User> followees = new HashSet<User>()
    
    void follow(User followee) {
        followees.add followee
    }
    
    String toString() {
        name
    }
}
