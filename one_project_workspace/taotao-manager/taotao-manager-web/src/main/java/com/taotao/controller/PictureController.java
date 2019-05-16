package com.taotao.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

/**
 * 上传图片处理。
 * @author Administrator
 *
 */
@Controller
public class PictureController
{
	private Logger Logger  = LoggerFactory.getLogger(PictureController.class);
	@Autowired
	private PictureService pictureService;
	@RequestMapping("/pic/upload")
	@ResponseBody 
	public String pictureUpload(MultipartFile uploadFile)
	{
		Map uploadPicture = pictureService.uploadPicture(uploadFile);
		//为了保证兼容性。需要转换成json格式的字符串。
		String json = JsonUtils.objectToJson(uploadPicture);
		return json;
		
	}
}