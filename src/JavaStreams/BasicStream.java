package JavaStreams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class BasicStream {

	public static void main(String[] args) {
		
		ArrayList<String> al=new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Don");
		al.add("Alekhya");
		al.add("adam");
		al.add("Ram");
		al.add("Ajay");
			
		long y=al.stream().filter(s->s.startsWith("a")).count();
		System.out.println(y);
		
		long c=Stream.of("Abhijeet","Don","Alekhya","adam","Ram","Ajay").filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		Stream<String> values=Stream.of("Abhijeet","Don","Alekhya","adam","Ram","Ajay");
		
		values.filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		values.filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}

}
