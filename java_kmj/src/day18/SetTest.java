package day18;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		/* Set 메소드 예제*/
		HashSet<Integer> set = new HashSet<Integer>();//비교를 equals()로 해야하는데 기본타입은 equals()를 지원하지 않음 
		//add(객체) : set에 객체를 추가//순서를 고정하지 않음. 번지로 접근하지 않음 => 때문에 add(번지, 객체)는 없다 
		set.add(10);
		set.add(10);
		set.add(11);
		set.add(20);
		set.add(23);
		set.add(11);
		set.add(90);
		//size() : set의 크기
		System.out.println("set의 크기 : " + set.size());//=> set.size 값은 1 => 중복을 허용하지 않기 때문에
		//contains(객체) : 객체가 있는지 없는지 확인
		//indexOf =>없음 번지랑 관련된 기능은 set에 없다. 지원하지 않음 => 번지를 지정하지 않기 때문에
		System.out.println("set에 10이 있습니까? " + set.contains(10));
		System.out.println("set에 11이 있습니까? " + set.contains(11));
		//isEmpty() : set이 비었는지 아닌지 확인
		System.out.println("set이 비어있습니까? " +set.isEmpty());
		
		Iterator<Integer>it = set.iterator();//번지가 없기 때문에 set에서 반복을 사용하려면 Iterator객체를 만들어 줘야함 
		while(it.hasNext()) {//hasNext() : 다음에 선택할 객체가 있는지 없는지 알려주는 메소드
			Integer tmp = /*(Integer)*/it.next();//생략 가능 //it.next() : set에 있는 값 하나를 가져옴
			System.out.print(tmp + " ");//결과가 입력순서대로 안나옴
		}
		System.out.println();
		//remove(객체) :객체와 일치하는 내용을 삭제하고 성공 여부를 알림
		System.out.println("set에 10의 값이 삭제 되었습니까? " + set.remove(10));
		System.out.println("set에 10의 값이 삭제 되었습니까? " + set.remove(10));
		//clear() :비움
		set.clear();
		System.out.println("set의 크기 : " + set.size());
		
	}

}
