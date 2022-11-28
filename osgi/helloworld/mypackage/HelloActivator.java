package mypackage;

import org.osgi.framework.*;

public class HelloActivator implements BundleActivator {
	// start the bundle
	public void start(BundleContext context){
		System.out.println("Hello");
	}

	// stop the bundle
	public void stop(BundleContext context){
		System.out.println("Bye...");
	}
}
