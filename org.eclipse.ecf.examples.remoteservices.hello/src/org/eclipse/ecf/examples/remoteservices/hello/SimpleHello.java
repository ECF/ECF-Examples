package org.eclipse.ecf.examples.remoteservices.hello;

import java.util.Date;

public class SimpleHello implements IHello {

	public void hello(String from) {
		System.out.println((new Date()) + " Start Hello from " + from);
		pause();
		System.out.println((new Date()) + " End Hello from " + from);
	}

	private void pause()
	{
		for (long i = 0; i < 1000000; i++)
			for (int j = 0; j < 100; j++)
			{
				Math.random();
			}
	}
}
