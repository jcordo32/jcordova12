package Balloon;

public class Balloon {
	boolean helium;
	Size balloonSize;
	String imagePath;
	@Override
	public String toString()
	{
		return balloonSize + ((helium) ? " Helium" : " Air");
	}
	public String getImagePath()
	{
		return imagePath;
	}
	public Balloon (Size s, boolean h)
	{
		balloonSize = s;
		helium = h;
		
		switch (s)
		{
		case XS: imagePath = "/images/balloon20.jpg";break;
	
		case S: imagePath =  "/images/balloon40.jpg";break;
		
		case M: imagePath =  "/images/balloon60.jpg";break;
		
		case L: imagePath = "/images/balloon80.jpg";break;
		
		case XL: imagePath =  "/images/balloon100.jpg";break;
		
		
		}
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balloonSize == null) ? 0 : balloonSize.hashCode());
		result = prime * result + (helium ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balloon other = (Balloon) obj;
		if (balloonSize != other.balloonSize)
			return false;
		if (helium != other.helium)
			return false;
		return true;
	}
	
}
