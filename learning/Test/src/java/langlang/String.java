package java.langlang;

/**
 * 
 * 自定了 java.lang.String
 * 但是由于 类加载器采用的 “双亲委托机制”。
 * 当一级级追溯到 Bootstrap ClassLoader 时，由其加载 系统自带的 java.lang.String.
 * 保证了核心库的类型安全。
 * 
 * @author china
 *
 */
//public class String {
//	public String toString() {
//		return "my toString";
//	}
//}
