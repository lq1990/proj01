package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 每一行用Map存储，再把表示每行的Map存在List中
 * @author china
 *
 */
public class TestStoreTableData {
	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<String, Object>();
		row1.put("id", 1001);
		row1.put("name", "anna");
		row1.put("salary", 20000);
		row1.put("入职日期", "2018.5.5");
		
		Map<String, Object> row2 = new HashMap<String, Object>();
		row2.put("id", 1002);
		row2.put("name", "beta");
		row2.put("salary", 30000);
		row2.put("入职日期", "2010.6.5");
		
		
		Map<String, Object> row3 = new HashMap<String, Object>();
		row3.put("id", 1003);
		row3.put("name", "cello");
		row3.put("salary", 10000);
		row3.put("入职日期", "2000.5.8");
		
		List<Map<String,Object>> table = new ArrayList<>();
		
		table.add(row1);
		table.add(row2);
		table.add(row3);
		
		for(Map<String,Object> row: table) {
			Set<String> keyset = row.keySet();
			for(String key : keyset) {
				System.out.print(key + ": " + row.get(key)+"\t");
			}
			System.out.println();
		}
		
	}
}
