package nl.limesco.cserv.account.rest;

import nl.limesco.cserv.account.api.AccountService;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager) throws Exception {
		manager.add(createComponent()
				.setInterface(Object.class.getName(), null)
				.setImplementation(AccountsResource.class)
				.add(createServiceDependency().setService(AccountService.class).setRequired(false).setDefaultImplementation(UnavailableAccountService.class)));
	}

	@Override
	public void destroy(BundleContext context, DependencyManager manager) throws Exception {
	}

}