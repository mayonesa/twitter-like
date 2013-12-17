package johnjimenez.usbinterview.twitterlike.interpreter

// <command> ::== <subject> ' ' <action> ' ' <subject>
// <subject> ::== <user-name> | <follower> | <poster>
// <action>  ::== '' | 'follows' | '->' | 'wall'
// <subject> ::== '' | <followees> | <message>
// 
// Inspired by the interpeter pattern. However, the commands are fixed-position oriented
// and will not require the composite pattern traditionally composing the interpreter one.
// In addition, there will be no need to pass the context since there is no context
// outside of the entered command.
class Evaluator {
    private def syntaxTree
 
    Evaluator(String command) {
        Scanner commandTokens = new Scanner(command).useDelimiter(' ')
        String subject = commandTokens.next()
        if (!commandTokens.hasNext()) {
            syntaxTree = new ReadExpression(userName:subject)
        } else {
            String action = commandTokens.next()
            if (!commandTokens.hasNext()) {
                syntaxTree = new WallExpression(userName:subject)
            } else {
                String object = commandTokens.skip(' ').nextLine()
                if (action == '->') {
                    syntaxTree = new PostExpression(posterName:subject, 
                      message: object)
                } else {
                    syntaxTree = new FollowExpression(followerName:subject, 
                      followeeName:object)
                }
            }
        }
    }
    
    def interpret() {
        syntaxTree.interpret()
    }
}
