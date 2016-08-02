package dto;

import domain.Category;
import domain.Tag;

/**   
 * @Description: TODO
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年7月31日 下午11:30:31 
 * @version V1.0   
 */
public class PetDto {
	private int id;
	private Category category;
	private String name;
	private Tag[] tag;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Tag[] getTag() {
		return tag;
	}
	public void setTag(Tag[] tag) {
		this.tag = tag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
