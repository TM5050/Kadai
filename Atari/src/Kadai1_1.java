import java.util.Scanner;
public class Kadai1_1 {    // �N���X��`
    int jikiX, jikiY, jikiW, jikiH;  // ���@�� (x, y) �ƕ��ƍ����@��(x,y)�͉摜�̍���
    int tekiKazu; // �G�̌�
    int[] tekiX = new int[100]; // �G�� x���W
    int[] tekiY = new int[100]; // �G�� y���W
    int[] tekiW = new int[100]; // �G�� ��
    int[] tekiH = new int[100]; // �G�� ����

    public static void main(String[] args ) throws Exception {
        new Kadai1_1();
    }

    public Kadai1_1()  throws Exception {
        consoleKaraYomikomi();   // �R���\�[������l��ǂݍ���ŕϐ��ɑ��
//        hennsuuKakuninHyouji();  // �ϐ���������ꂽ���̃`�F�b�N�i�{�Ԃł̓R�����g�A�E�g���邱�Ɓj
        check();  // ������̔��菈���@���������ۑ�̃|�C���g�I
    }

    private void consoleKaraYomikomi() {
        try {
            Scanner sc = new Scanner(System.in); // �R���\�[�����͂̎w��

            jikiX = sc.nextInt(); // �󔒂�4�������ꂽ���@�� x, y, w, h ��
            jikiY = sc.nextInt(); // �R���\�[�����͂���
            jikiW = sc.nextInt(); // �ǂ݂����
            jikiH = sc.nextInt(); // �ϐ��ɑ������B

            tekiKazu = sc.nextInt(); // �G�̌���N�ɓǂ�
            for (int i = 0; i < tekiKazu; ++i) { // N��J��Ԃ���
                tekiX[i] = sc.nextInt();    // �R���\�[������ǂݍ��݁A
                tekiY[i] = sc.nextInt();    // �z��ϐ��ɑ������
                tekiW[i] = sc.nextInt();
                tekiH[i] = sc.nextInt();
            }
        } catch (Exception e) { // ��O�����i�ǂݍ��݃G���[�����j
            System.out.println(e.toString());
        }
    }

 //   private void hennsuuKakuninHyouji() {
        // �ϐ��ɑ���ł��Ă��邩���m�F����i�{�Ԃł͂��̃��\�b�h�Ăяo�����R�����g�A�E�g�ɂ��܂��傤�j
 //       System.out.println("�@�@X���W, Y���W, ��, ����");
 //       System.out.println(("���@ �F" + jikiX + ","  + jikiY + ","  + jikiW + ","  + jikiH));
 //       for (int i = 0; i < tekiKazu; ++i) {
 //          System.out.println(("�G�@" + (i+1) + "�F" + tekiX[i] + ","  + tekiY[i] + ","  + tekiW[i] + ","  + tekiH[i]));
 //      }
 //  }

    private void check() {
        for(int i = 0; i < tekiKazu; ++i) { // �G���ЂƂÂ`�F�b�N����
            boolean atariFlag = true; // �Ƃ肠�����u�������ĂȂ��v�ƃt���O�������Ă���

            // 1.�G�̍���̈ʒu�����@�摜�͈̔͂ɓ����Ă��邩�ǂ������`�F�b�N
            if ((jikiX + jikiW) < tekiX[i] || jikiX > (tekiX[i] + tekiW[i])
                    || jikiY > (tekiY[i] + tekiH[i]) || (jikiY + jikiH) < tekiY[i] ) {
                atariFlag = false;
            }

            // atariFlag�� true �ɕς���Ă����猋�ʂ�\������
            if (atariFlag) {
                System.out.println("�G�@" + (i+1) + "��������");
            }
            else {
                System.out.println("�G�@" + (i+1) + "�͓������Ă܂���B�Z�[�t�I");
            }
        }
    }
}
