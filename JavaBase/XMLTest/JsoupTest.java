package XMLTest;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupTest {
    public static void main(String[] args) throws IOException, NullPointerException, XpathSyntaxErrorException {
        String path = JsoupTest.class.getClassLoader().getResource("XMLTest/dtd/student.xml").getPath();
        System.out.println(path);
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByTag("name");
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);

        System.out.println("==============\r\n");
        Elements elements1 = document.select("name");
        System.out.println(elements1);


        System.out.println("==============\r\n");
        Elements elements2 = document.select("student[number='0002']");
        System.out.println(elements2);

        System.out.println("==============\r\n");
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode node : jxNodes) {
            System.out.println(node);
        }

        System.out.println("==============\r\n");
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode node : jxNodes1) {
            System.out.println(node);
        }

        System.out.println("==============\r\n");
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id='111']");
        for (JXNode node : jxNodes2) {
            System.out.println(node);
        }
    }
}
