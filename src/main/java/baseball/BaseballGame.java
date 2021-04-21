package baseball;

import java.util.Scanner;

public class BaseballGame {

  public int[] makeBall(int a, int start, int end, boolean flag) {
	  int[] resultBall = null;
	  if(flag) {
			while (true) {
				int[] tmp = makeBall(a, start, end);
				if (arrayCheck(tmp)) {
					System.out.println("�迭�� �ߺ��Ǿ����ϴ�");
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
			System.out.println((cnt + 1)+"��° ���ڸ� �Է��� �ּ���");
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			if(n>= start && n<= end) {
				ball[cnt++] = n;
			}else {
				System.out.println("���� ������ ������ϴ�");
			}
			
			
			if(cnt>=a) {
				break;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//			e1.printStackTrace();
			System.out.println(e1+"\n �߸��� �������� �Է��ϼ̽��ϴ�.");
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
