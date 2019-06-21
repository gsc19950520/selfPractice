package doPackage;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceFileUtils {

	//区分service还是client
	private static String fileName = "";
	//备份文件存放的地址
	private static String buckupDir = "D:/backupFile/"  + fileName + "/" + System.currentTimeMillis() + "/";
	
	//测试服务器上的文件夹地址
	private static String oldFileUrl = "";
	//需要更新的文件夹地址 
	private static String desFileUrl = "D:/updateFile/" + fileName + "/";
	
	//版本上线的代码，每次更新文件就添加或者替换最新的文件
	private static String preOnlineFileUrl = "D:/updateFile/preOnline/" + fileName + "/";
	
	//以往修改的文件统一存放
	private static String historyUpdateFileUrl = "D:/updateFile/history/" + fileName + "/" + System.currentTimeMillis() + "/";
	
	private static List<String> fileUrls = new ArrayList<String>();
	
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
		if(fileName.equals("ddservice")) {
			oldFileUrl = "D:\\tomcat-ddservice-8181";
		}else if(fileName.equals("ddclient")){
			oldFileUrl = "D:\\tomcat-ddclient-80";
		}else if(fileName.equals("ddcmop")) {
			oldFileUrl = "D:\\tomcat-ddcmop-8282";
		}else if(fileName.equals("assistantservice")) {
			oldFileUrl = "D:\\tomcat-assistantservice-9008";
		}else if(fileName.equals("assistantclient")) {
			oldFileUrl = "D:\\tomcat-assistantclient-9001";
		}else if(fileName.equals("qd-client")){
			oldFileUrl = "D:\\tomcat-qdclient-8198";
		}else if(fileName.equals("tencent-service")){
			oldFileUrl = "D:\\tomcat-tencent-service-8199";
		}
		oldFileUrl += "\\webapps\\ROOT\\WEB-INF\\classes\\";
		buckupDir = "D:/backupFile/"  + fileName + "/" + System.currentTimeMillis() + "/";
		desFileUrl = "D:/updateFile/" + fileName + "/";
		preOnlineFileUrl = "D:/updateFile/preOnline/" + fileName + "/";
		historyUpdateFileUrl = "D:/updateFile/history/" + fileName + "/" + System.currentTimeMillis() + "/";
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
			//将测试上的class文件拷贝到备份文件夹下
			sendFileToPath(oldFile, backupFilePath);
		}
	}
	
	//替换文件，将老的文件替换为新文件
	public static void replaceFile () {
		for(String filePath : fileUrls) {
			int index = indexString(filePath, "\\", 3);
			String substring = filePath.substring(index, filePath.length());
			String oldFilePath = oldFileUrl + substring;
			String desFilePath = desFileUrl + substring;

			File sourceFile = new File(desFilePath);
			//替换或新增文件到项目中
			sendFileToPath(sourceFile, oldFilePath);
			//再更新一份文件到需要上线的文件夹下
			String preOnlinePath = preOnlineFileUrl + substring;
			sendFileToPath(sourceFile,preOnlinePath);
			//更新一份历史纪录文件夹
			String historyUpdatePath = historyUpdateFileUrl + substring;
			sendFileToPath(sourceFile,historyUpdatePath);
		}
	}
	
	//拷贝源文件到目标路径
	public static void sendFileToPath(File sourceFile, String targetPath) {
		File targetFile = new File(targetPath);
		File targetDir = new File(targetPath.substring(0, targetPath.lastIndexOf("\\")));
		if(!targetDir.exists()) {
			//文件夹不存在，创建文件夹
			targetDir.mkdirs();
			if(!targetFile.exists()) {
				//文件不存在，创建文件
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
	 * IO复制
	 * @param oldFile 源文件
	 * @param targetFile 目标文件
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
	
	// 删除文件夹，只能删除空文件夹
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  

	// 删除指定文件夹下的所有文件
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
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
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
		//输入项目名称
		readScreen();
		//将文件路径遍历成单个绝对路径集合
		refreshFileList(desFileUrl);
		//将测试项目中的文件备份
		genBackupFile();
		//替换新文件，并且替换上线的文件夹
		replaceFile();
		//删除此次更新的文件夹
		delFolder(desFileUrl);
	}
}
