package com.wendao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wendao.pojo.Menu;

public interface MenuMapper {

	// Results中，查询出来一个menu后，将它的id作为 下一个sql的pid进行递归查询出来 所有的menus
	@Results(value= {
			@Result(id=true, property="id", column="id"),
			@Result(property="name", column="name"),
			@Result(property="pid", column="pid"),
			@Result(property="children", many=@Many(select="selByPid"), column="{uid=uid, pid=id}"),
	})
	@Select("select *, #{uid} uid from menu where id in (select mid from users_menu where uid=#{uid}) and pid=#{pid}")
	List<Menu> selByPid(Map<String, Object> map);// pid是查看几级菜单

	
	
	
}
