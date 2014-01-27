package johnjimenez.usbinterview.twitterlike.interpreter

import org.junit.*

import static Evaluator.*

class EvaluatorTest {
    private def evaluator
    
    @Before
    void setUp() {
        evaluator = new Evaluator()
    }
    
    @Test
    void read() {
        def result = new StringBuilder('read')
        evaluator.readExpression = [interpret: { user -> result }] as ReadExpression
        assert result == evaluator.interpret('someone')
    }
    
    @Test
    void wall() {
        def result = new StringBuilder('wall')
        evaluator.wallExpression = [interpret: { user -> result }] as WallExpression
        assert result == evaluator.interpret("someone $WALL")
    }
    
    @Test
    void twoTokensAndNotWall() {
        assertErrorMessage 'someone not_wall'
    }
    
    @Test
    void post() {
        evaluator.postExpression = [interpret: { message, poster -> }] as PostExpression
        evaluator.interpret "someone $POST some post. ;)"
    }
    
    @Test
    void goodFollow() {
        evaluator.followExpression = [interpret: { follower, followee -> }] as FollowExpression
        evaluator.interpret "someone $FOLLOWS somebody_else"
    }   
    
    @Test
    void compoundFollowee() {
        assertErrorMessage "someone $FOLLOWS pepin loco troco"
    } 
    
    @Test
    void moreThan2AndNotFollowsOrPost() {
        assertErrorMessage 'someone not_follows_or_post something something something'
    }
    
    private def assertErrorMessage(command) {
        assert ERROR_MESSAGE == evaluator.interpret(command)    
    }
}
