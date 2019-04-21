package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {
	@Test
	public void testFtpClient() throws SocketException, IOException
	{
		//创建一个FtpClient对象。
		FTPClient ftpClient = new FTPClient();
		//创建ftp链接。
		ftpClient.connect("192.168.91.128", 21);
		//登录ftp服务器。
		ftpClient.login("ftpuser", "ywx564041");
		//上传图片。读取本地文件。
		FileInputStream fileInputStream = new FileInputStream(new File("D:\\Project_Tools\\one_project_tools\\images\\aa.jpg"));
		//设置上传的路径。
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		//修改上传文件的格式。二进制形式。
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//1.服务器端文件名，2.上传文件的inputStream。
		
		ftpClient.storeFile("hello2.jpg", fileInputStream);
		//关闭链接。
		ftpClient.logout();
	}
	@Test
	public void testFtpUtils() throws Exception
	{
		FileInputStream fileInputStream = new FileInputStream(new File("D:\\Project_Tools\\one_project_tools\\images\\aa.jpg"));
		FtpUtil.uploadFile("192.168.91.128", 21, "ftpuser", "ywx564041", "/home/ftpuser/www/images", "2019/02/14", "hello.jpg", fileInputStream);
//		FtpUtil.downloadFile(host, port, username, password, remotePath, fileName, localPath);
	}
}
