package DomGeneratorXml.util.element.generator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author huyuanxin
 * @create 2020/12/10 9:27
 */
public class EntityElementGenerator {
    public static Element createEntityElement(Document document) {
        System.out.println("生成entity中");
        try {
            Element entity = document.createElement("entity");
            entity.setAttribute("name", "demo");
            entity.setAttribute("dataSource", "demo");
            entity.setAttribute("query", "Select uid,`Name`,`Desc`,create_time,Age From demo");
            entity.setAttribute("deltaImportQuery", "Select uid,`Name`,`Desc`,create_time,age From demo where uid='${dataimporter.delta.id}'");
            entity.setAttribute("deltaQuery", "select uid from demo where create_time > '${dataimporter.last_index_time}'");
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成entity失败");
        }
        System.out.println("生成entity成功");
        return document.createElement("entity");
    }
}
