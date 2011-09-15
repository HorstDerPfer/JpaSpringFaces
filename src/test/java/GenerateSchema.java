import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.fmi.framework.core.model.User;
import de.fmi.framework.core.service.UserService;

@TransactionConfiguration
@ContextConfiguration({ "classpath:**/WEB-INF/applicationContext.xml",
		"classpath:**/WEB-INF//applicationContext-jpa.xml" })
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class GenerateSchema {

	@Autowired
	@Qualifier("userService")
	UserService userService;

	@Test
	public void listUsers() {
		List<User> users = userService.findAllUsers();
		Assert.assertNotNull(users);
	}
}
