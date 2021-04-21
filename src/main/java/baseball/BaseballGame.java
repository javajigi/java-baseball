package baseball;

import java.util.Scanner;

public class BaseballGame {

  public int[] makeBall(int a, int start, int end, boolean flag) {
	  int[] resultBall = null;
	  if(flag) {
			while (true) {
				int[] tmp = makeBall(a, start, end);
				if (arrayCheck(tmp)) {
					System.out.println("배열이 중복되었습니다");
				} else {
					resultBall = tmp.clone();
					break;
				} 
			} 
	  }else {
		  int[] tmp = makeBall(a, start, end);
		  resultBall = tmp.clone();
	  }
	  return resultBall;
  }
	
	
	
  public int[] makeBall(int a, int start, int end) {
	int[] ball = new int[a];
	int cnt = 0;
	
	while (true) {
		try {
			System.out.println((cnt + 1)+"번째 숫자를 입력해 주세요");
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			if(n>= start && n<= end) {
				ball[cnt++] = n;
			}else {
				System.out.println("값의 범위를 벗어났습니다");
			}
			
			
			if(cnt>=a) {
				break;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//			e1.printStackTrace();
			System.out.println(e1+"\n 잘못된 형식으로 입력하셨습니다.");
		}
	}
	return ball;
  }
  
  private boolean arrayCheck(int[] chk) {
	  boolean isc= false;
	  for(int i = 0; i <chk.length; i++) {
		  for(int j = 0; j <chk.length; j++) {
			  if(i!=j && chk[i] == chk[j]) {
				  isc = true;
				  break;
			  }
		  }  
	  }
	  return isc;
  }
  
  
}
