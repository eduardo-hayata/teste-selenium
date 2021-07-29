package selenium.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import selenium.tests.GmailTest;
import selenium.tests.GoogleTest;

@RunWith(Suite.class)
@SuiteClasses({
	GoogleTest.class,
	GmailTest.class
	//HotmailTest.class
})
public class SuiteSelenium {

}
