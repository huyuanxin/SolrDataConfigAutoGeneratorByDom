package DomGeneratorXml.util.element.generator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author huyuanxin
 * @create 2020/12/10 9:26
 */
public class DataConfigElementGenerator {
    public static Element createDataConfigElement(Document document) {
        System.out.println("生成DataConfig中");
        try {
            Element dataConfig = document.createElement("dataConfig");
            dataConfig.setAttribute("name", "demo");
            dataConfig.setAttribute("driver", "com.mysql.cj.jdbc.Driver");
            dataConfig.setAttribute("url", "jdbc:mysql://127.0.0.1:3306/demo");
            dataConfig.setAttribute("user", "root");
            dataConfig.setAttribute("password", "root");
            System.out.println("生成dataConfig成功");
            return dataConfig;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成DataConfig失败");
        }
        return document.createElement("DataConfig");
    }
}
