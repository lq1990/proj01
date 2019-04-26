/**
  *    带标签的break,continue
 * 
 * @author china
 *
 */
public class TestLabelContinue {
	public static void main(String[] args) {
		outer: for(int i=101; i<150;i++) {
			for(int j=2;j<i/2;j++) {
				if(i%j==0) {
					continue outer; // 使得外层循环 被 continue
				}
			}
			System.out.println(i + " "); // 当不被 continue时，才打印
		}
	}
}
