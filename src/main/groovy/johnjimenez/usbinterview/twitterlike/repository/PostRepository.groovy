package johnjimenez.usbinterview.twitterlike.repository

import groovy.transform.PackageScope

import johnjimenez.usbinterview.twitterlike.domain.*

class PostRepository {
    private final static PostRepository instance = new PostRepository()
    private final Deque<Post> allPosts = new ArrayDeque<Post>()
    
    private PostRepository() { }
    
    static PostRepository getPostRepository() {
        instance
    }
    
    void addPost(String message, User poster) {
        allPosts.addFirst(new Post(message, poster))
    }
    
    List<Post> getPostsFor(User poster) {
        getPostsFor([poster] as Set)
    }
    
    List<Post> getPostsFor(Set<User> posters) {
        List<Post> selectedPosts = []
        for (post in allPosts) {
            if (posters.contains(post.poster)) {
                selectedPosts.add post
            }
        }
        selectedPosts
    }
    
    @PackageScope void clear() {
        allPosts.clear()
    }
}
