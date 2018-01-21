package com.src;

public class PatternFinder {
	
	private long[] noOfSameElements;
	private ObjType[] objType;
	private String[][] splitArray;
	
	public PatternFinder(int size){
		splitArray = new String[size][];
	}
	
	public void splitInputArray(int noOfSpaces){
		for(int i = 0 ; i < splitArray.length ; i++){
			splitArray[i] = new String[ noOfSpaces + 1 ];
		}
		noOfSameElements = new long[noOfSpaces + 1];
		objType = new ObjType[noOfSpaces + 1];
	}
	
	public long[] getNoOfSameElements() {
		return noOfSameElements;
	}

	public ObjType[] getObjType() {
		return objType;
	}
	
	public void setObjTypeAt(int i, ObjType type){
		objType[i] = type;
	}
	
	public void setNoOfElementsAt(int i, long noOfElements){
		noOfSameElements[i] = noOfElements;
	}

	//Only Works for a certain formats of Date...and Case Insensitive
	//Formats are DD-(/)MON-(/)YY and DD-(/)MM-(/)YY and YYYY-(/)MM-(/)DD
	private boolean isDate(String input){
		int size = input.length();
		
		try{
			if(input.charAt(size-3) == input.charAt(2) && input.charAt(2) == '-' || input.charAt(2) == '/'){
				try{
					//DD-MON-YY
					if(size == 9){
						if(input.substring(3, 6).toUpperCase().equals("JAN") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 6).toUpperCase().equals("FEB") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 28 && Integer.parseInt(input.substring(size-2, size)) > 0 && Integer.parseInt(input.substring(size-2, size)) % 4 != 0 ||
								input.substring(3, 6).toUpperCase().equals("FEB") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 29 && Integer.parseInt(input.substring(size-2, size)) > 0 && Integer.parseInt(input.substring(size-2, size)) % 4 == 0 ||		
								input.substring(3, 6).toUpperCase().equals("MAR") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 6).toUpperCase().equals("APR") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
								input.substring(3, 6).toUpperCase().equals("MAY") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 6).toUpperCase().equals("JUN") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
								input.substring(3, 6).toUpperCase().equals("JUL") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 6).toUpperCase().equals("AUG") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 6).toUpperCase().equals("SEP") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
								input.substring(3, 6).toUpperCase().equals("OCT") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 6).toUpperCase().equals("NOV") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
								input.substring(3, 6).toUpperCase().equals("DEC") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ){
							return true;
						}
						else{
							return false;
						}
					}
					//DD-MM-YY
					else if (size == 8){
						if(input.substring(3, 5).toUpperCase().equals("01") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 5).toUpperCase().equals("02") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 28 && Integer.parseInt(input.substring(size-2, size)) > 0 && Integer.parseInt(input.substring(size-2, size)) % 4 != 0 ||
								input.substring(3, 5).toUpperCase().equals("02") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 29 && Integer.parseInt(input.substring(size-2, size)) > 0 && Integer.parseInt(input.substring(size-2, size)) % 4 == 0 ||		
								input.substring(3, 5).toUpperCase().equals("03") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 5).toUpperCase().equals("04") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
								input.substring(3, 5).toUpperCase().equals("05") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 5).toUpperCase().equals("06") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
								input.substring(3, 5).toUpperCase().equals("07") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 5).toUpperCase().equals("08") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 5).toUpperCase().equals("09") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
								input.substring(3, 5).toUpperCase().equals("10") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
								input.substring(3, 5).toUpperCase().equals("11") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
								input.substring(3, 5).toUpperCase().equals("12") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ){
							return true;
						}
						else{
							return false;
						}
					}
					else{
						return false;
					}
				}
				catch (NumberFormatException e) {
					return false;
				}
			}
			else if(size == 10){
				if(input.charAt(size-3) == input.charAt(4) && input.charAt(size-3) == '-' || input.charAt(size-3) == '/'){
					if(input.substring(5, 7).toUpperCase().equals("01") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 31 ||
							input.substring(5, 7).toUpperCase().equals("02") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 28 && Integer.parseInt(input.substring(0, 4)) > 0 && Integer.parseInt(input.substring(0, 4)) % 4 != 0 ||
							input.substring(5, 7).toUpperCase().equals("02") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 29 && Integer.parseInt(input.substring(0, 4)) > 0 && Integer.parseInt(input.substring(0, 4)) % 4 == 0 ||		
							input.substring(5, 7).toUpperCase().equals("03") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 31 ||
							input.substring(5, 7).toUpperCase().equals("04") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 30 ||
							input.substring(5, 7).toUpperCase().equals("05") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 31 ||
							input.substring(5, 7).toUpperCase().equals("06") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 30 ||
							input.substring(5, 7).toUpperCase().equals("07") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 31 ||
							input.substring(5, 7).toUpperCase().equals("08") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 31 ||
							input.substring(5, 7).toUpperCase().equals("09") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 30 ||
							input.substring(5, 7).toUpperCase().equals("10") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 31 ||
							input.substring(5, 7).toUpperCase().equals("11") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 30 ||
							input.substring(5, 7).toUpperCase().equals("12") && Integer.parseInt(input.substring(size - 2, size)) > 0 && Integer.parseInt(input.substring(size - 2, size)) <= 31 ){
						return true;
					}
					else{
						return false;
					}
				}
				else if(input.charAt(size-5) == input.charAt(2) && input.charAt(size-5) == '-' || input.charAt(size-5) == '/'){
					if(input.substring(3, 5).toUpperCase().equals("01") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
							input.substring(3, 5).toUpperCase().equals("02") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 28 && Integer.parseInt(input.substring(size - 4, size)) > 0 && Integer.parseInt(input.substring(size - 4, size)) % 4 != 0 ||
							input.substring(3, 5).toUpperCase().equals("02") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 29 && Integer.parseInt(input.substring(size - 4, size)) > 0 && Integer.parseInt(input.substring(size - 4, size)) % 4 == 0 ||		
							input.substring(3, 5).toUpperCase().equals("03") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
							input.substring(3, 5).toUpperCase().equals("04") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
							input.substring(3, 5).toUpperCase().equals("05") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
							input.substring(3, 5).toUpperCase().equals("06") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
							input.substring(3, 5).toUpperCase().equals("07") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
							input.substring(3, 5).toUpperCase().equals("08") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
							input.substring(3, 5).toUpperCase().equals("09") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
							input.substring(3, 5).toUpperCase().equals("10") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ||
							input.substring(3, 5).toUpperCase().equals("11") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 30 ||
							input.substring(3, 5).toUpperCase().equals("12") && Integer.parseInt(input.substring(0, 2)) > 0 && Integer.parseInt(input.substring(0, 2)) <= 31 ){
						return true;
					}
					else{
						return false;
					}
				}
			}
			else{
				return false;
			}
		}
		catch(StringIndexOutOfBoundsException e){
			return false;
		}
		
		return false;
	}
	
	private boolean isTime(String input){
		int size = input.length();
		
		try{
			if(input.charAt(size-3) == input.charAt(2) && input.charAt(2) == ':'){
				try{
					if (size == 8){
							if(Integer.parseInt(input.substring(0, 2)) <= 23 && 
									Integer.parseInt(input.substring(3, 5)) <= 59 &&
									Integer.parseInt(input.substring(6, 8)) <= 59){
								return true;
						}
						else{
							return false;
						}
					}
					else{
						return false;
					}
				}
				catch (NumberFormatException e) {
					return false;
				}
			}
		}
		catch(StringIndexOutOfBoundsException e){
			return false;
		}
		
		return false;
	}
	
	private ObjType getType(Object o){
		if(o instanceof String){
			String s = o.toString();
			if(isTime(s)){
				return ObjType.TIME;
			}
			else if(isDate(s)){
				return ObjType.DATE;
			}
			else{
				try{
					Double testNum = Double.parseDouble(s);
					return ObjType.NUMBER;
				}
				catch(NumberFormatException e){
					return ObjType.WORD;
				}
			}
		}
		else{
			return ObjType.UNDEFINED;
		}
	}
	
	private void populate(String[] inputArray, int count){
		
		int noOfSpaces = inputArray[0].split(" ").length - 1;
		
		for (int i = 1 ; inputArray[i] != null && i < inputArray.length ; i++){
			if((inputArray[i].split(" ").length - 1) > noOfSpaces){
				noOfSpaces = inputArray[i].split(" ").length - 1;
			}
		}
		
		splitInputArray(noOfSpaces);
		
		for(int i = 0 ; i < count ; i++){
			for(int j = 0 ; j < splitArray[i].length ; j++){
				splitArray[i] = inputArray[i].split(" ");
			}
		}		
		for(int i = 1 ; i < count ; i++){
			for(int j = 0 ; j < splitArray[i].length && splitArray[i][j] != null ; j++){
				//System.out.println(i + " " + j);
				if( j < splitArray[i-1].length && splitArray[i][j].equals(splitArray[i-1][j])){
					noOfSameElements[j] ++;
				}
				objType[j] = getType(splitArray[i][j]);
			}
		}
	}
	
	public String findPattern(String[] arr, int count){
		
		populate(arr, count);
		
		String[] result = new String[objType.length];
		
		for(int i = 0 ; i < objType.length ; i++){
			if(noOfSameElements[i] == count - 1){
				 result[i] = splitArray[0][i];
			}
			else{
				result[i] = objType[i].toString();
			}
		}
		
		String res[] = new String[(2 * result.length) + 1];
		int index = 0;
		int countConst = 1;
		int countVar = 1;
		
		String constElement = "";
		
		for(int i = 0 ; i < result.length ; i++){
			if(result[i].equals("WORD") || result[i].equals("NUMBER") || result[i].equals("DATE") || result[i].equals("TIME")){
				if(i > 0){
					res[index ++] = constElement;
					constElement = "";
				}
				//System.out.println(i);
				res[index ++] = "Variable " + (countVar ++) + ": " + result[i];
			}
			else{
				if(i > 0){
					if(index > 0 && res[index - 1].equals("Constant "+ (countConst - 1) + ": ")){
						constElement += result[i] + " ";
					}
					else if (index > 0 && res[index - 1].equals("Variable " + (countVar - 1) + ": " + result[i-1])){
						res[index ++] = "Constant "+ (countConst ++) + ": ";
						constElement += result[i] + " ";
					}
					else{
						constElement += result[i] + " ";
					}
				}
				else{
					res[index ++] = "Constant "+ (countConst ++) + ": ";
					constElement += result[i] + " ";
				}
			}
		}
		
		String output = "";
		for(int i = 0 ; i < res.length && res[i] != null ; i++){
			if(res[i].matches("Constant \\d+: ")){
				output += res[i];
			}
			else{
				output += res[i] + "\n";
			}
		}
		return output;
	}
	
	public void testMethods(String s){
		System.out.println(getType(s));
	}
}
