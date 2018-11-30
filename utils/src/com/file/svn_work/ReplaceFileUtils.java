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
	private static String fileName = "client";
	//�����ļ���ŵĵ�ַ
	private static String buckupDir = "D:/backupFile/"  + fileName + "/" + System.currentTimeMillis() + "/";
	
	//���Է������ϵ��ļ��е�ַ
//	private static String oldFileUrl = "D:/tomcat-ddclient-80/webapps/ROOT/WEB-INF/classes/";
//	private static String oldFileUrl = "D:/tomcat-ddservice-8181/webapps/ROOT/WEB-INF/classes/";
	private static String oldFileUrl = "";
	//��Ҫ���µ��ļ��е�ַ 
	private static String desFileUrl = "D:/updateFile/" + fileName + "/";
	
	//�汾���ߵĴ��룬ÿ�θ����ļ�����ӻ����滻���µ��ļ�
	private static String preOnlineFileUrl = "D:/updateFile/preOnline/" + fileName + "/";
	
	//�����޸ĵ��ļ�ͳһ���
	private static String historyUpdateFileUrl = "D:/updateFile/history/" + fileName + "/" + System.currentTimeMillis() + "/";
	
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
		preOnlineFileUrl = "D:/updateFile/preOnline/" + fileName + "/";
		historyUpdateFileUrl = "D:/updateFile/history/" + fileName + "/" + System.currentTimeMillis() + "/";
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
			//�������ϵ�class�ļ������������ļ�����
			sendFileToPath(oldFile, backupFilePath);
		}
	}
	
	//�滻�ļ������ϵ��ļ��滻Ϊ���ļ�
	public static void replaceFile () {
		for(String filePath : fileUrls) {
			int index = indexString(filePath, "\\", 3);
			String substring = filePath.substring(index, filePath.length());
			String oldFilePath = oldFileUrl + substring;
			String desFilePath = desFileUrl + substring;
			
			File sourceFile = new File(desFilePath);
			File targetFile = new File(oldFilePath);
			ioCopy(sourceFile, targetFile);
			
			//�ٸ���һ���ļ�����Ҫ���ߵ��ļ�����
			String preOnlinePath = preOnlineFileUrl + substring;
			sendFileToPath(sourceFile,preOnlinePath);
			//����һ����ʷ��¼�ļ���
			String historyUpdatePath = historyUpdateFileUrl + substring;
			sendFileToPath(sourceFile,historyUpdatePath);
		}
	}
	
	//����Դ�ļ���Ŀ��·��
	private static void sendFileToPath(File sourceFile, String targetPath) {
		File targetFile = new File(targetPath);
		File targetDir = new File(targetPath.substring(0, targetPath.lastIndexOf("\\")));
		if(!targetDir.exists()) {
			//�ļ��в����ڣ������ļ���
			targetDir.mkdirs();
			if(!targetFile.exists()) {
				//�ļ������ڣ������ļ�
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		ioCopy(sourceFile, targetFile);
	}

	/**
	 * IO����
	 * @param oldFileԴ�ļ�
	 * @param targetFileĿ���ļ�
	 */
	public static void ioCopy(File oldFile, File targetFile) {
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
	
	// ɾ���ļ��У�ֻ��ɾ�����ļ���
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // ɾ����������������
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // ɾ�����ļ���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  

	// ɾ��ָ���ļ����µ������ļ�
	public static void delAllFile(String path) {
		File file = new File(path);
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delFolder(path + "/" + tempList[i]);// ��ɾ�����ļ���
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
		//��ȡ�ڶ���/+1��λ��
//		System.out.println(indexString("C:/Users/18302/Desktop/����", "/", 2));
		
		//������Ŀ����
		readScreen();
		//���ļ�·�������ɵ�������·������
		refreshFileList(desFileUrl);
		//��������Ŀ�е��ļ�����
		genBackupFile();
		//�滻���ļ��������滻���ߵ��ļ���
		replaceFile();
		//ɾ���˴θ��µ��ļ���
		delFolder(desFileUrl);
	}
}
