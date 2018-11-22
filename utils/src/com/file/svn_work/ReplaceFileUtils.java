package com.file.svn_work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceFileUtils {

	//区分service还是client
//	private static String fileName = "service";
//	private static String fileName = "client";
	private static String fileName = "";
	//备份文件存放的地址
	private static String buckupDir = "D:/backupFile/"  + fileName + "/" + System.currentTimeMillis() + "/";
	
	//测试服务器上的文件夹地址
//	private static String oldFileUrl = "D:/tomcat-ddclient-80/webapps/ROOT/WEB-INF/classes/";
//	private static String oldFileUrl = "D:/tomcat-ddservice-8181/webapps/ROOT/WEB-INF/classes/";
	private static String oldFileUrl = "";
	//需要更新的文件夹地址 
	private static String desFileUrl = "D:/updateFile/" + fileName + "/";
	
	private static List<String> fileUrls = new ArrayList<String>();
	
	/*static {
		if(fileName.equals("service")) {
			oldFileUrl = "D:/tomcat-ddservice-8181/webapps/ROOT/WEB-INF/classes/";
		}else if(fileName.equals("client")){
			oldFileUrl = "D:/tomcat-ddclient-80/webapps/ROOT/WEB-INF/classes/";
		}
	}*/
	
	@SuppressWarnings("resource")
	private static void readScreen() {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入需要替换的项目名称:");
		String fileN = s.nextLine();
		System.out.println(">>>" + fileN);
		fileName = fileN;
		init();
	}
	
	private static void init() {
		if(fileName.equals("service")) {
			oldFileUrl = "D:\\tomcat-ddservice-8181\\webapps\\ROOT\\WEB-INF\\classes\\";
		}else if(fileName.equals("client")){
			oldFileUrl = "D:\\tomcat-ddclient-80\\webapps\\ROOT\\WEB-INF\\classes\\";
		}
		buckupDir = "D:/backupFile/"  + fileName + "/" + System.currentTimeMillis() + "/";
		desFileUrl = "D:/updateFile/" + fileName + "/";
	}
	
	//将所有更新文件路径放入集合
	public static void refreshFileList (String strPath) {
		File files = new File(strPath);
		File[] fileList = files.listFiles();
		if(fileList == null) {
			return;
		}
		for(int i = 0; i < fileList.length; i++) {
			if(fileList[i].isDirectory()) {
				//如果还是文件夹则递归处理
				refreshFileList(fileList[i].getAbsolutePath());
			} else {
				//获取文件绝对路径
				String strFileName = fileList[i].getAbsolutePath();
				//获取文件后缀
                String suffixName = strFileName.substring(strFileName.lastIndexOf(".") + 1,strFileName.length());  
                if(suffixName.equals("class") || suffixName.equals("xml")) {
                	fileUrls.add(fileList[i].getAbsolutePath());
                }
			}
		}
	}
	
	//将备份数据放入备份文件夹
	public static void genBackupFile () {
		for(String filePath : fileUrls) {
			int index = indexString(filePath, "\\", 3);
			String substring = filePath.substring(index, filePath.length());
			String oldFilePath = oldFileUrl + substring;
			String backupFilePath = buckupDir + substring;
			
			File oldFile = new File(oldFilePath);
			if(!oldFile.exists()) {
				//不存在，说明是新添加的文件
				continue;
			}
			File backupDir = new File(backupFilePath.substring(0, backupFilePath.lastIndexOf("\\")));
			File backupFile = new File(backupFilePath);
			if(!backupDir.exists()) {
				//文件夹不存在，创建文件夹
				backupDir.mkdirs();
				if(!backupFile.exists()) {
					//文件不存在，创建文件
					try {
						backupFile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			ioCopy(oldFile, backupFile);
		}
	}
	
	//替换文件，将老的文件替换为新文件
	public static void replaceFile () {
		for(String filePath : fileUrls) {
			int index = indexString(filePath, "\\", 3);
			String substring = filePath.substring(index, filePath.length());
			String oldFilePath = oldFileUrl + substring;
			String desFilePath = desFileUrl + substring;
			
			File desFile = new File(desFilePath);
			File oldFile = new File(oldFilePath);
			ioCopy(desFile, oldFile);
		}
	}

	/**
	 * IO复制
	 * @param oldFile源文件
	 * @param targetFile目标文件
	 */
	private static void ioCopy(File oldFile, File targetFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(oldFile);
			fos = new FileOutputStream(targetFile);
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null) {
					fis.close();
				}
				if(fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	//递归获取字符串s第m个c的位置 + 1
	public static int indexString(String s, String c, int m) {
		if(m != 0) {
			int formIndex = indexString(s, c, --m);
			return s.indexOf(c, formIndex) + 1;
		}else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		readScreen();
		refreshFileList(desFileUrl);
		
//		System.out.println(fileUrls);
//		System.out.println(fileUrls.size());
		//获取第二个/+1的位置
//		System.out.println(indexString("C:/Users/18302/Desktop/下载", "/", 2));
		
		genBackupFile();
		replaceFile();
	}
}
