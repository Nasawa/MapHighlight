package com.anigeek.maphighlight;

import android.graphics.Rect;

public class Room
{
	private Rect rect;
	private String name;
	private boolean isReserved = false;

	public Room(String n, Rect r, boolean i)
	{
		name = n;
		rect = r;
		isReserved = i;
	}

	public Room(String n, int l, int u, int r, int d, boolean i)
	{
		name = n;
		rect = new Rect(l,u,r,d);
		isReserved = i;
	}

	public Rect getRect()//GET #REKT
	{
		return rect;
	}

	public boolean isReserved()
	{
		return isReserved;
	}

	public void setReserved(boolean b)
	{
		isReserved = b;
	}

	public String toString()
	{
		return String.format("%s - %s", name, isReserved ? "Reserved" : "Not Reserved");
	}
}
