package dao;

import org.apache.ibatis.annotations.Mapper;

import domain.Category;

/**   
 * @Description: TODO
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年7月31日 下午11:23:21 
 * @version V1.0   
 */
@Mapper
public interface CategoryDao {
	public Category getCategory(int id);
}
