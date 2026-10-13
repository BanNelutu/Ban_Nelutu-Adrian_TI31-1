import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

void main() throws Exception{
    Integer nrFis = 2917;
   for (nrFis=2917; nrFis<5698;nrFis++){
        String path = "C:\\Users\\nelut\\IdeaProjects\\Ban_Nelutu-Adrian_TI31-1\\LabExtragere\\src\\Reuters\\Reuters_34\\Training\\"+nrFis.toString()+"NEWS.XML";
        int nrFisiere=0;
        File xmlFile = new File(path);
        if(xmlFile.exists()){
            File textFisier = new File(nrFis.toString()+"NEWS.txt");
            FileWriter myWriter = new FileWriter(nrFis.toString()+"NEWS.txt");

            if(textFisier.createNewFile()){

                System.out.println("Fisierul cu nr "+nrFisiere++ +" a fost creat");
            }

            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(xmlFile);

            // Access elements by tag name
            NodeList titlelist = document.getElementsByTagName("title");
            Node title  = titlelist.item(0);
            String finishTitle= title.getTextContent().toLowerCase();
            myWriter.write(scoatePunctuatie(finishTitle));
            myWriter.write("\n");


            NodeList nodeList = document.getElementsByTagName("p");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                String text = node.getTextContent().toLowerCase();
                myWriter.write(scoatePunctuatie(text));
                myWriter.write("\n");
            }
            myWriter.close();
        }
   }
}
char[] scoatePunctuatie(String text) {
    String plus = "<>*&^%$#@!`~*,.?/;:{}123456789'0|+=-_(){}[]\\\"";
    char[] puctuatie = plus.toCharArray();
    boolean ePunctuatie = true;
    char[] finish = text.toCharArray();
    char[] gata =new char[text.length()];
    char[] v2finish;
    int indexGata = 0;

    for (int y = 0; y < text.length() - 1; ) {
        for (int j = 0; j < puctuatie.length; j++) {
            if (finish[y] != puctuatie[j]) ePunctuatie = false;
            else {
                ePunctuatie = true;
                break;
            }
        }
        if (ePunctuatie) y++;
        else gata[indexGata++] = finish[y++];
    }
    v2finish= new char[indexGata];

    for(int i=0; i<indexGata;i++){
        v2finish[i]=gata[i];
    }
    return v2finish;
}
