package com.taotao.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;
/**图片上传服务service。
 * 
 * @author Administrator
 *
 */
@Service
public class PictureServiceImpl implements PictureService
{
	private Logger Logger  = LoggerFactory.getLogger(PictureServiceImpl.class);
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
//	@Value("${FTP_PORT}")
//	private String FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	@Override
	public Map uploadPicture(MultipartFile multipartFile) {
		Map resultMap = new HashMap<>();	
		Logger.error(FTP_ADDRESS+FTP_USERNAME);
		try {
			//生成新的文件名。
			//取原始的文件名。
			String originalFilename = multipartFile.getOriginalFilename();
			//生成新文件名。。
//		UUID.randomUUID();	
			String newImageName = IDUtils.genImageName();
			newImageName = newImageName+originalFilename.substring(originalFilename.lastIndexOf(".")); 
			//图片上传。
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean uploadFile = FtpUtil.uploadFile("192.168.91.128", 21, "ftpuser", "ywx564041", "/home/ftpuser/www/images",
					imagePath, newImageName, multipartFile.getInputStream());
			//返回结果。
			if(!uploadFile)
			{
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("url", "http://192.168.91.128/images"+imagePath+"/"+newImageName);
			return resultMap;
		} catch (IOException e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}

}
