package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.CategoryDao;
import dao.PetDao;
import dao.PetandtagDao;
import dao.TagDao;
import domain.Pet;
import domain.Petandtag;
import domain.Tag;
import dto.PetDto;
import service.PetService;

/**   
 * @Description: service实现类
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年7月29日 上午9:19:44 
 * @version V1.0   
 */
public class PetServiceImpl implements PetService{

	@Autowired
	PetDao petDao;
	@Autowired
	TagDao tagDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	PetandtagDao petandtagDao;

	@Override
	public PetDto getPet(int id) {
		
		//通过id查到宠物信息
		Pet pet = petDao.getPet(id);
		
		PetDto dto = new PetDto();
		dto.setId(id);
		//查找category信息
		dto.setCategory(categoryDao.getCategory(pet.getIdCategory()));
		dto.setName(pet.getName());
		//查找tag信息
		dto.setTag(tagDao.getTags(id));
		dto.setStatus(pet.getStatus());
		return dto;
	}

	@Override
	public PetDto[] getPetAll() {
		Pet[] pets = petDao.getPetAll();
		PetDto[] dtos = new PetDto[pets.length];
		
		//临时变量
		PetDto temp;
		Pet pet;
		
		for(int i=0;i<pets.length;i++){
			pet = pets[i];
			temp = new PetDto();
			temp.setId(pet.getId());
			temp.setCategory(categoryDao.getCategory(pet.getIdCategory()));
			temp.setName(pet.getName());
			temp.setTag(tagDao.getTags(pet.getId()));
			temp.setStatus(pet.getStatus());
			dtos[i] = temp;
		}
		
		return dtos;
	}

	@Override
	@Transactional
	public String insertPet(PetDto dto) {
		//添加宠物信息
		Pet pet = new Pet();
		pet.setName(dto.getName());
		pet.setIdCategory(dto.getCategory().getId());
		pet.setStatus(dto.getStatus());
		petDao.insertPet(pet);
		
		//添加关联信息
		Tag[] tags = dto.getTag();
		for(Tag tag:tags){
			Petandtag petandtag = new Petandtag();
			petandtag.setIdPet(pet.getId());
			petandtag.setIdTag(tag.getId());
			petandtagDao.insertPetandtag(petandtag);
		}
		
		return "success";
	}

	@Override
	@Transactional
	public String updatePet(PetDto dto) {
		//更新宠物信息
		Pet pet = new Pet();
		pet.setId(dto.getId());
		pet.setName(dto.getName());
		pet.setIdCategory(dto.getCategory().getId());
		pet.setStatus(dto.getStatus());
		petDao.updatePet(pet);
		
		//删除宠物与属性的关联，添加新的关联
		petandtagDao.deletePetandtag(dto.getId());
		Tag[] tags = dto.getTag();
		for(Tag tag:tags){
			Petandtag petandtag = new Petandtag();
			petandtag.setIdPet(pet.getId());
			petandtag.setIdTag(tag.getId());
			petandtagDao.insertPetandtag(petandtag);
		}
		
		return "success";
	}

	@Override
	@Transactional
	public String deletePet(int id) {
		//删除宠物信息
		petDao.deletePet(id);
		
		//删除宠物与属性的关联
		petandtagDao.deletePetandtag(id);
		
		return "success";
	}

}
