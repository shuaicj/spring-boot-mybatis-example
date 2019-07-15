package shuaicj.example.mybatis.relationship.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shuaicj.example.mybatis.relationship.entity.Identity;
import shuaicj.example.mybatis.relationship.entity.Person;
import shuaicj.example.mybatis.relationship.entity.Project;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test relationship mappers.
 *
 * @author shuaicj 2019/07/03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipMapperTest {

    private static final String IDENTITY_1 = "identity1";
    private static final String IDENTITY_2 = "identity2";
    private static final String PERSON_1 = "shuaicj1";
    private static final String PERSON_2 = "shuaicj2";
    private static final String PROJECT_1 = "project1";
    private static final String PROJECT_2 = "project2";

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private IdentityMapper identityMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Before
    public void setUp() {
        personMapper.deleteAll();
        identityMapper.deleteAll();
        projectMapper.deleteAll();

        Identity identity1 = new Identity(IDENTITY_1);
        Identity identity2 = new Identity(IDENTITY_2);
        identityMapper.insert(identity1);
        identityMapper.insert(identity2);

        Project project1 = new Project(PROJECT_1);
        Project project2 = new Project(PROJECT_2);
        projectMapper.insert(project1);
        projectMapper.insert(project2);

        Person person1 = new Person(PERSON_1);
        person1.setIdentity(identity1);
        personMapper.insert(person1);

        Person person2 = new Person(PERSON_2);
        person2.setIdentity(identity2);
        personMapper.insert(person2);
    }

    @After
    public void tearDown() {
        personMapper.deleteAll();
        identityMapper.deleteAll();
        projectMapper.deleteAll();
    }

    @Test
    public void personToIdentityIsOneToOne() {
        Person person = personMapper.findDetailByName(PERSON_1);
        assertThat(person.getName()).isEqualTo(PERSON_1);
        assertThat(person.getIdentity()).isNotNull();
        assertThat(person.getIdentity().getNumber()).isEqualTo(IDENTITY_1);
        assertThat(person.getIdentity().getPerson()).isNull();
    }

    @Test
    public void identityToPersonIsOneToOne() {
        Identity identity = identityMapper.findDetailByNumber(IDENTITY_1);
        assertThat(identity.getNumber()).isEqualTo(IDENTITY_1);
        assertThat(identity.getPerson()).isNotNull();
        assertThat(identity.getPerson().getName()).isEqualTo(PERSON_1);
        assertThat(identity.getPerson().getIdentity()).isNull();
    }
}