package serviceImpl;

public class TestServiceImpl {
public static void main(String[] args) {
	
	// flag test
	boolean flag = true;
	System.out.println("실행 결과:" + ((flag) ? "등록 성공" : "등록 실패"));
	
	// length vs size
	int[] str = {10, 20, 30, 0, 0};
	System.out.println(str.length);
}
}
