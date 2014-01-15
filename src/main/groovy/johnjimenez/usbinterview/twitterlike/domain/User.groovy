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

    boolean equals(Object o) {
        if (o instanceof User) {
            return ((User) o).name == name
        }
        false
    }
    
    int hashCode() {
        name.hashCode()
    }
}
