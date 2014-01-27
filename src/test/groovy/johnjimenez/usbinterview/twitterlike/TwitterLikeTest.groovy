package johnjimenez.usbinterview.twitterlike

import org.junit.Test
import org.junit.runner.RunWith
import groovy.util.logging.Log4j
import org.springframework.transaction.annotation.Transactional
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import javax.inject.Inject

import johnjimenez.usbinterview.twitterlike.interpreter.Evaluator

import static johnjimenez.usbinterview.twitterlike.interpreter.Evaluator.*

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration('classpath:applicationContext-test.xml')
@Transactional
class TwitterLikeTest {
    @Inject
    private Evaluator evaluator
        
    @Test
    void goodCommandEvaluate() {
        String john = 'john'
        String johnPost1 = 'this is an integration test'
        evaluate "$john $POST $johnPost1"
        
        // give activeMQ a chance to get setup
        Thread.sleep 2000
        
        assertEvaluation john, johnPost1
        String johnWall = "$john - $johnPost1"
        assertEvaluation "$john $WALL", johnWall
        String bruna = 'bruna'
        String brunaPost1 = 'hello TwitterLikeSphere!'
        evaluate "$bruna $POST $brunaPost1"
        assertEvaluation bruna, brunaPost1
        String brunaWall = "$bruna - $brunaPost1"
        assertEvaluation "$bruna $WALL", brunaWall
        evaluate "$bruna $FOLLOWS $john"
        assertEvaluation bruna, brunaPost1
        assertEvaluation "$bruna $WALL", [brunaWall, johnWall] as String[]
        String brunaPost2 = 'John would really like to interview w/ USB'
        evaluate "$bruna $POST $brunaPost2"
        assertEvaluation "$bruna $WALL", ["$bruna - $brunaPost2", brunaWall, johnWall] as String[]
    }
      
    void readerNotFound() {
        def reader = 'reader'
        assertUserNotFound reader, "$reader"
    }
    
    void wallerNotFound() {
        def waller = 'waller'
        assertUserNotFound waller, "$waller $WALL"
    }
    
    void followerNotFound() {
        def follower = 'follower'
        assertUserNotFound follower, "$follower $FOLLOWS tito"
    }
    
    void followeeNotFound() {
        def followee = 'followee'
        def follower = 'follower'
        evaluate "$follower $POST something interesting"
        assertUserNotFound followee, "$follower $FOLLOWS $followee"
    }
    
    private def evaluate(command) {
        evaluator.interpret command
    }
    
    private def asserUserNotFound(missingUser, command) {
        throw new UnsupportedOperationException()
    }
    
    private def assertEvaluation(command, String... expectationFragments) {
        new AssertEvaluationHelper(command).execute(expectationFragments)
    }
    
    // inner class becuase state (actualResult) needed for cleaner processing
    private class AssertEvaluationHelper {
        private final static String POST_APPEND = ' ago)'
        private String actualResult
        
        private AssertEvaluationHelper(command) {
            actualResult = evaluate(command).toString()
            log.info "result from $command: $actualResult"
        }
        
        private def execute(String... expectationFragments) {
            int startIndex = 0
            for (expectationFragment in expectationFragments) {
                startIndex = assertAndGetStartIndex expectationFragment, startIndex
                startIndex = assertAndGetStartIndex POST_APPEND, startIndex
            }
        }
        
        private def assertAndGetStartIndex(expectationFragment, startIndex) {
            startIndex = actualResult.indexOf expectationFragment, startIndex
            assert startIndex != -1
            startIndex =+ expectationFragment.size()
            startIndex
        }
    }
}
