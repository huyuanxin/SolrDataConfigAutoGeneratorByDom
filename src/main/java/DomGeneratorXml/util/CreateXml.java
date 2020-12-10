package DomGeneratorXml.util;

import DomGeneratorXml.util.element.generator.DataConfigElementGenerator;
import DomGeneratorXml.util.element.generator.EntityElementGenerator;
import DomGeneratorXml.util.element.generator.FieldElementGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;


/**
 * @author huyuanxin
 * @create 2020/12/10 9:23
 */
public class CreateXml {
    public static void createXml(Document document) {
        try {
            // 设置dataConfig
            Element dataConfig = DataConfigElementGenerator.createDataConfigElement(document);

            // 设置document
            Element doc = document.createElement("document");
            dataConfig.appendChild(doc);
            // 设置entity
            Element entity = EntityElementGenerator.createEntityElement(document);
            // 设置field
            List<Element> elementList = FieldElementGenerator.createFieldList(document);
            for (Element e :
                    elementList
            ) {
                entity.appendChild(e);
            }
            dataConfig.appendChild(entity);

            document.appendChild(dataConfig);
            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();
            // 创建 Transformer对象
            Transformer tf = tff.newTransformer();
            // 输出内容是否使用换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            // 去除<xml version =“1.0”encoding =“UTF-8”/>
            tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            // 创建xml文件并写入内容
            tf.transform(new DOMSource(document), new StreamResult(new File("data-config.xml")));
            System.out.println("生成data-config.xml成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成data-config.xml失败");
        }
    }
}
