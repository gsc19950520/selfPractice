package com.getpic;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PA2 {

//    private static final String BIZHI_URL = "https://sj.enterdesk.com/";//
//    private static int bizhi_i = 56587;//壁纸已到56587处理完
//    private static int bizhi_page = 3538;//壁纸已到3538处理完

    private static final String linkType = "/tx/heibai/";
    private static final String type = linkType + "list_227_";
    private static final String TOUXIANG_URL = "http://www.jj20.com";
    private static int touxiang_i = 37561;
    private static int touxiang_page = 59;

    private static final String OUT_FILEPATH = "C:\\Users\\ThinkPad\\Desktop\\dy\\素材\\爬虫\\头像\\黑白头像\\";

    public static List<String> exUrl = new LinkedList<String>();

    public static void main(String[] args) {
        try{
            load(TOUXIANG_URL + type + touxiang_page + ".html");
        }catch (Exception e){
            System.out.println("下载失败，" + touxiang_i + ",page=" + touxiang_page + ",message=" + e.getMessage());
        }
    }

    /**
     * 加载链接
     * @param urls
     * @throws Exception
     */
//    public static void load(String urls) throws Exception{
//        Connection connect = Jsoup.connect(urls);
//        Document document = connect.get();
//        Elements links = document.getElementsByTag("img");
//        //循环爬取图片
//        for(Element link : links){
//            String url = link.attr("src");//下载的url
//            String endWith = url.substring(url.lastIndexOf("."));//文件后缀名
//            download(url,endWith,String.valueOf(i));
//            i++;
//        }
//        //获取所有的<li>
//        Elements select = document.select("a");
//        Elements addClass = select.addClass("next_p");
//        for (Element element : addClass) {
//            if (element.text().equals("下一页")) {
//                page++;
////                if(page == 10){
////                    break;
////                }
//                //获取超链接
//                String attr = element.attr("href");
//                //递归循环下载
//                load(attr);
//            }else{
//                continue;
//            }
//
//        }
//
//    }

    //图片内链接
    public static void load(String urls) throws Exception{
        Connection connect = Jsoup.connect(urls);
        Document document = connect.get();
        Elements links = document.getElementsByTag("li");
        //循环爬取图片
        for(Element link : links){
            Element a = link.getElementsByTag("a").get(0);
            String suffixUrl = a.attr("href");
            if(!suffixUrl.contains(linkType) || exUrl.contains(suffixUrl)){
                continue;
            }
            exUrl.add(suffixUrl);
            String htmlUrl = TOUXIANG_URL + suffixUrl;//html链接
            System.out.println("当前html链接为：" + htmlUrl);
            Connection htmlConnect = Jsoup.connect(htmlUrl);
            Document htmlDocument = htmlConnect.get();
            Elements errorImgs1 = htmlDocument.getElementsByTag("img");
            List<Element> errorImgs2 = errorImgs1.subList(0, errorImgs1.size());
            List<Element> imgs = errorImgs2.stream().filter(t1 -> errorImgs2.stream().filter(t2 -> t1.attr("alt").equals(t2.attr("alt"))).count() > 1).collect(Collectors.toList());
            for(Element img : imgs){
                String url = img.attr("src");//下载的url
                String endWith = url.substring(url.lastIndexOf("."));//文件后缀名
                download(url,endWith,String.valueOf(touxiang_i));
                touxiang_i++;
            }
        }
        //获取所有的<li>
        Elements select = document.select("a");
        Elements addClass = select.addClass("next_p");
        for (Element element : addClass) {
            if (element.text().equals("下一页")) {
                touxiang_page++;
                if(touxiang_page > 100){
                    break;
                }
                //获取超链接
                String attr = element.attr("href");
                //递归循环下载
                attr = TOUXIANG_URL + linkType + attr;
                load(attr);
            }else{
                continue;
            }
        }
    }

    /**
     * 下载图片
     * @param url
     */
    public static void download(String url,String endWith,String fileName) throws Exception{
        File file = new File(OUT_FILEPATH);
        if (!file.exists()){
            file.mkdir();
        }else{
            file.delete();
            file.mkdir();
        }
        URL url2 = new URL(url);
        InputStream is = url2.openConnection().getInputStream();
        FileOutputStream fo = new FileOutputStream(new File(OUT_FILEPATH + "/" + fileName + endWith));
        byte[] buf = new byte[1024];
        int length;
        System.out.println("开始下载:" + url);
        while ((length = is.read(buf, 0, buf.length)) != -1) {
            fo.write(buf, 0, length);
        }
        is.close();
        fo.close();
        System.out.println(fileName + endWith + "---下载完成---当前页面---" + touxiang_page);
    }
}
