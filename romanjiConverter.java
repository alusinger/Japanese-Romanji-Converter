package com.convert_Number_To_Romanji;

import java.util.HashMap;

public class romanjiConverter {
	
	private HashMap< Integer, String > romanjiHashMap ; // initializes romanjiHashMap 
	int inputNumber = 0; // initializes inputNumber variable and set's it's number to zero.
	
		
	public romanjiConverter(){ // Constructor for romanjiConverter
	
		createRomanjiMap(); // initializes the createRomanjiMap method below to create the romanji HashMap
		
	} // End of romanjiConverter constructor method

	/* This section is a work in progress.
	*    This will likely require changes to the numberConvert method. 
   	*    My rough plan is to change numberConvert to handle the conversion of numbers 
   	*      between 1-9999 returning the string for those numbers to this method. 
   	*      Further, this method will handle the breakdown of the myriads (groups of 10,000)
   	*      and group the strings from numberConvert.
   	* 
   	*
   	* This method would be implemented to handle numbers larger than 10,000.
	* Numbers larger than 10,000 require converting the numbers into myriads (groups of 10,000)
	* 
	* Rough design of method - work in progress.
	* public void largeNumberConvert(int inputNumber, int numberLength){
	* 	
	* 	if ( numberLength < 5 ){ // if the number length is less than 5, just do numberConvert
	* 			numberConvert(inputNumber);
	* 
	* 		while ( numberLength >= 5 ){ // while the numberLength is greater than or equal to 5 do the following.
	* 			
	* 			inputNumber
	* 			
	* 
	* 		}
	* 
	* 	}
	* 
	* }
	*/
	
	
	/*
	 * Gets input number from the Main.jave class
	 * 
	 * Checks to see if the number is divisible by 1000
	 * 		Checks if the number is 1000, 3000, 8000 
	 * 			If so, adds that value from the romanjiHashMap to the string
	 * 		Otherwise divides the number by 1000 and adds the value for that key from romanjiHashmap
	 * 		Does mod 1000 for inputNumber
	 * 
	 * Checks to see if the number is divisible by 100
	 * 		Checks if the number is 100, 300, 600, 800 
	 * 			If so, adds that value from the romanjiHashMap to the string
	 * 		Otherwise divides the number by 100 and adds the value for that key from romanjiHashmap
	 * 		Does mod 100 for inputNumber
	 * 
	 * Checks if the number is divisible by 10
	 * 		Divides the number by 10 and adds that value from romanjiHashMap 
	 * 		Does mod 10 for inputNumber
	 * 
	 * Adds value from romanjiHashMap for single digit value
	 */
	public void numberConvert(int inputNumber){
		
		StringBuilder sb = new StringBuilder(); // creates an new instance of Stringbuilder to build the romanji string.
		
		while (inputNumber >= 1 ){ // While the inputNumber is greater than 0 do the following loop
			
			
			if ( (inputNumber / 1000 ) >= 1 ){ // If inputNumber / 1000 is greater than 0 do the following
				
				/* 
				 * Checks to see if the input number is 1000, 3000, or 8000
				 * ((inputNumber / 1000) * 1000 == 1000) e.g. (1443 / 1000) = 1 * 1000 = 1000
				 * Appends the value if it is in the hashmap 
				 * Changes the value of inputNumber to the remainder of the 4 digit number
				 * inputNumber = inputNumber % 1000 e.g. (1443 % 1000) = 443
				 */
				if ((inputNumber / 1000)*1000 == 1000 || (inputNumber / 1000)*1000 == 3000 || (inputNumber / 1000)*1000 == 8000){
					
					sb.append(romanjiHashMap.get((inputNumber / 1000) * 1000 )+" ");
					inputNumber = inputNumber % 1000;
					
				} else {
					
					sb.append(romanjiHashMap.get(inputNumber / 1000)+romanjiHashMap.get(1000)+" ");
					inputNumber = inputNumber % 1000;
					
				}
				
			}
			
			if ( (inputNumber / 100 ) >= 1 ){ // If inputNumber / 100 is greater than 0 do the following

				/* 
				 * Checks to see if the input number is 100, 300, 600, or 800.
				 * ((inputNumber / 100) * 100 == 100) e.g. (144 / 100) = 1 * 100 = 100
				 * Appends the value if it is in the HashMap 
				 * Else just appends the value of (input/100) from the HashMap
				 * Changes the value of inputNumber to the remainder of the 3 digit number
				 * inputNumber = inputNumber % 100 e.g. (443 % 100) = 43				 
				 */
				if ((inputNumber / 100)*100 == 100 || (inputNumber / 100)*100 == 300 || (inputNumber / 100)*100 == 600 || (inputNumber / 100)*100 == 800){

					sb.append(romanjiHashMap.get((inputNumber / 100) * 100 )+ " ");
					inputNumber = inputNumber % 100;
					
				} else {

					sb.append(romanjiHashMap.get(inputNumber / 100)+romanjiHashMap.get(100)+" ");
					inputNumber = inputNumber % 100;
					
				}
				
			}
			
			/* 
			 * Appends the value of (input/10) from the HashMap
			 *
			 * Changes the value of inputNumber to the remainder of the 3 digit number
			 * inputNumber = inputNumber % 10 e.g. (43 % 10) = 3				 			 
			 * If statement is used to ensure that the grouping of words is spaced correctly
			 */			
			if ( (inputNumber / 10 ) >= 1 ){
				
				if ( ( inputNumber / 10 ) == 1 ){
				
					sb.append(romanjiHashMap.get(10)+" ");
					inputNumber = inputNumber % 10;
					
				} else {
					
					sb.append(romanjiHashMap.get(inputNumber / 10)+romanjiHashMap.get(10)+" "); 
					inputNumber = inputNumber % 10; 
					
				}
			}
			
			// If statment to ensure that any orders of magnitude that are 0 aren't given space in the string.
			if ( inputNumber == 0 ){
				
				sb.append("");
				
			}
			
			// Appends the single digit value to the string.
			if ( inputNumber >= 1 ){
				
				sb.append(romanjiHashMap.get(inputNumber));
				break;
				
			} 
			
		} // End of While loop
		
		System.out.println("The Romanji version of your number is: " + sb);
		
	} // End of numberConvert method
	
	
		
	
	
	
	
	
	
	private void createRomanjiMap(){

		romanjiHashMap = new HashMap< Integer, String>(); 	// Creates a Hashmap
		
		/* Romanji Hashmap
		* Sources: https://www.omniglot.com/language/numbers/japanese.htm
		*		   https://en.wikipedia.org/wiki/Japanese_numerals
		*
		* There are a few voicing or germination based on certain consonants. 
		* 		IE six-hundred = roku(six)hyaku(hundred) is pronounced roppyaku
		* This voicing or germination happens only at certain orders of magnitude based on those consonants.
		* 									
		* 		100 (hundred)			  
		* 		1,000 (thousand)		
		* 		10^12 (trillion)		
		* 		10^16 (ten-quadrillion) 
		*	
		*				100			1000		10^12		10^16
		*	1			hyaku /		sen /		itchoo		ikkei
		*				ippyaku		issen
		*	2
		*	3			sanbyaku	sanzen
		*	4
		*	5
		*	6			roppyaku							rokkei
		*	7			
		*	8			happyaku	hassen		hatchoo		hakkei		
		*	9	
		*	10									jutchoo
		*	100									hyakkei
		*
		* After ten thousand the format changes to reuse the previous numbers
		* This is known as digit grouping by "myriads" every 10,000 rather than the western 1,000
		* Since the myriads aren't grouped by 1,000 as in the US I'll list the short scale name with the Japanese equivalent. 
		* 1
		* 2
		* 3
		* 4
		* 5
		* 6
		* 7
		* 8
		* 9
		* 10				:	jū								-	10^1
		* 100				:	hyakku							-	10^2
		* 1000				:	issen or -sen(sen)				-	10^3 
		* 10 thousand		:	ichi-man 	 (man)				-	10^4 
		* 100,000 			:	jū-man							-	10^5
		* 					Example: One-hundred-thousand = juuman = ten ten-thousands.  
		* 1 million			:	hyaku-man 						:	10^6 
		* 					Example: One-million = hyakuman = one-hundred ten-thousands.  
		* 							 Two-million = nihyakuman = two-hundred ten-thousands.
		* 10 million 		:	-sen-man 						-	10^7
		* 100 million 		:	ichi-oku	(oku)				-	10^8
		* 1 billion 		:	jū-oku	 						-	10^9 
		* 10 billion  		:	hyaku-oku 						-	10^10
		* 100 billion 		:	-sen-oku 						-	10^11
		* 1 trillion		:	itchō	(chō pronounced as choo)-	10^12 
		* 					  Note: uses special voicing/germination for 1, 8, and 10. 
		* 					  Applies to multiples of 10 changing jū to -jutchō or -jukkei.
		* 10 trillion		:	jutchō 							-	10^13
		* 100 trillion  	:	hyaku-chō 						-	10^14
		* 1 quadrillion  	:	-sen-chō 						-	10^15
		* 10 quadrillion  	:	ikkei 		(kei)				-	10^16 
		* 					Note:uses special voicing/germination for 1, 6, 8, 10, and 100.
		* 100 quadrillion	:	jukkei 							-	10^17
		* 					Note: applies to multiples of 100 changing -ku to -kkei 
		* 1 quintillion  	:	hyaku-kei 						-	10^18
		* 10 quintillion  	:	-sen-kei 						-	10^19
		* 100 quintillion  	:	ichi-gai 	(gai)				-	10^20
		* 1 sextillion  	:	jū-gai 							-	10^21
		* 10 sextillion  	:	hyaku-gai 						-	10^22
		* 100 sextillion  	:	-sen-gai 						-	10^23
		* 1 septillion  	:	ichi-jo/shi (shi/jo)			-	10^24
		* 10 septillion  	:	jū-jo/shi						-	10^25
		* 100 septillion  	:	hyaku-jo/shi					-	10^26
		* 1 octillion  		:	-sen-jo/shi	 					-	10^27
		* 10 octillion  	:	ichi-jō	(jō pronounced as joo)	-	10^28
		* 100 octillion 	:	jū-jō							-	10^29
		* 1 nonillion  		:	hyaku-jō						-	10^30
		* 10 nonilllion		:	-sen-jō							-	10^31
		* 100 nonillion		:	ichi-kō	(kō	pronounced as koo)	-	10^32
		* 1 decillion 		: 	jū-kō							-	10^33
		* 10 decillion		:	hyaku-kō						-	10^34
		* 100 decillion		:	-sen-kō							-	10^35
		* 					:	kan								-	10^36
		* 					:	sei								-	10^40
		* 					:	sai								-	10^44
		* 					:	goku							-	10^48
		* 					:	gōgosha							-	10^52
		* 					:	asōgi							-	10^56
		* 					:	nayuta							-	10^60
		* 					:	fukashigi						-	10^64
		*					:	muryōtaisū						-	10^68
		*
		*
		* Numbers are combined from largest to smallest, and zeros are implied.
		* Since the numbers are grouped in digits of four instead of digits of three you get the following.
		* 		Note: added hyphen for clarity on digits
		* 			  added space for clarity on groupings 
		* 13 						= jūsan
		* 35 						= sanjūgo 
		* 352 						= sanbyaku-gojū-ni 
		* 7025						= nanasen-nijū-go
		* 4734 2002					= yon-sen-nanahyaku-sanjū-yon-man niman-ni
		* 							  In three digit grouping: 47,342,002
		* 5 2478 9010 0433 4220 	= go-kei nisen-yonhyaku-nanajū-hachi-chō kyuu-oku yonhyaku-sanjū-san-man yonsen-nihyakku-nijū 
		*							  In three digit grouping : 52,478,901,004,334,220
		*
		*/
		
		
		
		/*
		 *  HashMap for 0-10 and null.
		 */
		// adds zero space to null results from the HashMap
		romanjiHashMap.put(null, "");
		// handled in the Main, but here for completeness and error catching
		romanjiHashMap.put( 0, "zero or rei");  
		romanjiHashMap.put( 1, "ichi");
		romanjiHashMap.put( 2, "ni");
		romanjiHashMap.put( 3, "san");
		romanjiHashMap.put( 4, "yon");
		romanjiHashMap.put( 5, "go");
		romanjiHashMap.put( 6, "roku");
		romanjiHashMap.put( 7, "nana");
		romanjiHashMap.put( 8, "hachi");
		romanjiHashMap.put( 9, "kyū");
		romanjiHashMap.put( 10, "jū");
		// Special voicing for: one, three, six, and eight hundred.
		romanjiHashMap.put( 100, "hyaku");
		romanjiHashMap.put( 300, "sanbyaku");
		romanjiHashMap.put( 600, "roppyaku");
		romanjiHashMap.put( 800, "happyaku");
		// sen - one-thousand - 10^3
		// Special voicing for: One, three, and eight thousand.			
		romanjiHashMap.put( 1000, "issen");
		romanjiHashMap.put( 3000, "sanzen");
		romanjiHashMap.put( 8000, "hassen");
		
	} // End of createRomanjiMap method
	

/*  This section is a work in progress. It will be used to handle numbers larger than 10,000.
 *
 */

//  	public void largeRomanjiMap(){
//			/*	
//			 * Note: (Leaving this here as a design note)
//			 *  The maximum number that a 32-bit integer can hold is 2,147,483,647.
//			 *  May cast string that is larger as a long, segment the number and then convert it in segments.
//			 *
//			 *  break the string into segments of 4 digits (for myriads)
//			 *  numberLength = math.log10(inputNumber) for number of digits. 	
//			 *  StringBuilder fullnumber = new StringBuilder(); 
//			 *  if numberLength => 5
//			 *  	part2 = digits 4-8
//			 *  	fullNumber.append(romanjiConverter(part2);
//			 *  
//			 *  	if numberLength => 9
//			 *  		part 3 = digits 9-12
//			 * 		if numberLength => 13
//			 * 			part 4 = digits 13-16
//			 * 		if numberLength => 17
//			 * 			part 5 = digits 17-20
//			 * 		if numberLength => 21
//			 * 			part 6 = digits 21-24
//			 * 		if numberLength => 25
//			 * 			part 7 = digits 25-28
//			 * 		if numberLength =>29
//			 * 			part 8 = digits 29-32
//			 * 		if numberLength => 33
//			 * 			part 9 = digits 33-36				
//			 *  	else
//			 *  		part 1 = digits 1-4							 
//			 *  
//			 *  
//			 *  
//			 *  
//			 *  
//			 *  
//			 *  
//			 *  
//			 *  
//			 *  
//			 */
//			largeRomanjiMap.put( 4, "man");
//			// oku - One-hundred million - 10^8
//			largeRomanjiMap.put( 8, "oku");
//			// itchō (chō pronounced as choo) - One-trillion -	10^12 
//			// Uses special voicing for: one, eight, and ten trillion. 
//			//       Applies to multiples of ten changing jū to -jutchō or -jukkei.
//			largeRomanjiMap.put( 12, "itchō");
//			largeRomanjiMap.put((8^12), "hatchō");
//			largeRomanjiMap.put( 13, "juchō");
//			// kei - ten-quadrillion - 10^16
//			// Uses special voicing for: one, six, eight, ten, and one-hundred trillion.
//			largeRomanjiMap.put( 16, "kei");
//			largeRomanjiMap.put((60^16), "kei");
//			largeRomanjiMap.put((80^16), "kei");
//			largeRomanjiMap.put( 17, "kei");
//			largeRomanjiMap.put( 18, "kei");
//			// gai - one-hundred-quintillion - 10^20
//			largeRomanjiMap.put( 20, "gai");
//			// jo / shi - one septillion - 10^24 - Not sure if this is due to a variation in the printing of books a long time ago 
//			//	(see wikipedia) but apparently you can say either jo or shi.
//			largeRomanjiMap.put( 24, "jo");
//			// jō - ten octillion - 10^28
//			largeRomanjiMap.put( 28, "jō");
//			// kō (kō pronounced as koo) - ten-quadrillion -  10^32
//			largeRomanjiMap.put( 32, "kō");
//			// The following has been added here for completeness. 
//			// kan 								-	10^36
//			// romanji.put((long) (10^36), "kan");
//			// sei								-	10^40
//			// romanji.put((long) (10^40), "sei");
//			// sai								-	10^44
//			// romanji.put((long) (10^44), "sai");
//			// goku								-	10^48
//			// romanji.put((long) (10^48), "goku");
//			// gōgosha							-	10^52
//			// romanji.put((long) (10^52), "gōgosha");
//			// asōgi							-	10^56
//			// romanji.put((long) (10^56), "asōgi");
//			// nayuta							-	10^60
//			// romanji.put((long) (10^60), "nayuta");
//			// fukashigi						-	10^64
//			// romanji.put((long) (10^64), "fukashigi");
//			// muryōtaisū						-	10^68
//			// romanji.put((long) (10^68), "muryōtaisū");
//		
//	} // End of largeRomanjiMap method
	
} // End of romanjiConverter class
