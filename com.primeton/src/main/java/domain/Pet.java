package domain;

/**   
 * @Description: 宠物表
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年7月28日 下午5:30:57 
 * @version V1.0   
 */
public class Pet {
	private int id;
	private String name;
	private int idCategory;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
