package johnjimenez.usbinterview.twitterlike.exception

class UserNotFoundException extends TwitterLikeException {
    UserNotFoundException(userName) {
        super("\'$userName\' not in TwitterLike; users get entered when they post (e.g., john -> this is a post)")
    }
}
