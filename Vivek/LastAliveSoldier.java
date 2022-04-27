import java.util.*;

// There are 99 soldiers standing on circumference of circle and they are numbered 1 to 99.
// Soldier 1 is given the sword. 
// Now a soldier will kill the soldier next to it and pass the sword to next soldier goes on
// find out the last alive soldier

class LastAliveSoldier {
    public static void main(String args []) {
        List<Integer> list = new ArrayList<>();//soldiers 1-99
		for(int i = 1; i <= 99; i++) {
		    list.add(i);
		}
		
		boolean isLastSoldierHavingSword = false; 
		
		while(list.size()>1) {//if more than one soldiers
		
		    List<Integer> tempList = new ArrayList<>();//take live soldiers in it
		    
		    for(int i = isLastSoldierHavingSword ? 1 : 0; i < list.size(); i = i+2) {
		        tempList.add(list.get(i));
		        System.out.print(" "+list.get(i));
		        //if last soldier is not killed
		        isLastSoldierHavingSword = i == list.size() - 1;
		    }
		    
		    list = tempList;//
		    System.out.println();
		}
		System.out.println("Last Alive Soldier: "+list.get(0));
    }
}
// Output:
// 1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31 33 35 37 39 41 43 45 47 49 51 53 55 57 59 61 63 65 67 69 71 73 75 77 79 81 83 85 87 89 91 93 95 97 99
// 3 7 11 15 19 23 27 31 35 39 43 47 51 55 59 63 67 71 75 79 83 87 91 95 99
// 7 15 23 31 39 47 55 63 71 79 87 95
// 7 23 39 55 71 87
// 7 39 71
// 7 71
// 71
// Last Alive Soldier: 71

