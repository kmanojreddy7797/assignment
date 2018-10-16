
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class HelloWorldCheckClient {

	private static final String webServiceURI = "http://localhost:8080/RESTEX1";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);

		// response
		System.out.println("HEllo");
		System.out.println(webTarget.path("rest").path("xyz").request()
				.accept(MediaType.TEXT_PLAIN) //client expects plain text
				.get(Response.class).toString()); //client sends thru HTTP GET Method

	}
}
