package mianshiti;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main
{
    private final String name;
    public Main(String name)
    {
    	this.name = name;
    }
    public boolean equals(Object o)
    {
    	if(!(o instanceof Main))
    		return false;
    	Main n = (Main) o;
    	return n.name.equals(name);
    }
    public static void main(String[] args)
	{
		Set<Main> set = new HashSet<Main>();
		Main main1 = new Main("mikey");
		set.add(main1);
		System.out.println(set.contains("mikey"));
		System.out.println(set.contains(new Main("mikey")));
	}
}
