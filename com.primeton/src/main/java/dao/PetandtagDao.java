package dao;

import org.apache.ibatis.annotations.Mapper;

import domain.Petandtag;

/**   
 * @Description: TODO
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年8月1日 上午10:18:08 
 * @version V1.0   
 */
@Mapper
public interface PetandtagDao {
	
	public void insertPetandtag(Petandtag petandtag);
	
	public void deletePetandtag(int id);
	
}
