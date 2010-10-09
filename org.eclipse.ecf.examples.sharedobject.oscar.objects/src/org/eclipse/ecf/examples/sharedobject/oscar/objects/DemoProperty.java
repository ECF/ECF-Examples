package org.eclipse.ecf.examples.sharedobject.oscar.objects;

import java.io.Serializable;

public class DemoProperty implements Serializable
{
	private static final long serialVersionUID = -415744245843954244L;

	private String _id;

	private int _a;

	private float _b;

	public DemoProperty(String id, int a, float b)
	{
		_id = id;
		_a = a;
		_b = b;
	}

	public String getId()
	{
		return _id;
	}

	public void setId(String id)
	{
		_id = id;
	}

	public int getA()
	{
		return _a;
	}

	public void setA(int a)
	{
		_a = a;
	}

	public float getB()
	{
		return _b;
	}

	public void setB(float b)
	{
		_b = b;
	}

	public String toString()
	{
		return "(" + _id + ":" + _a + ":" + _b + ")";
	}
}
