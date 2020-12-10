package DomGeneratorXml;

import DomGeneratorXml.util.CreateXml;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author huyuanxin
 * @create 2020/12/10 9:21
 */
public class CreateDataConfigByDom {
    public static void main(String[] args) {
        // 创建解析器工厂
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         try {
             DocumentBuilder db = factory.newDocumentBuilder();
             Document document = db.newDocument();
             CreateXml.createXml(document);
         }catch (Exception e){
             e.printStackTrace();
             System.out.println("生成data-config.xml失败");
         }

    }
}
