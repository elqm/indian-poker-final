import java.util.Random;
import java.util.Scanner;

public class Dealer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Player user1 = new User1();
		Player user2 = new User2();
		Random ranCard = new Random();

		CardDTO[] cards = new CardDTO[10];
		cards[0] = new CardDTO(1);
		cards[1] = new CardDTO(2);
		cards[2] = new CardDTO(3);
		cards[3] = new CardDTO(4);
		cards[4] = new CardDTO(5);
		cards[5] = new CardDTO(6);
		cards[6] = new CardDTO(7);
		cards[7] = new CardDTO(8);
		cards[8] = new CardDTO(9);
		cards[9] = new CardDTO(10);
		
		/* 카드 장수 및 카드 중복 배분 방지 카운트 */
		int shareCount = 0;
		
		/* 카드 중복 선택 방지 카운트 */
		int selectCount = 0;
		
		/* 카드 중복 공개 방지 카운트 */
		int openCount = 0;
		
		/* 중복 승부 방지 카운트 */ 
		int dualCount = 0;
		
		/* 중복 포기 방지 카운트 */
		int dieCount = 0;
		
		/* 선택한 랜덤 카드 변수 */
		int user1Card = 0;
		int user2Card = 0;
		
		while(true) {
			System.out.println("======= 인디언 포커 =======");
			System.out.println("1. 카드 배분");
			System.out.println("2. 카드 선택");
			System.out.println("3. 카드 공개");
			System.out.println("4. 인디언 포커 승부(Dual)");
			System.out.println("5. 인디언 포커 포기(Die)");
			System.out.println("9. 게임 재시작");
			System.out.println("0. 게임 종료");
			System.out.println("========================");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 :
				if(shareCount != 0) {
					System.out.println("\n[이미 카드 " + shareCount + "장을 받았습니다.]\n");
				} else {
					for(int i = 0; i < cards.length; i++) {
						++shareCount;
					}
					user1.shareCard(shareCount);
					user2.shareCard(shareCount);
				}
				break;
			case 2 :
				if(shareCount == 0) {
					System.out.println("\n[아직 카드를 받지 않았습니다.]\n");
				} else if(user1Card == 0 && shareCount == 10) {
					user1Card = (int) cards[ranCard.nextInt(10)].getCardNum();
					user2Card = (int) cards[ranCard.nextInt(10)].getCardNum();
					++selectCount;
					user1.selectCard(selectCount);
					user2.selectCard(selectCount);
				} else {
					System.out.println("\n[이미 카드를 선택했습니다.]\n");
				}

				break;
			case 3 :
				if(shareCount == 0) {
					System.out.println("\n[아직 카드를 받지 않았습니다.]\n");
				} else if(selectCount == 0) {
					System.out.println("\n[아직 카드를 선택하지 않았습니다.]\n");
				} else if(openCount == 0) {
					user1.openCard(user1Card);
					user2.openCard(user2Card);
					++openCount;
				} else if(openCount == 1) {
					System.out.println("\n[이미 카드를 공개했습니다.]\n");
				}
				break;
			case 4 :
				if(shareCount == 0) {
					System.out.println("\n[아직 카드를 받지 않았습니다.]\n");
				} else if(selectCount == 0) {
					System.out.println("\n[아직 카드를 선택하지 않았습니다.]\n");
				} else if(openCount == 0) {
					System.out.println("\n[아직 카드를 공개하지 않았습니다.]\n");
				} else if(dualCount == 0 && dieCount == 0) {
					user1.dualGame(user1Card, user2Card);
					++dualCount;
				} else if(dualCount == 1 && dieCount == 0) {
					System.out.println("\n[이미 승부를 겨루었습니다.]\n");
				} else if(dualCount == 0 && dieCount == 1) {
					System.out.println("\n[이미 승부를 포기했습니다.]\n");
				}
				break;
			case 5 :
				if(shareCount == 0) {
					System.out.println("\n[아직 카드를 받지 않았습니다.]\n");
				} else if(selectCount == 0) {
					System.out.println("\n[아직 카드를 선택하지 않았습니다.]\n");
				} else if(openCount == 0) {
					System.out.println("\n[아직 카드를 공개하지 않았습니다.]\n");
				} else if(dualCount == 1) {
					System.out.println("\n[이미 승부를 겨루었습니다.]\n");
				} else if(dieCount == 0 && dualCount == 0) {
					user1.dieGame(user1Card, user2Card);
					++dieCount;
				} else if(dualCount == 1 && dieCount == 0) {
					System.out.println("\n[이미 승부를 겨루었습니다.]\n");
				} else if(dieCount == 1 && dualCount == 0) {
					System.out.println("\n[이미 승부를 포기했습니다.]\n");
				}
				break;
			case 9 :
				shareCount = 0;
				selectCount = 0;
				openCount = 0;
				dualCount = 0;
				dieCount = 0;
				user1Card = 0;
				user2Card = 0;
				user1.restartGame();
				break;
			case 0 :
				user1.exitGame();
				return;
			default :
				System.out.println("\n[잘못된 번호를 선택하셨습니다.]\n");
				break;
			}
			
		}
		
	}
	
}
