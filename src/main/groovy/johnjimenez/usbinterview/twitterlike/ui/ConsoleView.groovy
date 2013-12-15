package johnjimenez.usbinterview.twitterlike.ui

import johnjimenez.usbinterview.twitterlike.interpreter.Evaluator

class ConsoleView {
    static void main(String[] args) {
        print 'Welcome to TwitterLike.\n> '
        String output
        System.in.eachLine {
            output = new Evaluator(it).interpret()
            if (output != null) {
                println output
            }
            print '> '
        }
    }
}
