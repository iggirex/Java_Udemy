package moreCollectionsPractice;

import java.util.LinkedList;

public class LinkedListUtil {
	
//	public static int makeGoodLL;
//	public static int makeGoodGenericLL;

	public static LinkedList makeLinkedList(String str1, boolean isIt, int num) {
		
		LinkedList result = new LinkedList();
//		
//		result[1] = str1;
//		boolean result[2] = isIt;
		
//		result.linkFirst("hey");
		
		result.add(1);
		result.add("2");
		result.add(true);
		result.add(2.2);
		result.add(new LinkedList());
		
		return result;
		
	}
	
	
	public static class ListNode {
		private int data;
		private ListNode next;
	
		public ListNode (int data) {
			this.data = data;
			this.next = null;
		}
		
	}

	
	
	public static LinkedList<?> makeLLFromScratch(int num){
		
		ListNode head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(50);
		ListNode fourth = new ListNode(11);
		
		head.next = second;
		second.next = third;
		third.next = fourth;
		
		
		LinkedList<?> result = new LinkedList<>();
		
		return result;
	}
	
	public static LinkedList<String> makeGoodLL(String str1, String str2, String str3){
		
		LinkedList<String> result = new LinkedList<>();
		
		result.add(str1);
		result.add(str2);
		result.add(str3);
		
		return result;
	}
	
	
	public static <E> LinkedList<E> makeGoodGenericLL(E thing1, E thing2){
		
		LinkedList<E> result = new LinkedList<E>();
		
		result.add(thing1);
		result.add(thing2);
		
		return result;
	}

	
	
}
