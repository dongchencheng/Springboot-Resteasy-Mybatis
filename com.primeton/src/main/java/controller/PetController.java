package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import dto.PetDto;
import service.PetService;

/**
 * @Description: 宠物信息controller类
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年7月28日 上午9:06:20
 * @version V1.0
 */
@RestController
@Path("/pet")
@Api("宠物信息相关api")
public class PetController {

	@Autowired
	@Qualifier("PetServiceImpl")
	private PetService petService;

	@GET
	@Path(value = "/{id}")
	@Produces(value = { "application/json" })
	@ApiOperation("通过ID获取宠物信息")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	public PetDto getPet(@PathParam("id") int id) {
		return petService.getPet(id);
	}

	@GET
	@Path(value = "/all")
	@Produces(value = { "application/json" })
	@ApiOperation("获取所有宠物信息")
	@ApiResponses({@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	public PetDto[] getPetAll() {
		return petService.getPetAll();
	}

	@POST
	@Path(value = "/")
	@Produces(value = { "text/html" })
	@ApiOperation("添加宠物信息")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
		@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	public String insertPet(PetDto dto) {
		return petService.insertPet(dto);
	}

	@PUT
	@Path(value = "/")
	@ApiOperation("更新宠物信息")
	@Produces(value = { "text/html" })
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
		@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	public String updatePet(PetDto dto) {
		return petService.updatePet(dto);
	}

	@DELETE
	@Produces(value = { "text/html" })
	@Path(value = "/{id}")
	@ApiOperation("通过ID删除宠物信息")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	public String deletePet(@PathParam("id") int id) {
		return petService.deletePet(id);
	}
}
