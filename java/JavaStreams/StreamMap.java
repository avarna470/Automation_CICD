package JavaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamMap {

	public static void main(String[] args) {
		
		Stream<String> values=Stream.of("Abhijeet","Don","Alekhya","adam","Ram","Anila");
		
		values.filter(s->s.length()>4).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		values.sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		Stream<String> val=Stream.of("A","B","C");
		
		Stream<String> newStream=Stream.concat(values, val);
		
		newStream.forEach(s->System.out.println(s));
		
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Anila"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		List<String> l=newStream.filter(s->s.length()<4).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(l);
		
		Integer[] arr= {3,2,2,7,5,1,9};
		List<Integer> list=Arrays.asList(arr);
		
		list.stream().distinct().forEach(i->System.out.println(i));
		Object[] sortedarray=list.stream().distinct().sorted().toArray();
		System.out.println(sortedarray[5]);
		
		
		
	}

}
