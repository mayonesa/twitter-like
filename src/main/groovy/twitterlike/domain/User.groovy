package twitterlike.domain

import javax.persistence.*

@Entity
// serializable to allow for jms transport
class User implements Serializable {
    @Id
    @Column(unique = true, nullable = false)
    String name
    
    @ManyToMany
    Set<User> followees = new HashSet<User>()
    
    void follow(followee) {
        followees.add followee
    }
    
    @Override
    String toString() {
        name
    }

    @Override
    boolean equals(Object o) {
        if (o instanceof User) {
            return ((User) o).name == name
        }
        false
    }
    
    @Override
    int hashCode() {
        name.hashCode()
    }
}
