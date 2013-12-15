package johnjimenez.usbinterview.twitterlike.interpreter

// <command> ::== <subject> ' ' <action> ' ' <subject>
// <subject> ::== <user-name> | <follower> | <poster>
// <action>  ::== '' | 'follows' | '->' | 'wall'
// <subject> ::== '' | <followees> | <message>

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
