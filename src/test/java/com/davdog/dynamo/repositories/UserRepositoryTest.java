package com.davdog.dynamo.repositories;


import com.davdog.dynamo.config.DynamoDBConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PropertyPlaceholderAutoConfiguration.class, DynamoDBConfig.class})
public class UserRepositoryTest {

  @Autowired
  private UserRepository repository;

  @Test
  public void sampleTestCase() {
    repository.deleteAll();
    User dave = new User("Dave", "Matthews");
    repository.save(dave);

    User carter = new User("Carter", "Beauford");
    repository.save(carter);

    List<User> result = repository.findByLastName("Matthews");
    assertThat(result.size(), is(1));
    assertThat(result, hasItem(dave));
  }

}
