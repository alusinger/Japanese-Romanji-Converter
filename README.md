# Japanese-Romanji-Converter
Takes a positive integer and transliterates it to the romanji version of that number. 

Notes on the Romanji:

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
