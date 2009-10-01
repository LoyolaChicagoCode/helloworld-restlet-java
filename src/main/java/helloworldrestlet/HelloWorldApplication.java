package helloworldrestlet;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.Router;
import org.restlet.data.Protocol;

/**
 * Simple demo application that can be run either as a standalone application
 * (http://localhost:8181/) or inside a servlet container
 * (http://localhost:8080/helloworld-restlet/).
 */
public class HelloWorldApplication extends Application {

	public static void main(String... args) throws Exception {
		// Create an HTTP server component and start it
		Component comp = new Component();
		comp.getServers().add(Protocol.HTTP, 8181);

		// Attach the application to the default host and start it
		comp.getDefaultHost().attachDefault(new HelloWorldApplication());
		comp.start();
	}

	/**
	 * Constructs an instance of this application.
	 */
	public HelloWorldApplication() {
		super();
	}

	/**
	 * Constructs an instance of this application using the given context.
	 * 
	 * @param context
	 *            the context
	 */
	public HelloWorldApplication(Context context) {
		super(context);
	}

	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	@Override
	public synchronized Restlet createRoot() {
		// Create a router Restlet that routes each call to a
		// new instance of HelloWorldResource.
		Router router = new Router(getContext());

		// Defines only one route
		router.attachDefault(HelloWorldResource.class);

		return router;
	}
}