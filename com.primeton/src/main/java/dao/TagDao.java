package dao;

import org.apache.ibatis.annotations.Mapper;

import domain.Tag;

/**   
 * @Description: TODO
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年7月31日 下午11:21:57 
 * @version V1.0   
 */
@Mapper
public interface TagDao {
	public Tag[] getTags(int id);
}
