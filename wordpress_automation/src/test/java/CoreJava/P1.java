package CoreJava;

import java.util.ArrayList;
import java.util.List;

public class P1 {

	static Integer getColPos(List<String> tHeader,String text) {
		for(int i=0;i<tHeader.size();i++) {
			if(tHeader.get(i).equals(text)) {
				return i;
			}
		}
	
		return -1;
	}
	
	public static void main(String[] args) {
		List<String>header = new ArrayList<String>();
		header.add("Hai");
		header.add("Bye");
		header.add("Jai");
		header.add("Josh");
		
		System.out.println(getColPos(header, "Josh"));
	}
}
