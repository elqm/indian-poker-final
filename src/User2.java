import java.util.Random;

public class User2 extends Player { 
	
	@Override
	public void shareCard(int num2) {
		
		System.out.println("[유저2(상대)가 카드 " + num2 + "장을 받았습니다.]\n");
	}
	
	@Override
	public void selectCard(int num) {
		
		System.out.println("[유저2(상대)가 카드 " + num + "장을 선택했습니다.]\n");
		
	}
	
	@Override
	public void openCard(int num2) {
		
		System.out.println("[유저2(상대)가 유저1(나)에게 카드를 공개합니다.]");
		System.out.println("[유저2(상대)의 카드는 [" + num2 +"] 입니다.]\n");

	}
	
}
