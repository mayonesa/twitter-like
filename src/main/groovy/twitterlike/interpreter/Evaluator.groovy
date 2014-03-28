package twitterlike.interpreter

import javax.inject.*

import static twitterlike.ui.ConsoleView.HELP_COMMAND

// <command> ::== <subject> ' ' <action> ' ' <object>
// <subject> ::== <user-name> | <follower> | <poster>
// <action>  ::== '' | 'follows' | '->' | 'wall'
// <object> ::== '' | <followees> | <message>
// 
// Inspired by the interpeter pattern. However, the commands are fixed-position oriented
// and will not require the composite pattern traditionally composing the interpreter one.
// In addition, there will be no need to pass the context since there is no context
// outside of the entered command.
@Named
class Evaluator {
    public final static def WALL = 'wall'
    public final static def POST = '->'
    public final static def FOLLOWS = 'follows'
    public final static def ERROR_MESSAGE = "ERROR: invalid command (type \'$HELP_COMMAND\' for help)"
    
    @Inject
    def postExpression
    
    @Inject
    def readExpression
    
    @Inject
    def wallExpression
    
    @Inject
    def followExpression
    
    def interpret(command) {
        Scanner commandTokens = new Scanner(command)
        def subject = commandTokens.next()
        if (!commandTokens.hasNext()) {
            return readExpression.interpret(subject)
        } else {
            def action = commandTokens.next()
            if (!commandTokens.hasNext()) {
                if (action == WALL) {
                    return wallExpression.interpret(subject)
                }
            } else {
                def object = commandTokens.skip(' ').nextLine()
                if (action == POST) {
                    return postExpression.interpret(object, subject)
                } else if (action == FOLLOWS && object.split().length == 1) {
                    return followExpression.interpret(subject, object)
                } 
            }
        }
        ERROR_MESSAGE
    }
}
