package johnjimenez.usbinterview.twitterlike.ui

import org.springframework.context.support.ClassPathXmlApplicationContext

class ConsoleView {
    static void main(String[] args) {
        def HELP = '''• posting (and the only way to create a user): <user name> -> <message>
• reading: <user name>
• following: <user name> follows <another user>
• wall: <user name> wall'''
        def HELP_COMMAND = '-h'
        def output
        def evaluator = new ClassPathXmlApplicationContext("applicationContext.xml")
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
