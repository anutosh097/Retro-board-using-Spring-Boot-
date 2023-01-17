package com.example.demo.repo;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername_HappyPath_ShouldReturn1User() throws Exception {
        // Given
        User user = new User();
        user.setUsername("Anutosh12");
        user.setPassword("xxxxxx");
        user.setRole("USER3");
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
	    user.setRole("USER3");
	
	    // When
	    User actual = userRepository.save(user);
	
	    // Then
	    assertThat(actual).isNotNull();
	    assertThat(actual.getId()).isNotNull();
	}


}
