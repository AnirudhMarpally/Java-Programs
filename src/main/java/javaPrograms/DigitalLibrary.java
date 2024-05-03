package javaPrograms;

import java.util.Scanner;
public class DigitalLibrary {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Video Type : comedy/documentary/historical");
	String videoType = sc.nextLine();
	System.out.println("Enter Video Name : ");
	String videoName = sc.nextLine();
	System.out.println("Enter number of days you want to lease: ");
	int numberOfDays = sc.nextInt();
	Video video = new Video(videoType, videoName, numberOfDays);
	video.calculateRent();
	
	
	}
}
class Video {
		
	private String videoType;
	private String videoName;
	private int numberOfDays;
	public Video(String videoType, String videoName, int numberOfDays) {
	this.videoType = videoType;
	this.videoName = videoName;
	this.numberOfDays = numberOfDays;
	}
	public void calculateRent() {
		double rent = 0;
		double fixedPrice =0;
		
		switch (videoType) {
		case "comedy":
			fixedPrice = 9.90;
			break;
		case "documentary":
			fixedPrice = 15.50;
			break;
		case "historical":
			fixedPrice = 12.22;
			break;
		}
		
		if (numberOfDays <= 10) {
            rent = fixedPrice;
        } else if (numberOfDays>10 && numberOfDays <= 20) {
            rent = fixedPrice + 3.5 * (numberOfDays - 10);
        } else if (numberOfDays>20 && numberOfDays <= 30) {
            rent = fixedPrice + (3.5 * 10) + 15.25 * (numberOfDays - 20);
        } else {
            rent = fixedPrice + (3.5 * 10) + (15.25 * 10) + 20.50 * (numberOfDays - 30);
        }
		System.out.println("Video Type : " + videoType);
		System.out.println("Video Name : " + videoName);
		System.out.println("Fixed Price: " + fixedPrice);
		System.out.println("Total Amount : " + rent );
		}
}