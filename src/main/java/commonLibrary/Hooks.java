package commonLibrary;

import java.io.IOException;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends LibraryFunctions {

	@Before
	public void beforeHookfunction() throws IOException, InterruptedException  {
		System.out.println("Entering before hook");
		setup();
	}

	@After
	public void afterHookfunction() throws Exception {
		System.out.println("Entering after hook");
		closeapp();
	}

}
