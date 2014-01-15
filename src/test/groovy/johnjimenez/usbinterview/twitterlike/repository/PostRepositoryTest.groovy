package johnjimenez.usbinterview.twitterlike.repository

import org.junit.*
import groovy.util.logging.Slf4j

import johnjimenez.usbinterview.twitterlike.domain.*

import static PostRepository.postRepository

@Slf4j
class PostRepositoryTest {

    private static User john = new User(name: 'john')
    private static User bruna =  new User(name: 'bruna')
    private static User era = new User(name: 'era')
    private static User tito = new User(name: 'tito')
    private static User plancha = new User(name: 'plancha')
    
    private static String johnMessage1 = 'john post1'
    private static String johnMessage2 = 'john post2'
    private static String johnMessage3 = 'john post3'
    private static String brunaMessage1 = 'bruna post1'        
    private static String brunaMessage2 = 'bruna post2'
    private static String eraMessage1 = 'era post1'
    
    private static Post johnPost1 = new Post(johnMessage1, john)
    private static Post johnPost2 = new Post(johnMessage2, john)
    private static Post johnPost3 = new Post(johnMessage3, john)
    private static Post brunaPost1 = new Post(brunaMessage1, bruna)
    private static Post brunaPost2 = new Post(brunaMessage2, bruna)
    private static Post eraPost1 = new Post(eraMessage1, era)
    
    @BeforeClass
    static void prep() {
        cleanUp()
        postRepository.addPost johnMessage1, john
        postRepository.addPost brunaMessage1, bruna
        postRepository.addPost johnMessage2, john
        postRepository.addPost eraMessage1, era
        postRepository.addPost brunaMessage2, bruna
        postRepository.addPost johnMessage3, john
    }
    
    @AfterClass
    static void cleanUp() {
        postRepository.clear()
    }
    
    @Test
    void singlePoster() {
        assert [johnPost3, johnPost2, johnPost1] == postRepository.getPostsFor(john)
        assert [brunaPost2, brunaPost1] == postRepository.getPostsFor(bruna)
        assert [eraPost1] == postRepository.getPostsFor(era)
    }
    
    @Test 
    void multiplePosters() {
        assert [johnPost3, eraPost1, johnPost2, johnPost1] == 
            postRepository.getPostsFor([era, john] as Set)
        assert [johnPost3, brunaPost2, eraPost1, johnPost2, brunaPost1, johnPost1] == 
            postRepository.getPostsFor([era, bruna, john] as Set)
        assert [johnPost3, brunaPost2, johnPost2, brunaPost1, johnPost1] == 
            postRepository.getPostsFor([bruna, john] as Set)
        assert [brunaPost2, eraPost1, brunaPost1] == 
            postRepository.getPostsFor([era, bruna] as Set)
    }
    
    @Test
    void nonPostingSingleUser() {
        assert [] == postRepository.getPostsFor(tito)
    }
    
    @Test
    void nonPostingMultipleUsers() {
        assert [] == postRepository.getPostsFor([tito, plancha] as Set)
        assert [johnPost3, johnPost2, johnPost1] == 
            postRepository.getPostsFor([tito, john, plancha] as Set)
    }
}
