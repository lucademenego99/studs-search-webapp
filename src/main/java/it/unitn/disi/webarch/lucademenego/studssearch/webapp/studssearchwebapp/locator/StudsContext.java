package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class StudsContext {
    private final Properties properties;
    private final String commonPrefix;

    public StudsContext(String commonPrefix) {
        properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        this.commonPrefix = commonPrefix;
    }

    public Object lookup(String name) throws NamingException {
        InitialContext context = new InitialContext(properties);
        return context.lookup(commonPrefix + "/" + name);
    }
}
