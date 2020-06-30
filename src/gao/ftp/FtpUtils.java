package gao.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.List;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;



/**
 * <b>Ftp 工具：上传、下载、删除</b></br>
 *
 * @Company 有谦软联（北京）信息技术有限公司</br>
 * @Version	V1.0
 * @Author 高祥
 * @Date 2018年4月18日 下午3:49:02
 */
public class FtpUtils {
	
    private static FTPClient ftpClient;
    /**
     * 初始化ftp连接
     * @return
     */
	public static boolean initFtp(){
		ftpClient = new FTPClient();
		try {
			//连接
			ftpClient.connect(Constants.FTP_HOST, Constants.FTP_PORT);
			//登录
			boolean login = ftpClient.login(Constants.FTP_USERNAME, Constants.FTP_PASSWORD);
			if(login){
				//验证连接有效
				int replyCode = ftpClient.getReplyCode();
				if(!FTPReply.isPositiveCompletion(replyCode)){
					ftpClient.disconnect();
					System.out.println("Ftp服务器拒绝连接:"+Constants.FTP_HOST+":"+Constants.FTP_PORT); 
					throw new RuntimeException("连接ftp失败");
	            }
			}else{
				ftpClient.disconnect();
				System.out.println("connect failed...ftp服务器:"+Constants.FTP_HOST+":"+Constants.FTP_PORT); 
				throw new RuntimeException("登录Ftp失败");
			}
            System.out.println("connect successfu...ftp服务器:"+Constants.FTP_HOST+":"+Constants.FTP_PORT); 
		} catch (SocketException e) {
			e.printStackTrace();
			throw new RuntimeException("初始化ftp连接失败！");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("初始化ftp连接失败！");
		}
		return true;
	}
	/**
	 * 关闭ftp 链接 
	 * @return
	 */
	public static void close(){
		if (ftpClient.isConnected()) {
			try {
				ftpClient.logout();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				ftpClient.disconnect();
			} catch (IOException e){
                  e.printStackTrace();
              }
          } 
	}
	/**
     * 上传文件
     *  ftp服务保存地址
     *   上传到ftp的文件名
     *    待上传文件的名称（绝对地址） *
     * @return
	 * @throws Exception 
     */
     public static void uploadFile(List<File> files) {
         InputStream inputStream = null;
         //初始化ftp 连接
         initFtp();
         for (File file : files) {
        	 String name = null;
        	 try{
                 System.out.println("开始上传文件");
                 //上传使用输入流，读取本地（客户端）文件
                 inputStream = new FileInputStream(file);
                 //获取文件名
                 name = file.getName();
                 //设置文件传输类型  二进制 （不改变文件内容）
                 ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                 //获得当前所在文件目录
                 String workDirectory = ftpClient.printWorkingDirectory(); 	
                 //根据当前目录切换需要访问的相对路径
                 ftpClient.changeWorkingDirectory(workDirectory+Constants.FTP_PATH);  
                 //ftpClient.enterLocalActiveMode();//主动模式
                 //使用被动模式  1.客户端发送PASV命令 敲门服务端  2.服务端开放 > 1024端口   并返回ip 端口号
                 ftpClient.enterLocalPassiveMode();// 被动模式    常用被动模式
                 //服务端返回ip 不可用时（服务端若在自己的内网可能返回内网IP,客户端无法访问服务端内网，会出现连接超时现象。服务端可以单独设置，以使服务端返回ip为外部公网ip） 
                 //设置变通办法策略以替换 PASV 模式答复地址
                 //参数为当前ftpClient对象代表，使用当前ftpClient 所连接的IP地址
                 FTPClient.HostnameResolver resolver = new FTPClient.NatServerResolverImpl(ftpClient);
                 //设置变通办法策略以替换 PASV 模式答复地址
                 ftpClient.setPassiveNatWorkaroundStrategy(resolver);
                 //上传文件   文件名，读取本地文件输入流
                 boolean appendFile = ftpClient.appendFile(name, inputStream);
                 //另一种上传方式
                 ///boolean storeFile = ftpClient.storeFile(name, inputStream);
                 if(appendFile==false){
                	 throw new RuntimeException("上传文件失败");
                 }
                 System.out.println("上传文件成功");
             }catch (Exception e) {
            	 try {
            		//出现异常删除可能出现问题的文件
					ftpClient.deleteFile(name);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
                 e.printStackTrace();
                 throw new RuntimeException("上传文件失败");
             }finally{
            	 if(null != inputStream){
                     try {
                         inputStream.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     } 
                 } 
            	 
             }
         }
         // 关闭连接 释放资源
         close();
     }
     /** * 删除文件 * 
      *  FTP服务器保存目录 *
      * @param filename 要删除的文件名称 * 
      * @return */ 
      public static boolean deleteFile(String filename){ 
          boolean flag = false; 
          try { 
              System.out.println("开始删除文件");
              initFtp();
              //获得当前所在文件目录
              String workDirectory = ftpClient.printWorkingDirectory(); 	
              //根据当前目录切换需要访问的相对路径
              ftpClient.changeWorkingDirectory(workDirectory+Constants.FTP_PATH); 
              //服务端返回ip 不可用时（服务端若在自己的内网可能返回内网IP,客户端无法访问服务端内网，会出现连接超时现象。服务端可以单独设置，以使服务端返回ip为外部公网ip） 
              //设置变通办法策略以替换 PASV 模式答复地址
              //参数为当前ftpClient对象代表，使用当前ftpClient 所连接的IP地址
              FTPClient.HostnameResolver resolver = new FTPClient.NatServerResolverImpl(ftpClient);
              //设置变通办法策略以替换 PASV 模式答复地址
              ftpClient.setPassiveNatWorkaroundStrategy(resolver);
              //删除文件
              ftpClient.dele(filename); 
              flag = true; 
              System.out.println("删除文件成功");
          } catch (Exception e) { 
              System.out.println("删除文件失败");
              throw new RuntimeException("删除文件失败",e);
          } finally {
        	  close();
          }
          return flag; 
      }
      /* 
       * 从FTP服务器下载文件 
       * @param fileName 文件名称 
       */  
      public static File downloadFtpFile(
              String fileName) {  
    	  //初始化ftp 连接
          initFtp();
          File localFile = new File(fileName);  
          try {  
              ftpClient.setControlEncoding("UTF-8"); // 中文支持  
              //设置文件传输类型
              ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
              //获得当前所在文件目录
              String workDirectory = ftpClient.printWorkingDirectory(); 	
              //根据当前目录切换需要访问的相对路径
              ftpClient.changeWorkingDirectory(workDirectory+Constants.FTP_PATH); 
              //启用被动模式
              ftpClient.enterLocalPassiveMode();  
              //变通办法策略以替换 PASV 模式答复地址
              FTPClient.HostnameResolver resolver = new FTPClient.NatServerResolverImpl(ftpClient);
              //设置变通办法策略以替换 PASV 模式答复地址
              ftpClient.setPassiveNatWorkaroundStrategy(resolver);
              //写入本地文件需要的输出流
              OutputStream os = new FileOutputStream(localFile);  
              //下载文件
              ftpClient.retrieveFile(fileName, os);
              os.flush();
              os.close();  
          } catch (FileNotFoundException e) {  
              throw new RuntimeException("下载失败",e);
          } catch (SocketException e) {  
               throw new RuntimeException("下载失败",e);
          } catch (IOException e) {  
              throw new RuntimeException("下载失败",e);
          } finally {
        	  close();
          }  
          return localFile;
      }  
    
}  
