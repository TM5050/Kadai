import java.util.Scanner;
public class Kadai2_1 {
    static String[] SUIT_STRING = {"S", "C", "D", "H"};
    static String[] NUMBER_STRING = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private int[] suit = new int[5];
    private int[] number = new int[5];

    private int[] suitCount = { 0, 0, 0, 0 };
    private int[] numCount = new int[13];

    public static void main(String[] args) {
        new Kadai2_1();
    }

    public Kadai2_1() {
        cardYomu();        // カード情報をコンソールから読み、
        cardStringKaku();  // カードの絵柄と番号を書いて、
        hanteiSuit();      // Suitの種類格納
        hanteiNum();		// Numberの種類格納
        yakuhantei();      // 役を判定する。
    }

    private void cardYomu() {
        try {
            Scanner sc = new Scanner(System.in); // コンソールを入力元として指定
            for (int i = 0; i < 5; ++i) {  // 5枚のカードを読むよ
                suit[i] = sc.nextInt();   // スート（スペードが0、クラブが1、…）を読んで代入
                number[i] = sc.nextInt(); // 番号（01～13）を読んで代入
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void hanteiSuit() {
        for (int i = 0; i < 5; ++i) {
            suitCount[ suit[i] ] += 1;
        }
    }
    private void hanteiNum() {
        for (int i = 0; i < 5; ++i) {
            numCount[ number[i] - 1 ] += 1;
        }
    }

    private void cardStringKaku() {
        for (int i = 0; i < 4; ++i) {
            System.out.print(SUIT_STRING[suit[i]] + NUMBER_STRING[number[i] - 1] + " ");
        }
        System.out.println(SUIT_STRING[suit[4]] + NUMBER_STRING[number[4] - 1]);
    }

    private void yakuhantei() {
        // ロイヤル(ストレート)フラッシュ！！！
        for(int a = 0; a < 4; ++a) {
        	if(suitCount[a] == 5) {
        		if (numCount[0] == 1 && numCount[9] == 1 && numCount[10] == 1 && numCount[11] == 1 && numCount[12] == 1) {
        		System.out.println("ロイヤルフラッシュ");
        		break;
        		}
        		// ストレートフラッシュ　フラッシュ
        		else {
            		for(int b = 0; numCount[b] == 1; ++b) {
            			if(numCount[b] == 1 && numCount[b + 1] == 1 && numCount[b + 2] == 1 && numCount[b + 3] == 1 && numCount[b + 4] == 1) {
            				System.out.println("ストレートフラッシュ");
            				break;
            		}
            			else if(number[0] + number[1] + number[2] + number[3] + number[4] == 47) {System.out.println("ストレートフラッシュ");break;}
            			else if(number[0] + number[1] + number[2] + number[3] + number[4] == 39) {System.out.println("ストレートフラッシュ");break;}
            			else if(number[0] + number[1] + number[2] + number[3] + number[4] == 31) {System.out.println("ストレートフラッシュ");break;}
            			else if(number[0] + number[1] + number[2] + number[3] + number[4] == 23) {System.out.println("ストレートフラッシュ");break;}
            			else {System.out.println("フラッシュ");break;}
        		}
        		}
        	}
        	else  {
        		for(int b = 0; b < 13; ++b){
        			//フォーカード
        			if(numCount[b] == 4) {
        	            System.out.println("フォーカード");
        	            break;
        				}
        			else if(numCount[b] == 3) {
        			for(int c = 0; c < 13; ++c) {
        					//フルハウス
        					if(numCount[c] == 2) {
        					System.out.println("フルハウス");
        					break;
        					}
        					//スリーカード
        					else {
        						System.out.println("スリーカード");
        						break;
        					}
        				}
        			}
        			//ツーカード
        			else if(numCount[b] == 2) {
        				int d = 0;
        				for(int c = 0; c < 13; ++c) {
        					if(numCount[c] == 2) {
        						++d;
        					}
        				}
        				if(d == 2) {
        					System.out.println("ツーペア");
        					break;
        				}
        				else {
        				System.out.println("ワンペア");
        				break;
        				}
        			}
        			//ブタ
        			else {
        				System.out.println("ブタ");
        				break;
        			}
        		}
        		}
        	break;
        }
    }
    }