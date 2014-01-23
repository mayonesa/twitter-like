package johnjimenez.usbinterview.twitterlike

import org.junit.Test
import  org.junit.runner.RunWith
import groovy.util.logging.Log4j
import org.springframework.transaction.annotation.Transactional
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import javax.inject.Inject

import johnjimenez.usbinterview.twitterlike.interpreter.Evaluator

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration('classpath:applicationContext-test.xml')
@Transactional
class TwitterLikeTest {
    @Inject
    private Evaluator evaluator
        
    @Test
    void evaluate() {
        String john = 'john'
        String johnPost1 = 'this is an integration test'
        _evaluate "$john -> $johnPost1"
        assertEvaluation john, johnPost1
        String johnWall = "$john - $johnPost1"
        assertEvaluation "$john wall", johnWall
        String bruna = 'bruna'
        String brunaPost1 = 'hello TwitterLikeSphere!'
        _evaluate "$bruna -> $brunaPost1"
        assertEvaluation bruna, brunaPost1
        String brunaWall = "$bruna - $brunaPost1"
        assertEvaluation "$bruna wall", brunaWall
        _evaluate "$bruna follows $john"
        assertEvaluation bruna, brunaPost1
        assertEvaluation "$bruna wall", [brunaWall, johnWall] as String[]
        String brunaPost2 = 'John would really like to interview w/ USB'
        _evaluate "$bruna -> $brunaPost2"
        assertEvaluation "$bruna wall", ["$bruna - $brunaPost2", brunaWall, johnWall] as String[]
    }
    
    private def _evaluate(command) {
        evaluator.interpret command
    }
    
    private void assertEvaluation(command, String... expectationFragments) {
        new AssertEvaluationHelper(command).execute(expectationFragments)
    }
    
    private class AssertEvaluationHelper {
        private String actualResult
        
        private AssertEvaluationHelper(command) {
            actualResult = _evaluate(command).toString()
            log.info "result from $command: $actualResult"
        }
        
        private void execute(String... expectationFragments) {
            int startIndex = 0
            final String postAppend = ' ago)'
            for (expectationFragment in expectationFragments) {
                startIndex = assertAndGetStartIndex expectationFragment, startIndex
                startIndex = assertAndGetStartIndex postAppend, startIndex
            }
        }
        
        private int assertAndGetStartIndex(expectationFragment, startIndex) {
            startIndex = actualResult.indexOf expectationFragment, startIndex
            assert startIndex != -1
            startIndex =+ expectationFragment.size()
            startIndex
        }
    }
}
