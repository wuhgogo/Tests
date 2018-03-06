package com.study.test.solr;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test; 

//maven需要的dependency
//<dependency>
//<groupId>org.apache.solr</groupId>
//<artifactId>solr-solrj</artifactId>
//<version>4.10.1</version>
//</dependency>

public class SolrTest {
	
    private final static String URL = "http://localhost:8080/solr/hlj_ks";
    
    /** 
     * 返回filed 
     * @throws SolrServerException 
     * @throws MalformedURLException 
     */ 
    @Test
    public void select() throws SolrServerException, MalformedURLException{  
        HttpSolrServer server = new HttpSolrServer(URL);  
        //定义查询字符串  
        SolrQuery query = new SolrQuery("klmc:测试类");  
        //实现分页的查询  
        query.setStart(0);  
        query.setRows(5);  
        QueryResponse res = server.query(query);  
        //查询出来的结果都保存在SolrDocumentList中  
        SolrDocumentList sdl = res.getResults();  
        System.out.println("总数："+sdl.getNumFound());  
        for(SolrDocument sd : sdl){  
            System.out.println(sd.get("id")+"#"+sd.get("xm")+"#"+sd.get("sfzh"));  
        }  
    }  
      
    /** 
     * 返回bean 
     * @throws MalformedURLException 
     * @throws SolrServerException 
     */  
    @Test
    public void select2() throws MalformedURLException, SolrServerException{  
//        HttpSolrServer server = new HttpSolrServer(URL);  
//        //相当于QueryParser  
//        SolrQuery query = new SolrQuery("*:*");  
//        query.setStart(1);  
//        query.setRows(3);  
//        QueryResponse res = server.query(query);  
//        //可以直接查询相应的bean对象，但是不是很常用  
//        //使用这种方式无法获取总数量  
//        List<PeopleBean> list = res.getBeans(PeopleBean.class);  
//        System.out.println("当前总数："+list.size());  
//        for(PeopleBean msg : list){  
//            System.out.println(msg.getId()+"#"+msg.getName()+"#"+msg.getContent());  
//        }  
    }  
      
    /** 
     * 高亮显示 
     * @throws SolrServerException 
     * @throws MalformedURLException 
     */  
     public void color() throws SolrServerException, MalformedURLException{    
         HttpSolrServer server = new HttpSolrServer(URL);  
            SolrQuery query = new SolrQuery("klmc:测试类"); //高亮字符
            query.setHighlight(true).setHighlightSimplePre("<span class='red'>").setHighlightSimplePost("</span>")    
            .setStart(0).setRows(10);    
            //hl.fl表示高亮的field，也就是高亮的区域    
            query.setParam("hl.fl","xm","sfzh");  //显示高亮的字段  
            QueryResponse res = server.query(query);    
                
            SolrDocumentList sdl = res.getResults();    
            System.out.println("总数："+sdl.getNumFound());    
            for(SolrDocument sd : sdl){    
//            System.out.println(sd.get("id")+"#"+sd.get("msg_title")+"#"+sd.get("msg_content"));    
                String id = (String) sd.get("id");    
                //在solr这里对需要加高亮的字段必须要在索引中的store=true才行    
                System.out.println(id+"#"+res.getHighlighting().get(id).get("xm"));;    
                    
            }    
        }    
    
    @Test
    public void add(){  
          
        //1、创建SolrServer对象，该对象有两个可以使用，都是线程安全的  
//      HttpSolrServer：启动web服务器使用的，通过http请求的  
//      EmbeddedSolrServer：内嵌式的，导入solr的jar包就可以使用了  
        try {  
            HttpSolrServer server = new HttpSolrServer(URL);  
            //把查询出来的数据全部删除  
//          server.deleteByQuery("*:*");  
//          server.commit();  
              
            SolrInputDocument doc = new SolrInputDocument();  
            //id是必填的，并且是String类型的  
            //<field name="id" type="string" indexed="true" stored="true" required="true" />  
            //id是唯一的主键，当多次添加的时候，最后添加的相同id会覆盖前面的域
            ArrayList<String> multiValued1 = new ArrayList<String>();
            ArrayList<String> multiValued2 = new ArrayList<String>();
            doc.addField("id", "test1");  
            doc.addField("xq", "111111");  
            doc.addField("shi", "1111");  
            doc.addField("ksh", "1111111111");  
            doc.addField("xm", "测试壹");  
            doc.addField("byzx", "111111"); 
            doc.addField("sfzh", "111111111111111111"); 
            doc.addField("mm", "111111"); 
            doc.addField("qrzt", "0"); 
            doc.addField("bkkl", "1"); 
            doc.addField("xbm", "1"); 
            doc.addField("ty", "0"); 
            multiValued1.add("测试中学1");
            doc.addField("zxmc", multiValued1);
            multiValued2.add("测试类");
            doc.addField("klmc",multiValued2); 
            server.add(doc);  
            server.commit();  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (SolrServerException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 基于列表的添加 
     * @throws SolrServerException 
     * @throws IOException 
     */
    @Test
    public void test2() throws SolrServerException, IOException{  
        List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();  
        SolrInputDocument doc = new SolrInputDocument();  
        ArrayList<String> multiValued1 = new ArrayList<String>();
        ArrayList<String> multiValued2 = new ArrayList<String>();
        doc.addField("id", "test1");  
        doc.addField("xq", "111111");  
        doc.addField("shi", "1111");  
        doc.addField("ksh", "1111111111");  
        doc.addField("xm", "测试壹");  
        doc.addField("byzx", "111111"); 
        doc.addField("sfzh", "111111111111111111"); 
        doc.addField("mm", "111111"); 
        doc.addField("qrzt", "0"); 
        doc.addField("bkkl", "1"); 
        doc.addField("xbm", "1"); 
        doc.addField("ty", "0"); 
        multiValued1.add("测试中学1");
        doc.addField("zxmc", multiValued1);
        multiValued2.add("测试类");
        doc.addField("klmc",multiValued2); 
        docs.add(doc);  
          
        doc = new SolrInputDocument();  
        ArrayList<String> multiValued3 = new ArrayList<String>();
        ArrayList<String> multiValued4 = new ArrayList<String>();
        doc.addField("id", "test2");  
        doc.addField("xq", "222222");  
        doc.addField("shi", "2222");  
        doc.addField("ksh", "2222222222");  
        doc.addField("xm", "测试贰");  
        doc.addField("byzx", "222222"); 
        doc.addField("sfzh", "222222222222222222"); 
        doc.addField("mm", "222222"); 
        doc.addField("qrzt", "0"); 
        doc.addField("bkkl", "2"); 
        doc.addField("xbm", "2"); 
        doc.addField("ty", "0"); 
        multiValued3.add("测试中学2");
        doc.addField("zxmc", multiValued3);
        multiValued4.add("测试类");
        doc.addField("klmc",multiValued4); 
        docs.add(doc);  
          
        HttpSolrServer server = new HttpSolrServer(URL);  
        server.add(docs);  
        server.commit();  
    }  
     
    @Test
    public void  update(){  
        try {  
            HttpSolrServer server = new HttpSolrServer(URL);  
            SolrInputDocument doc = new SolrInputDocument();
//            doc.addField("id", "testId1");  
//            doc.addField("name", "testName1");  
//            doc.addField("content", "testContent1");  
//            doc.addField("type", "test");  
//            server.add(doc);  
//            server.commit(); 
            ArrayList<String> multiValued1 = new ArrayList<String>();
            ArrayList<String> multiValued2 = new ArrayList<String>();
            doc.addField("id", "test1");  
            doc.addField("xq", "111111");  
            doc.addField("shi", "1111");  
            doc.addField("ksh", "1111111111");  
            doc.addField("xm", "测试壹更新");  
            doc.addField("byzx", "111111"); 
            doc.addField("sfzh", "111111111111111111"); 
            doc.addField("mm", "111111"); 
            doc.addField("qrzt", "0"); 
            doc.addField("bkkl", "1"); 
            doc.addField("xbm", "1"); 
            doc.addField("ty", "0"); 
            multiValued1.add("测试中学1");
            multiValued1.add("测试中学2");
            doc.addField("zxmc", multiValued1);
            multiValued2.add("测试类1");
            multiValued2.add("测试类2");
            doc.addField("klmc",multiValued2); 
            server.add(doc);  
            server.commit();  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (SolrServerException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    @Test
    public void deleteById() {  
        HttpSolrServer server = new HttpSolrServer(URL);  
        try {  
        	server.deleteById("testId1");  
        	server.commit();  
        } catch (Exception e) {  
             System.out.println("错误");  
        }  
    }  
      
    /** 
     * 删除所有文档，为安全起见，使用时再解注函数体 。 
     */  
    @Test
    public void deleteAll() {  
        HttpSolrServer server = new HttpSolrServer(URL);  
        try {  
        	server.deleteByQuery("klmc:测试类");  
        	server.commit();  
        } catch (Exception e) {  
            System.out.println("错误");  
        }  
    } 
    
    @Test
    public void serverOpTest() {
    	HttpSolrServer server = new HttpSolrServer(URL); 
    	try {
			System.out.println(server.ping());
			System.out.println(server.optimize());
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
