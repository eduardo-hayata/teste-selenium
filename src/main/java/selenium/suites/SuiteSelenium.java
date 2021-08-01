package selenium.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import selenium.tests.GmailTest;
import selenium.tests.GoogleTest;
import selenium.tests.NetshoesTest;

@RunWith(Suite.class)
@SuiteClasses({
	GoogleTest.class,
	GmailTest.class,
	//HotmailTest.class
	NetshoesTest.class
})
public class SuiteSelenium {

}
