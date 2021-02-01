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
        cardYomu();        // �J�[�h�����R���\�[������ǂ݁A
        cardStringKaku();  // �J�[�h�̊G���Ɣԍ��������āA
        hanteiSuit();      // Suit�̎�ފi�[
        hanteiNum();		// Number�̎�ފi�[
        yakuhantei();      // ���𔻒肷��B
    }

    private void cardYomu() {
        try {
            Scanner sc = new Scanner(System.in); // �R���\�[������͌��Ƃ��Ďw��
            for (int i = 0; i < 5; ++i) {  // 5���̃J�[�h��ǂނ�
                suit[i] = sc.nextInt();   // �X�[�g�i�X�y�[�h��0�A�N���u��1�A�c�j��ǂ�ő��
                number[i] = sc.nextInt(); // �ԍ��i01�`13�j��ǂ�ő��
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
        // ���C����(�X�g���[�g)�t���b�V���I�I�I
        for(int a = 0; a < 4; ++a) {
        	if(suitCount[a] == 5) {
        		if (numCount[0] == 1 && numCount[9] == 1 && numCount[10] == 1 && numCount[11] == 1 && numCount[12] == 1) {
        		System.out.println("���C�����t���b�V��");
        		break;
        		}
        		// �X�g���[�g�t���b�V���@�t���b�V��
        		else {
            		for(int b = 0; numCount[b] == 1; ++b) {
            			if(numCount[b] == 1 && numCount[b + 1] == 1 && numCount[b + 2] == 1 && numCount[b + 3] == 1 && numCount[b + 4] == 1) {
            				System.out.println("�X�g���[�g�t���b�V��");
            				break;
            		}
            			else if(number[0] + number[1] + number[2] + number[3] + number[4] == 47) {System.out.println("�X�g���[�g�t���b�V��");break;}
            			else if(number[0] + number[1] + number[2] + number[3] + number[4] == 39) {System.out.println("�X�g���[�g�t���b�V��");break;}
            			else if(number[0] + number[1] + number[2] + number[3] + number[4] == 31) {System.out.println("�X�g���[�g�t���b�V��");break;}
            			else if(number[0] + number[1] + number[2] + number[3] + number[4] == 23) {System.out.println("�X�g���[�g�t���b�V��");break;}
            			else {System.out.println("�t���b�V��");break;}
        		}
        		}
        	}
        	else  {
        		for(int b = 0; b < 13; ++b){
        			//�t�H�[�J�[�h
        			if(numCount[b] == 4) {
        	            System.out.println("�t�H�[�J�[�h");
        	            break;
        				}
        			else if(numCount[b] == 3) {
        			for(int c = 0; c < 13; ++c) {
        					//�t���n�E�X
        					if(numCount[c] == 2) {
        					System.out.println("�t���n�E�X");
        					break;
        					}
        					//�X���[�J�[�h
        					else {
        						System.out.println("�X���[�J�[�h");
        						break;
        					}
        				}
        			}
        			//�c�[�J�[�h
        			else if(numCount[b] == 2) {
        				int d = 0;
        				for(int c = 0; c < 13; ++c) {
        					if(numCount[c] == 2) {
        						++d;
        					}
        				}
        				if(d == 2) {
        					System.out.println("�c�[�y�A");
        					break;
        				}
        				else {
        				System.out.println("�����y�A");
        				break;
        				}
        			}
        			//�u�^
        			else {
        				System.out.println("�u�^");
        				break;
        			}
        		}
        		}
        	break;
        }
    }
    }