package com.file.svn_work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceFileUtils {

	//����service����client
//	private static String fileName = "service";
//	private static String fileName = "client";
	private static String fileName = "";
	//�����ļ���ŵĵ�ַ
	private static String buckupDir = "D:/backupFile/"  + fileName + "/" + System.currentTimeMillis() + "/";
	
	//���Է������ϵ��ļ��е�ַ
//	private static String oldFileUrl = "D:/tomcat-ddclient-80/webapps/ROOT/WEB-INF/classes/";
//	private static String oldFileUrl = "D:/tomcat-ddservice-8181/webapps/ROOT/WEB-INF/classes/";
	private static String oldFileUrl = "";
	//��Ҫ���µ��ļ��е�ַ 
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
		System.out.println("��������Ҫ�滻����Ŀ����:");
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
	
	//�����и����ļ�·�����뼯��
	public static void refreshFileList (String strPath) {
		File files = new File(strPath);
		File[] fileList = files.listFiles();
		if(fileList == null) {
			return;
		}
		for(int i = 0; i < fileList.length; i++) {
			if(fileList[i].isDirectory()) {
				//��������ļ�����ݹ鴦��
				refreshFileList(fileList[i].getAbsolutePath());
			} else {
				//��ȡ�ļ�����·��
				String strFileName = fileList[i].getAbsolutePath();
				//��ȡ�ļ���׺
                String suffixName = strFileName.substring(strFileName.lastIndexOf(".") + 1,strFileName.length());  
                if(suffixName.equals("class") || suffixName.equals("xml")) {
                	fileUrls.add(fileList[i].getAbsolutePath());
                }
			}
		}
	}
	
	//���������ݷ��뱸���ļ���
	public static void genBackupFile () {
		for(String filePath : fileUrls) {
			int index = indexString(filePath, "\\", 3);
			String substring = filePath.substring(index, filePath.length());
			String oldFilePath = oldFileUrl + substring;
			String backupFilePath = buckupDir + substring;
			
			File oldFile = new File(oldFilePath);
			if(!oldFile.exists()) {
				//�����ڣ�˵��������ӵ��ļ�
				continue;
			}
			File backupDir = new File(backupFilePath.substring(0, backupFilePath.lastIndexOf("\\")));
			File backupFile = new File(backupFilePath);
			if(!backupDir.exists()) {
				//�ļ��в����ڣ������ļ���
				backupDir.mkdirs();
				if(!backupFile.exists()) {
					//�ļ������ڣ������ļ�
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
	
	//�滻�ļ������ϵ��ļ��滻Ϊ���ļ�
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
	 * IO����
	 * @param oldFileԴ�ļ�
	 * @param targetFileĿ���ļ�
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
	
	
	//�ݹ��ȡ�ַ���s��m��c��λ�� + 1
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
		//��ȡ�ڶ���/+1��λ��
//		System.out.println(indexString("C:/Users/18302/Desktop/����", "/", 2));
		
		genBackupFile();
		replaceFile();
	}
}
