package it.unitn.disi.webarch.lucademenego.studssearch.webapp.studssearchwebapp.locator;

import jakarta.ejb.Stateful;

import javax.naming.NamingException;
import java.util.HashMap;

/**
 * Service Locator used to access beans exposed by Wildfly.
 * It keeps a cache with the found objects, to prevent useless lookups
 */
public class ServiceLocator {
    /**
     * Cache of the looked up objects
     */
    private static final HashMap<String, Object> cache;

    /**
     * Prefix common to all lookup strings
     */
    private static final String ejbPrefix;

    static {
        cache = new HashMap<>();
        ejbPrefix = "ejb:/studs-search-backend-1.0-SNAPSHOT";
    }

    /**
     * Get a bean exposed by the Wildfly instance given its class
     * @param bean class of the requested bean
     * @return looked up bean
     * @throws NamingException the bean was not found
     */
    public static Object getBean(Class<?> bean) throws NamingException {
        // Get the actual jndi string from the bean class (excluding the prefix)
        String beanName = getBeanName(bean);

        // Check if the cache already contains the bean
        Object service = cache.get(beanName);
        if (service == null) {
            // If the cache does not contain the bean, perform a lookup
            StudsContext context = new StudsContext(ejbPrefix);
            service = context.lookup(beanName);
            cache.put(beanName, service);
        }
        return service;
    }

    /**
     * Get the bean name for lookup given its class. The function has been constructed based on the
     * documentation provided at:
     * https://docs.jboss.org/author/display/WFLY10/EJB%20invocations%20from%20a%20remote%20client%20using%20JNDI.html
     * where the syntax is explained.
     * @param c the bean class
     * @return the name of the bean used for lookup
     */
    private static String getBeanName(Class<?> c) {
        if (c.getInterfaces().length == 0 || c.getAnnotations().length == 0) {
            return "";
        }
        return c.getSimpleName() + "!" + c.getInterfaces()[0].getName()
                + (c.getAnnotation(Stateful.class) != null ? "?stateful" : "");
    }
}
