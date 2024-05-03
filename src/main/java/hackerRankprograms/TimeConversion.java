package hackerRankprograms;
 
import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		//HH:MM:SSAM or HH:MM:SSPM format
		String s = scanner.next();
		System.out.println(timeConversion(s));
		scanner.close();

	}
	public static String timeConversion(String s) {
		    // Write your code here
			
			int hours = Integer.parseInt(s.substring(0, 2));
		    String time = s.substring(2, 8);
		   
		    if(s.charAt(8)=='A') {
		    	if(hours == 12) {
		    		hours=00;
		    		return "00"+time;	
		    		}
		    	if(hours==10||hours==11) {
		    		return hours+time;
		    	}
		    	return "0"+hours+time;
		    }else {
		    	if (hours==12) {
		    		return "12"+time;
				}
		    	hours+=12;
		    	return hours+time;
		    	
			}
		    
	}
}
