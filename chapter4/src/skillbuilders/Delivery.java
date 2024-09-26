package skillbuilders;

import java.util.Scanner;

public class Delivery {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please input the width of your parcel:\t");
		int parcelWidth = userInput.nextInt();
		
		System.out.print("Please input the height of your parcel:\t");
		int parcelHeight = userInput.nextInt();
		
		System.out.print("Please input the length of your parcel:\t");
		int parcelLength = userInput.nextInt();
		
		if (parcelWidth > 10 || parcelHeight > 10 || parcelLength > 10) {
			System.out.print("Parcel is too big! Must be under or equal to 10 in all dimensions.");
		} else {
			System.out.print("Parcel is the right size.");
		}


	}

}
