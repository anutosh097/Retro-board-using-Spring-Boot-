package com.example.demo.repoTest;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername_HappyPath_ShouldReturn1User() throws Exception {
        // Given
        User user = new User();
        user.setUsername("Anutosh");
        user.setPassword("xxxxxx");
        user.setRole("USER");
        testEntityManager.persist(user);
        testEntityManager.flush();

        // When
        User actual = userRepository.findByUsername("Anutosh");

        // Then
        assertThat(actual).isEqualTo(user);
    }

	@Test
	public void save_HappyPath_ShouldSave1User() throws Exception {
	    // Given
	    User user = new User();
	    user.setUsername("Anutosh12");
	    user.setPassword("XXXXXX");
	    user.setRole("USER");
	
	    // When
	    User actual = userRepository.save(user);
	
	    // Then
	    assertThat(actual).isNotNull();
	    assertThat(actual.getId()).isNotNull();
	}


}
