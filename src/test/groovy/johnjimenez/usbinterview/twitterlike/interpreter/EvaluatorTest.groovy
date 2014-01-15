package johnjimenez.usbinterview.twitterlike.interpreter

import org.junit.Test
import groovy.mock.interceptor.MockFor

class EvaluatorTest {
        
    @Test
    void read() {
        evaluate ReadExpression.class, 'something'
    }
    
    @Test
    void wall() {
        evaluate WallExpression.class, 'something something'
    }
    
    @Test
    void post() {
        evaluate PostExpression.class, 'something -> something'
    }
    
    @Test
    void follow() {
        evaluate FollowExpression.class, 'something something something'
    }
    
    private void evaluate(expressionClass, command) {
        def expressionMock = new MockFor(expressionClass)
        def interpretationReturn = 'return'
        expressionMock.demand.interpret() { interpretationReturn }
        expressionMock.use {
            assert interpretationReturn == new Evaluator(command).interpret()
        }
    }    
}
