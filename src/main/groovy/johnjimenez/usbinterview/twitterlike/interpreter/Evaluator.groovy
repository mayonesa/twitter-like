package johnjimenez.usbinterview.twitterlike.interpreter

import javax.inject.*

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
    @Inject
    def postExpression
    
    @Inject
    def readExpression
    
    @Inject
    def wallExpression
    
    @Inject
    def followExpression
    
    def interpret(command) {
        Scanner commandTokens = new Scanner(command).useDelimiter(' ')
        def subject = commandTokens.next()
        if (!commandTokens.hasNext()) {
            readExpression.interpret subject
        } else {
            def action = commandTokens.next()
            if (!commandTokens.hasNext()) {
                wallExpression.interpret subject
            } else {
                def object = commandTokens.skip(' ').nextLine()
                if (action == '->') {
                    postExpression.interpret object, subject
                } else {
                    followExpression.interpret subject, object
                }
            }
        }
    }
}
