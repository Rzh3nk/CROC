import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * Класс для записи ответа в XML файл
 *
 * @author Evgeniy Shvecov
 */
public class WriteToXML {
    /**
     * Метод для записи ответа на первое задание
     * @param quantity хэшмап с ответом (название продукта, его количество)
     * @throws FileNotFoundException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static void First(HashMap<String, Integer> quantity) throws FileNotFoundException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("Total_quantity");
        document.appendChild(root);
        quantity.forEach((key,value)-> {
            Element product = document.createElement("Product");
            Element name = document.createElement("Product_name");
            Element quant = document.createElement("Quantity");
            Text prodText = document.createTextNode(key);
            Text text2 = document.createTextNode(""+value);
            root.appendChild(product);
            product.appendChild(name);
            name.appendChild(prodText);
            product.appendChild(quant);
            quant.appendChild(text2);
        });
        write(document,"files/First.xml");
    }
    /**
     * Метод для записи ответа на второе задание
     * @param avg хэшмап с ответом (дата сделки, среднее количество проданного товара в этот день)
     * @throws FileNotFoundException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static void Second(HashMap<LocalDate,Double> avg) throws FileNotFoundException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("Day_average");
        document.appendChild(root);
        avg.forEach((key,value)-> {
            Element product = document.createElement("Day");
            Element name = document.createElement("Date");
            Element quant = document.createElement("Average");
            Text prodText = document.createTextNode(""+key);
            Text text2 = document.createTextNode(""+value);
            root.appendChild(product);
            product.appendChild(name);
            name.appendChild(prodText);
            product.appendChild(quant);
            quant.appendChild(text2);
        });
        write(document,"files/Second.xml");
    }

    /**
     * Метод для создания XML файла и щаписи в него наших данных
     * @param document данные с ответом
     * @param file файл в который записываем
     * @throws TransformerException
     * @throws FileNotFoundException
     */
    public static void write(Document document,String file) throws TransformerException, FileNotFoundException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(file)));
    }
}
