import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws Exception{
    String plus=",.?/;:{}123456789'0|+=-_(){}[]";
    char[] puctuatie= plus.toCharArray();
    Integer nrFis = 2917;
    String path = "C:\\Users\\nelut\\IdeaProjects\\Ban_Nelutu-Adrian_TI31-1\\LabExtragere\\src\\Reuters\\Reuters_34\\Training\\"+nrFis.toString()+"NEWS.XML";
int nrFisiere=0;    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    File xmlFile = new File(path);
    File textFisier = new File(nrFis.toString()+"NEWS.txt");
    FileWriter myWriter = new FileWriter(nrFis.toString()+"NEWS.txt");
    if(textFisier.createNewFile()){
        nrFisiere++;
        System.out.println("Fisierul cu nr "+nrFisiere +" a fost creat");
    }

    // Create a DocumentBuilder
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    // Parse the XML file
    Document document = builder.parse(xmlFile);

    // Access elements by tag name
    NodeList titlelist = document.getElementsByTagName("title");
    Node title  = titlelist.item(0);
    String finishTitle= title.getTextContent();
    int nrlitere= finishTitle.length();
    char[] finish = finishTitle.toCharArray();
    myWriter.write(finish.toString().toLowerCase());
    for(int y =0;y<nrlitere-1;y++){
        for(int j=0;j<puctuatie.length-1;j++){
        if(finish[y]==puctuatie[j]){
            finish[y]=' ';
            j=0;
        }
        }

    }

    myWriter.write(finish.toString().toLowerCase());
    NodeList nodeList = document.getElementsByTagName("p");
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node node = nodeList.item(i);
        myWriter.write(node.getTextContent().toLowerCase());
    }


    myWriter.close();
}
