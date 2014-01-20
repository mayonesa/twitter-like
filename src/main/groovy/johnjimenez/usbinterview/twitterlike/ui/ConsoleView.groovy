package johnjimenez.usbinterview.twitterlike.ui

import org.springframework.context.support.ClassPathXmlApplicationContext

class ConsoleView {
    static void main(String[] args) {
        print 'Welcome to TwitterLike.\n> '
        def output
        def evaluator = new ClassPathXmlApplicationContext("applicationContext.xml")
            .getBean('evaluator')
        System.in.eachLine { command ->
            output = evaluator.interpret(command)
            if (output != null) {
                println output
            }
            print '> '
        }
    }
}
