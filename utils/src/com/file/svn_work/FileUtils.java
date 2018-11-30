package com.file.svn_work;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileUtils {

	//区分service还是client
	private static String fileName = "service";
//	private static String fileName = "client";
	//工程所在的文件夹
	private static String appDir="D:/workspace/fdd-dd-" + fileName;
	//导出所在文件夹
	private static String desDir="D:/增量包/";
	//svn日志存放位置
	private static File file = new File("D:/changeLog.txt");

	private static List<Map<String, Object>> fileMaps = new ArrayList<Map<String, Object>>();
	 /**
     * 拷贝文件
     * @param file 想要读取svn日志的文件对象
     * @param appDir 工程所在的文件夹的路径
     * @param desDir 导出所在文件夹的路径
     * @return 返回文件内容
     */
	public static String refreshSVNFile (File file,String appDir,String desDir){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	String prefix = "/trunk-fzcenter/dd/fdd-dd/fdd-dd-" + fileName;
            	int index=s.indexOf(prefix);
            	if (index<0) {
					continue;
				}
                s=s.substring(prefix.length()+3);
                //把java文件路径替换成编译好的classes文件的路径
                if (s.contains("/src/main/java")) {
					s=s.replace("/src/main/java","/target/classes");
					s=s.replace(".java",".class");
				}else if(s.contains("/src/main/resources")){
					s=s.replace("/src/main/resources","/target/classes");
				}
                //过滤掉重复的源文件目录
                if (result.indexOf(s)>-1) {
					continue;
				}
                result.append(s+System.lineSeparator());
                //s = "/target/classes/com/fdd....."
                String desStr=desDir+s.replace("/target/classes", fileName);
                desStr = desStr.substring(0, desStr.lastIndexOf("/") + 1);
                File sourceFolder = new File(appDir + s.substring(0, s.lastIndexOf("/")));
                //compare : 文件名不带后缀
                String compare = s.substring(s.lastIndexOf("/") + 1, s.lastIndexOf("."));
                File[] listSourceFiles = sourceFolder.listFiles();
                if(listSourceFiles.length > 0 && listSourceFiles != null) {
                	for(File f : listSourceFiles) {
                		if(f.getName().indexOf(compare) != -1) {
                			//如果为true，说明是内部类或者本文件
                			Map<String, Object> fileMap = new HashMap<String, Object>();
                			fileMap.put("sourceFile", f);
                			fileMap.put("targetPath", desStr + f.getName());
                			fileMaps.add(fileMap);
                		}
                	}
                }
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
    
    public static void copyFiles () {
    	int size=0;
    	for(Map<String, Object> fileMap : fileMaps) {
    		File sourceFile = (File) fileMap.get("sourceFile");   //源文件对象
            String destFilePath = (String) fileMap.get("targetPath");  //目标文件对象
            File targetFile = new File(destFilePath);
    		File targetDir = new File(destFilePath.substring(0, destFilePath.lastIndexOf("/")));
    		if (!(sourceFile.exists())) {//判断源文件是否存在
            	System.out.println(sourceFile.getAbsolutePath()+"文件不存在.......");
            	continue;  
            }
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
    		System.out.println("开始复制文件..."+size);
    		ReplaceFileUtils.ioCopy(sourceFile, targetFile);
    		System.out.println("文件:"+sourceFile.getAbsolutePath());
    		System.out.println("文件复制成功！");
        	size++;
    	}
    	System.out.println("文件复制总数： "+size+"个！");
    }
    
    public static void main(String[] args){
    	refreshSVNFile(file,appDir,desDir);
        copyFiles();
    }
}
