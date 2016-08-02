package service;

import dto.PetDto;

/**   
 * @Description: service接口类
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年7月27日 下午4:47:25 
 * @version V1.0   
 */

public interface PetService {
	
	public PetDto getPet(int id);
	
	public PetDto[] getPetAll();
	
	public String insertPet(PetDto dto);
	
	public String updatePet(PetDto dto);
	
	public String deletePet(int id);
	
}
