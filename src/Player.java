import java.util.Random;

public class Player { 
	
	public void shareCard(int num) {
		
		System.out.println("플레이어가 카드 " + num + "장을 받았습니다.");
		
	}
	
	public void selectCard(int num) {
		
		System.out.println("플레이어가 카드 " + num + "장을 선택했습니다.");
		
	}
	
	public void openCard(int num) {
		
		System.out.println("플레이어가 상대에게 카드를 공개합니다.");
		System.out.println("상대의 카드는 [" + num +"] 입니다.");
		
	}
	
	public void dualGame(int num1, int num2) {

		System.out.println("인디언 포커 시작!");

	}

	public void dieGame(int num1, int num2) {

		System.out.println("인디언 포커 포기...");

	}

	public void exitGame() {

		System.out.println("\n인디언 포커를 종료합니다.\n");

	}

	public void restartGame() {

		System.out.println("\n인디언 포커를 다시 시작합니다.\n");

	}
	
}
