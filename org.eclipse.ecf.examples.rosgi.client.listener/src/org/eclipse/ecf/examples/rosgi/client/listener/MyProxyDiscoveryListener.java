package org.eclipse.ecf.examples.rosgi.client.listener;

import org.eclipse.ecf.discovery.IServiceInfo;
import org.eclipse.ecf.osgi.services.discovery.IProxyDiscoveryListener;

public class MyProxyDiscoveryListener implements IProxyDiscoveryListener {

	@Override
	public void discovered(IServiceInfo serviceInfo) {
		System.out.println("service discrovered " + serviceInfo);
	}

	@Override
	public void undiscovered(IServiceInfo serviceInfo) {
		System.out.println("service undiscrovered " + serviceInfo);
	}
}
