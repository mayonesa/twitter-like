package twitterlike.clientjms

import javax.inject.*

@Named
class PostProducer {
    @Inject
    def jmsTemplate
    
    @Inject
    def postDestination
    
    void post(post, poster) {
        jmsTemplate.convertAndSend postDestination, ['post': post, 'poster': poster]
    }
}
