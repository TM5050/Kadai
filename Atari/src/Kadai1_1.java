import java.util.Scanner;
public class Kadai1_1 {    // クラス定義
    int jikiX, jikiY, jikiW, jikiH;  // 自機の (x, y) と幅と高さ　※(x,y)は画像の左上
    int tekiKazu; // 敵の個数
    int[] tekiX = new int[100]; // 敵の x座標
    int[] tekiY = new int[100]; // 敵の y座標
    int[] tekiW = new int[100]; // 敵の 幅
    int[] tekiH = new int[100]; // 敵の 高さ

    public static void main(String[] args ) throws Exception {
        new Kadai1_1();
    }

    public Kadai1_1()  throws Exception {
        consoleKaraYomikomi();   // コンソールから値を読み込んで変数に代入
//        hennsuuKakuninHyouji();  // 変数が代入されたかのチェック（本番ではコメントアウトすること）
        check();  // 当たりの判定処理　※ここが課題のポイント！
    }

    private void consoleKaraYomikomi() {
        try {
            Scanner sc = new Scanner(System.in); // コンソール入力の指定

            jikiX = sc.nextInt(); // 空白で4分割された自機の x, y, w, h を
            jikiY = sc.nextInt(); // コンソール入力から
            jikiW = sc.nextInt(); // 読みこんで
            jikiH = sc.nextInt(); // 変数に代入する。

            tekiKazu = sc.nextInt(); // 敵の個数をNに読む
            for (int i = 0; i < tekiKazu; ++i) { // N回繰り返して
                tekiX[i] = sc.nextInt();    // コンソールから読み込み、
                tekiY[i] = sc.nextInt();    // 配列変数に代入する
                tekiW[i] = sc.nextInt();
                tekiH[i] = sc.nextInt();
            }
        } catch (Exception e) { // 例外処理（読み込みエラー処理）
            System.out.println(e.toString());
        }
    }

 //   private void hennsuuKakuninHyouji() {
        // 変数に代入できているかを確認する（本番ではこのメソッド呼び出しをコメントアウトにしましょう）
 //       System.out.println("　　X座標, Y座標, 幅, 高さ");
 //       System.out.println(("自機 ：" + jikiX + ","  + jikiY + ","  + jikiW + ","  + jikiH));
 //       for (int i = 0; i < tekiKazu; ++i) {
 //          System.out.println(("敵機" + (i+1) + "：" + tekiX[i] + ","  + tekiY[i] + ","  + tekiW[i] + ","  + tekiH[i]));
 //      }
 //  }

    private void check() {
        for(int i = 0; i < tekiKazu; ++i) { // 敵をひとつづつチェックする
            boolean atariFlag = true; // とりあえず「当たってない」とフラグを下げておく

            // 1.敵の左上の位置が自機画像の範囲に入っているかどうかをチェック
            if ((jikiX + jikiW) < tekiX[i] || jikiX > (tekiX[i] + tekiW[i])
                    || jikiY > (tekiY[i] + tekiH[i]) || (jikiY + jikiH) < tekiY[i] ) {
                atariFlag = false;
            }

            // atariFlagが true に変わっていたら結果を表示する
            if (atariFlag) {
                System.out.println("敵機" + (i+1) + "が当たり");
            }
            else {
                System.out.println("敵機" + (i+1) + "は当たってません。セーフ！");
            }
        }
    }
}
