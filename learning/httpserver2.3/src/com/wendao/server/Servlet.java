package com.wendao.server;

/**
 * 
 * Servlet功能和jsp一样。
 * 
 * 服务器小脚本。
 * 只关注req res
 * 
 * 而底层的socket不关注
 * 
 * @author china
 *
 */
public interface Servlet {
	void service(Request req, Response res);
}
