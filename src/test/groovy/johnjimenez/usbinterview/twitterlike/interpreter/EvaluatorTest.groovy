package johnjimenez.usbinterview.twitterlike.interpreter

import org.junit.*

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
        assert result == evaluator.interpret('something')
    }
    
    @Test
    void wall() {
        def result = new StringBuilder('wall')
        evaluator.wallExpression = [interpret: { user -> result }] as WallExpression
        assert result == evaluator.interpret('something something')
    }
    
    @Test
    void post() {
        evaluator.postExpression = [interpret: { message, poster -> }] as PostExpression
        evaluator.interpret 'something -> something'
    }
    
    @Test
    void follow() {
        evaluator.followExpression = [interpret: { follower, followee -> }] as FollowExpression
        evaluator.interpret 'something something something'
    }    
}
