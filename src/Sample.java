import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Sample 
{
	/*@Test
  public  void test()
  {
	ArrayList<String> names= new ArrayList<String>();
	names.add("Amar");
	names.add("Akbar");
	names.add("Anthony");
	names.add("Daya");
	names.add("Akash");
	names.add("Steven");
	int count=0;
	for(int i=0;i<names.size();i++)
	{
		String actual = names.get(i);
		if(actual.startsWith("A"))
		{
			count++;
		}
	}
	System.out.println(count);
}*/
	@Test
	public void streams()
	{
		ArrayList<String> names= new ArrayList<String>();
		names.add("Amar");
		names.add("Akbar");
		names.add("Anthony");
		names.add("Daya");
		names.add("Akash");
		names.add("Steven");
		//long number = names.stream().filter(n->n.startsWith("A")).count();
		//System.out.println(number);
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(n->n.length()>4).limit(1).forEach(n->System.out.println(n));
	}

	@Test
	public void streamMap()
	{
		//print the name whose last letter is a and convert into upper case
		
		Stream.of("Amar","Akbar","Anthony","Daya","Akash","Steven").filter(n->n.endsWith("a")).map(n->n.toUpperCase()).forEach(n->System.out.println(n));
		
		
	}
}
		
		