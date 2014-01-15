package johnjimenez.usbinterview.twitterlike.repository

import org.junit.*

import johnjimenez.usbinterview.twitterlike.domain.User

import static UserRepository.userRepository

class UserRepositoryTest {
        
    @BeforeClass
    @AfterClass
    static void cleanUp() {
        userRepository.clear()
    }

    @Test
    void getUserByName() {
        def userName1 = 'user1'
        def user1 = new User(name: userName1)
        def userName2 = 'user2'
        def user2 = new User(name: userName2)
        assert user1 == userRepository.getUserByName(userName1)
        assert user1 == userRepository.getUserByName(userName1)
        assert user2 == userRepository.getUserByName(userName2)
        assert user1 == userRepository.getUserByName(userName1)
        assert user2 == userRepository.getUserByName(userName2)
    }
}
