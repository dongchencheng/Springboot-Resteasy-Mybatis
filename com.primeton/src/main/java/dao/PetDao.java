package dao;

import org.apache.ibatis.annotations.Mapper;

import domain.Pet;

/**   
 * @Description: dao类
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年7月29日 上午9:34:51 
 * @version V1.0   
 */
@Mapper
public interface PetDao {
	
	public Pet getPet(int id);
	
	public Pet[] getPetAll();
	
	public void insertPet(Pet pet);
	
	public void updatePet(Pet pet);
	
	public void deletePet(int id);
	
}
