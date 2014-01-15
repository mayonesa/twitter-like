package johnjimenez.usbinterview.twitterlike.repository

import groovy.transform.PackageScope

import johnjimenez.usbinterview.twitterlike.domain.User

class UserRepository {
    private final static UserRepository instance = new UserRepository()
    private final Map<String, User> users = [:]
    
    private UserRepository() { }
    
    static UserRepository getUserRepository() {
        instance
    }
    
    User getUserByName(String name) {
        if (users.containsKey(name)) {
            users.get name
        } else {
            User user = new User(name:name)
            users.put name, user
            user
        }
    }
    
    @PackageScope void clear() {
        users.clear()
    }
}
