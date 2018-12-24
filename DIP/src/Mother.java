
public class Mother {
	public void read(IReader reader) {
		// 使其依赖 一个接口，而非具体的实现
		System.out.println("Mom is reading...");
		reader.getContent();
	}
}
