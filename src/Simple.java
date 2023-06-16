import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Simple 
{
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
	
	//	names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    List<String> countryNames= Arrays.asList("India","USA","Russia");
    Stream<String> newSrteam = Stream.concat(names.stream(), countryNames.stream());
    //newSrteam.sorted().forEach(s->System.out.println(s));
    boolean flag = newSrteam.anyMatch(s->s.equalsIgnoreCase("Amar"));
    System.out.println(flag);
    Assert.assertTrue(flag);
  
  }
  @Test
  public void streamCollect()
  {
	  List<Integer> value= Arrays.asList(1,3,4,5,7,3,9,0,1,3,5,7);
	  //print unique number in sorted order and print 3 value.
	  List<Integer> number = value.stream().distinct().sorted().collect(Collectors.toList());
	  System.out.println(number.get(5));
	  
  }
}
