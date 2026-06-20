package springtest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        UserRepository mockRepo = mock(UserRepository.class);
        User mockUser = new User(1L, "John Doe");
        
        when(mockRepo.findById(1L)).thenReturn(Optional.of(mockUser));
        
        UserService service = new UserService(mockRepo);
        User result = service.getUserById(1L);
        
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }
}
