package org.eclipse.ecf.examples.rosgi.host.listener;

import org.eclipse.ecf.discovery.IServiceInfo;
import org.eclipse.ecf.osgi.services.discovery.IHostDiscoveryListener;
import org.osgi.framework.ServiceReference;

public class MyHostDiscoveryListener implements IHostDiscoveryListener {

	@Override
	public void publish(ServiceReference publicationServiceReference,
			IServiceInfo serviceInfo) {

		System.out.println("service publish\n\tpublicationServiceReference = " + publicationServiceReference +
				"\n\tserviceInfo = " + serviceInfo);
	}

	@Override
	public void unpublish(ServiceReference publicationServiceReference,
			IServiceInfo serviceInfo) {

		System.out.println("service unpublish\n\tpublicationServiceReference = " + publicationServiceReference +
				"\n\tserviceInfo = " + serviceInfo);
	}
}
