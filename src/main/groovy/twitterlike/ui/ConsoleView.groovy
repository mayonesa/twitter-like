package twitterlike.ui

import org.springframework.context.support.ClassPathXmlApplicationContext

class ConsoleView {
    public final static def HELP_COMMAND = '-h'

    static void main(String[] args) {
        final def HELP = '''• posting (and the only way to create a user): <user name> -> <message>
• reading: <user name>
• following: <user name> follows <another user>
• wall: <user name> wall'''
        def output
        final def evaluator = new ClassPathXmlApplicationContext("applicationContext.xml")
            .getBean('evaluator')

        print "\nWelcome to TwitterLike (\'$HELP_COMMAND\' for help).\n> "
        System.in.eachLine { command ->
            if (command == HELP_COMMAND) {
                println HELP
            } else {
                output = evaluator.interpret(command)
                if (output != null) {
                    println output
                }
            }
            print '> '
        }
    }
}
