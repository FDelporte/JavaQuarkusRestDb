package be.webtechie.javaquarkusrestdb;

import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Quarkus REST DB example application",
                version = "1.0-SNAPSHOT",
                contact = @Contact(
                        name = "webtechie.be",
                        url = "https://webtechie.be"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class QuarkusDbApplication extends Application {
    // NOP, used to configure OpenAPI
}
