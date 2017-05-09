package Demo1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
public class TestDDJ {
	public static ArrayList<Integer> list = new ArrayList<>();
	public static HashMap<Integer, String> map= new HashMap<>();
	static {
		String[] hs={"♠","♥","♣","♦"};
		String[] ds={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
		String dw="大☺";
		String xw="小☺";
		map.put(1, dw);
		map.put(2, xw);
		list.add(1);
		list.add(2);
		int count=3;
		for (String s1 : ds) {
			for (String s2 : hs) {
				list.add(count);
				map.put(count++, s1+s2);
			}
		}
		Collections.shuffle(list);
		System.out.println(list.toString());
		System.out.println(map);
		
	}
	public static void main(String[] args) {
		
//		facard();
		ArrayList<Integer> wan3= fa();
		System.out.println(wan3.toString());
		
		
	}
	private static ArrayList<Integer> fa() {
		ArrayList<Integer> card= new ArrayList<>();
		for (int i = 0; i < 17; i++) {
			card.add(list.remove(0));
	}
		return card;
	}
	private static void facard() {
		// key 值存一个集合 创建三个晚间分别存入指定的值
		
		
		
		ArrayList<Integer> arr=new ArrayList<>();
		ArrayList<Integer> arr1=new ArrayList<>();
		ArrayList<Integer> arr2=new ArrayList<>();
		//根据 键值  去除 map 集合 中的 value值 存入新 的集合。这是三个玩家手中的牌
		ArrayList<String> wan1=new ArrayList<>();
		ArrayList<String> wan2=new ArrayList<>();
		ArrayList<String> wan3=new ArrayList<>();
		// 最后三张底牌；
		ArrayList<String> di=new ArrayList<>();
		
			Random r = new Random();
		int j;
		while(true){
			j = r.nextInt(list.size()-3);
			boolean flge=false;
			if(j!=list.get(53)||j!=list.get(52)||j!=list.get(51)){
				flge=true;
			}
			if(flge){
				break;
				
			}
			}
		System.out.println(map.get(list.get(j)));
		for (int i = 0; i < list.size()-3; i++) {
			if(i%3==1){
				arr.add(list.get(i));
			}else if(i%3==2){
				arr1.add(list.get(i));
			}else if(i%3==0){
				arr2.add(list.get(i));
			}
		}
		Collections.sort(arr);
		Collections.sort(arr1);
		Collections.sort(arr2);
		for (int i = 0; i < arr.size(); i++) {
			wan1.add(map.get(arr.get(i)));
		}
		for (int i = 0; i < arr1.size(); i++) {
			wan2.add(map.get(arr1.get(i)));
		}
		for (int i = 0; i < arr2.size(); i++) {
			wan3.add(map.get(arr2.get(i)));
		}
		di.add(map.get(list.get(53)));
		di.add(map.get(list.get(52)));
		di.add(map.get(list.get(51)));
		
		if(wan1.contains(map.get(list.get(j)))){
			System.out.println("玩家1你是地主！");
			for (int i = 0; i < di.size(); i++) {
				wan1.add(di.get(i));
			}
		}else if(wan2.contains(map.get(list.get(j)))){
			System.out.println("玩家2你是地主！");
			for (int i = 0; i < di.size(); i++) {
				wan2.add(di.get(i));
			}
		}else if(wan3.contains(map.get(list.get(j)))){
			System.out.println("玩家3你是地主！");
			for (int i = 0; i < di.size(); i++) {
				wan3.add(di.get(i));
			}
		}
		System.out.println(wan1.toString());
		System.out.println(wan2.toString());
		System.out.println(wan3.toString());
		System.out.println(di.toString());
		
	}
	
}
