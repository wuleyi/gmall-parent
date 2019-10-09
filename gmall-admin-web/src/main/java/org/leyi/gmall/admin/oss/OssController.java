package org.leyi.gmall.admin.oss;


import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Oss相关操作接口
 */
@CrossOrigin
@RestController
@Api("Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {

	@Autowired
	private OssComponent ossComponent;

	@GetMapping("/policy")
	@ApiOperation(value = "oss上传签名生成")
	public R policy() {

		return R.ok(ossComponent.policy()).setCode(200);
	}



}
