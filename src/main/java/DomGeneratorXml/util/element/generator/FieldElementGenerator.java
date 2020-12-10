package DomGeneratorXml.util.element.generator;

import DomGeneratorXml.util.database.GetColumnFromDataBase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuanxin
 * @create 2020/12/10 9:28
 */
public class FieldElementGenerator {
    public static Element createField(Document document, String column, String name) {
        Element field = document.createElement("field");
        field.setAttribute("column", column);
        field.setAttribute("name", name);
        return field;
    }

    public static List<Element> createFieldList(Document document) {
        System.out.println("生成field中");
        List<Element> elementList = new ArrayList<>();
        List<String> fieldList = GetColumnFromDataBase.getDataBaseColumn("Demo");
        // 需要设置uid的name为id,因为目前主键设置有点问题
        Element id = createField(document, fieldList.get(0), "id");
        elementList.add(id);
        for (int i = 1; i < fieldList.size(); ++i) {
            Element field = createField(document, fieldList.get(i), fieldList.get(1));
            elementList.add(field);
        }
        System.out.println("生成field成功");

        return elementList;
    }
}
