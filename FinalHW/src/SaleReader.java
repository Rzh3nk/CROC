import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
/**
 * Класс для чтения из файла информации о продажах
 *
 * @author Evgeniy Shvecov
 */
public class SaleReader {
    /**
     * Метод для считывания данных из файла
     * @param map для записи результата
     * @param file считываемый файл
     * @return метод для чтения содержимого в элементах файла, который вернет HashMap
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static HashMap<Integer, Sale> read(HashMap<Integer, Sale> map, String file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document =  builder.parse(file);
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getChildNodes();
        return progEl(nodeList,map);
    }
    /**
     * Метод для чтения содержимого элементов файла
     * @param nodeList элементы файла
     * @param map куда считываем
     * @return HashMap с записанными данными
     */
    public static HashMap<Integer, Sale> progEl(NodeList nodeList,HashMap<Integer, Sale> map) {
        int idSale=0;
        int idSeller=0;
        int idProduct=-1;
        int quantity=0;
        LocalDate date = LocalDate.parse("2000-01-01");
        for (int i = 0; i< nodeList.getLength();i++){
            if(nodeList.item(i) instanceof Element){
                if (nodeList.item(i).hasChildNodes()){
                    progEl(nodeList.item(i).getChildNodes(),map);
                }
                if(!nodeList.item(i).getTextContent().trim().isEmpty()
                        && !((Text)nodeList.item(i).getFirstChild()).getData().trim().isEmpty()
                        && !((Text)nodeList.item(i).getFirstChild()).getData().trim().equals("\n"))
                {
                    Text text = (Text)nodeList.item(i).getFirstChild();

                    if (i==1) {
                        idSale=Integer.parseInt(text.getData().trim());
                    }
                    else if (i==3) {
                        idSeller=Integer.parseInt(text.getData().trim());
                    }
                    else if (i==5) {
                        idProduct = Integer.parseInt(text.getData().trim());
                    }
                    else if (i==7) {
                        quantity = Integer.parseInt(text.getData().trim());
                    }
                    else if (i==9) {
                        date = LocalDate.parse(text.getData().trim());
                    }
                }
            }

        }
        if (idProduct!=-1){
            Sale p = new Sale(idSale, idSeller, idProduct, quantity, date);
            map.put(idSale,p);
        }
        return map;
    }
}
