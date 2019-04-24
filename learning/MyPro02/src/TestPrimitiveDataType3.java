/**
 * test char and boolean
 * @author china
 *
 */
public class TestPrimitiveDataType3 {
	public static void main(String[] args) {

		char a= 'T';
		char b = '商';
		char c = '\u0061';
		
		//System.out.println(c);
		System.out.println('a'+'b'); // 字符代表的数字 进行相加
		System.out.println(""+'a'+'\n'+'b');
		System.out.println(""+'a'+'\t'+'b');
		System.out.println(""+'a'+'\''+'b');

		String d = "abc";
		System.out.println(d);
		
		// test boolean
		boolean man = true;
		if (true==man) {
			System.out.println("male");
		}
		
	}
}
