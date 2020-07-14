package Teste;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class NewClass extends PdfPageEventHelper {

    Font fDados = FontFactory.getFont("Arial", 8, Font.NORMAL);
    Font fDesc = FontFactory.getFont("Arial", 5, Font.NORMAL);//decr
    Font fTitulo = FontFactory.getFont("Arial", 7, Font.BOLD);
    Font ftopo = FontFactory.getFont("Arial", 11, Font.BOLD);
    public void onEndPage(PdfWriter writer, Document document) {
        try {
            document.getPageNumber();
            ColumnText.showTextAligned(writer.getDirectContent(),
            Element.ALIGN_RIGHT, new Phrase("Pag "+writer.getPageNumber(), fDados),
            document.leftMargin() + 800f, 20f, 0);

            String imgUrl = "C:\\Users\\Neide\\Documents\\pbh_logo.png";
            Image imagem = Image.getInstance(imgUrl);

            PdfPTable table = new PdfPTable(new float[]{7f, 30f, 5f, 5F});
            table.setWidthPercentage(100);
            table.setTotalWidth(document.right() - document.left());
            table.setSpacingBefore(20);

            PdfPCell cellImageHeader = new PdfPCell();
            cellImageHeader.setBorder(0);
            cellImageHeader.addElement(imagem);
            cellImageHeader.setVerticalAlignment(Element.ALIGN_CENTER);
            cellImageHeader.setPaddingLeft(0);// distanciamento da imagem da margen da tabela
            cellImageHeader.setPaddingBottom(1f);

            Paragraph paraHeader = new Paragraph("CONTROLE DE PATRULHAMENTO PREVENTIVO MOTORIZADO - GUARDA CIVIL MUNICIPAL", ftopo);
            paraHeader.setLeading(5, 0);// espacamento entre as linha do
            PdfPCell cellHeader = new PdfPCell(paraHeader);
            cellHeader.setPadding(2);
            cellHeader.setBorderWidthTop(0.5f);
            cellHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell3 = new PdfPCell();
            cell3.addElement(new Paragraph("Nº CONTROLE (TRANSPORTE)", fDesc));
            cell3.addElement(new Paragraph("", fDados));
            cell3.setPaddingTop(0);

            PdfPCell cell4 = new PdfPCell();
            cell4.addElement(new Paragraph("DATA", fDesc));
            cell4.addElement(new Paragraph("", fDados));
            cell4.setPaddingTop(0);

            table.addCell(cellImageHeader);
            table.addCell(cellHeader);
            table.addCell(cell3);
            table.addCell(cell4);
//***********************************************************************************************

            PdfPTable table2 = new PdfPTable(new float[]{1f});
            table2.setWidthPercentage(100);
            table2.setTotalWidth(document.right() - document.left());
            table2.setSpacingBefore(20);

            PdfPCell header1 = new PdfPCell(new Paragraph("1 DADOS", fTitulo));
            header1.setBackgroundColor(new Color(220, 220, 220));
            table2.addCell(header1);

            //************************************************************************************
            PdfPTable table1 = new PdfPTable(new float[]{0.3f, 0.4f, 0.2f, 0.2f, 0.3f});
            table1.setWidthPercentage(100);
            table1.setTotalWidth(document.right() - document.left());

            PdfPCell cell = new PdfPCell();

            cell.setPaddingTop(0);
            cell.setRowspan(3);
            cell.addElement(new Paragraph("PLACA DAS VIATURAS", fDesc));
            table1.addCell(cell);

            PdfPCell cel1a = new PdfPCell(new Phrase("a"));
            PdfPCell cel1b = new PdfPCell(new Phrase("b"));
            PdfPCell cel1b2 = new PdfPCell(new Phrase("b2"));
            PdfPCell cel1c = new PdfPCell(new Phrase("c"));
            PdfPCell cel1d = new PdfPCell(new Phrase("d"));
            PdfPCell cel1e = new PdfPCell(new Phrase("e"));
            cel1e.setColspan(2);
            PdfPCell cel1f = new PdfPCell(new Phrase("f"));
            PdfPCell cel1g = new PdfPCell(new Phrase("d"));
            PdfPCell cel1h = new PdfPCell(new Phrase("e"));
            cel1h.setColspan(2);
            PdfPCell cel1i = new PdfPCell(new Phrase("f"));
            PdfPCell cel11 = new PdfPCell(new Phrase("1"));
            PdfPCell cel12 = new PdfPCell(new Phrase("2"));
            PdfPCell cel13 = new PdfPCell(new Phrase("3"));
            cel13.setColspan(2);
            PdfPCell cel14 = new PdfPCell(new Phrase("4"));

            table1.addCell(cel1a);
            table1.addCell(cel1b);
            table1.addCell(cel1b2);
            table1.addCell(cel1c);
            table1.addCell(cel1d);
            table1.addCell(cel1e);
            table1.addCell(cel1f);
            table1.addCell(cel1g);
            table1.addCell(cel1h);
            table1.addCell(cel1i);
            table1.addCell(cel11);
            table1.addCell(cel12);
            table1.addCell(cel13);
            table1.addCell(cel14);

            //Rack Rowspan
            ArrayList tmp = table1.getRows(0, table1.getRows().size());
            table1.getRows().clear();
            table1.getRows().addAll(tmp);
//*********************************************************************************************

            PdfPTable tableLanc = new PdfPTable(new float[]{10f, 50f, 30f, 39f, 30f, 50f});
            tableLanc.setWidthPercentage(100);
            tableLanc.setTotalWidth(document.right() - document.left());

            PdfPCell heade21 = new PdfPCell(new Paragraph("CÓD", fTitulo));
            PdfPCell heade22 = new PdfPCell(new Paragraph("NOME DO PRÓPRIO OU ENDEREÇO DE PATRULHAMENTO (LOGRADOURO, Nº, BAIRRO)", fTitulo));
            PdfPCell heade23 = new PdfPCell(new Paragraph("MOTIVAÇÃO", fTitulo));

            PdfPCell heade24 = new PdfPCell(new Paragraph("ADICIONAM", fTitulo));
            heade24.setBackgroundColor(new Color(220, 220, 220));
            PdfPCell heade25 = new PdfPCell(new Paragraph("CHEGADA", fTitulo));
            heade25.setBackgroundColor(new Color(220, 220, 220));
            PdfPCell heade26 = new PdfPCell(new Paragraph("SAÍDA", fTitulo));
            heade26.setBackgroundColor(new Color(220, 220, 220));

            PdfPTable tablead = new PdfPTable(new float[]{0.1f, 0.1f, 0.1f});
            tablead.setWidthPercentage(100);

            tablead.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            PdfPCell cellHora = new PdfPCell(new Paragraph("HORA", fTitulo));
            cellHora.setBackgroundColor(new Color(220, 220, 220));
            cellHora.setBorder(Rectangle.NO_BORDER);
            cellHora.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellHora.setColspan(3);

            tablead.addCell(cellHora);
            tablead.addCell(heade24);

            tablead.addCell(heade25);

            tablead.addCell(heade26);

            PdfPCell headeh = new PdfPCell();
            headeh.addElement(tablead);

            PdfPCell heade27 = new PdfPCell(new Paragraph("QUANTIDADE PESSOAS ABORDADAS", fTitulo));
            PdfPCell heade28 = new PdfPCell(new Paragraph("OBSERVAÇÕES", fTitulo));

            heade21.setBackgroundColor(new Color(220, 220, 220));
            heade22.setBackgroundColor(new Color(220, 220, 220));
            heade23.setBackgroundColor(new Color(220, 220, 220));

            heade27.setBackgroundColor(new Color(220, 220, 220));
            heade28.setBackgroundColor(new Color(220, 220, 220));

            heade21.setHorizontalAlignment(Element.ALIGN_CENTER);
            heade22.setHorizontalAlignment(Element.ALIGN_CENTER);
            heade23.setHorizontalAlignment(Element.ALIGN_CENTER);
            heade24.setHorizontalAlignment(Element.ALIGN_CENTER);
            heade25.setHorizontalAlignment(Element.ALIGN_CENTER);
            heade26.setHorizontalAlignment(Element.ALIGN_CENTER);
            heade27.setHorizontalAlignment(Element.ALIGN_CENTER);
            heade28.setHorizontalAlignment(Element.ALIGN_CENTER);

            tableLanc.addCell(heade21);
            tableLanc.addCell(heade22);
            tableLanc.addCell(heade23);
            tableLanc.addCell(headeh);
            tableLanc.addCell(heade27);
            tableLanc.addCell(heade28);
//**********************************************************************************

            PdfPTable tableFooter = new PdfPTable(1);
            tableFooter.setWidthPercentage(100);
            tableFooter.setTotalWidth(document.right() - document.left());
            PdfPCell cellFooter = new PdfPCell();

            cellFooter.addElement(new Paragraph("ASSINATURA / BM - RESPONSSÁVEL PELO PREENCHIMENTO"
                    + "( MOTOCICLISTAS EM DUPLA DEVEM REGISTRAR SOMENTE UM CONTROLE E ASSINAR EM CONJUNTO)", fDesc));
            cellFooter.addElement(new Paragraph("\n", fDados));
            tableFooter.addCell(cellFooter);

            table.writeSelectedRows(0, -1, 29, document.top() + 139, writer.getDirectContent());
            table2.writeSelectedRows(0, -1, 30, document.top() + 102, writer.getDirectContent());
            table1.writeSelectedRows(0, -1, 30, document.top() + 90, writer.getDirectContent());
            tableLanc.writeSelectedRows(0, -1, 30, document.top() + 27, writer.getDirectContent());
            tableFooter.writeSelectedRows(0, -1, 30, document.bottom() + 12, writer.getDirectContent());
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws IOException, DocumentException {

        Document doc = new Document(PageSize.A4.rotate(), 30, 20, 169, 45);
        Font fDados = FontFactory.getFont("Arial", 8, Font.NORMAL);
        Font fDesc = FontFactory.getFont("Arial", 5, Font.NORMAL);//decr
        Font fTitulo = FontFactory.getFont("Arial", 7, Font.BOLD);
        Font ftopo = FontFactory.getFont("Arial", 11, Font.BOLD);
        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Neide\\Documents\\Encrypted.pdf"));
          
            Rectangle rect = new Rectangle(30, 30, 800, 500);
            writer.setBoxSize("art", rect);
            NewClass event = new NewClass();

            writer.setPageEvent(event);

            doc.open();
            PdfPTable tableDados = new PdfPTable(new float[]{10f, 50f, 30f, 13f, 13f, 13f, 30f, 50f});
            tableDados.setWidthPercentage(100);
            for (int i = 0; i < 46; i++) {
                PdfPCell cel1Dados1 = new PdfPCell(new Phrase("  "));
                PdfPCell cel1Dados2 = new PdfPCell(new Phrase("  "));
                PdfPCell cel1Dados3 = new PdfPCell(new Phrase("  "));
                PdfPCell cel1Dados4 = new PdfPCell(new Phrase("  "));
                PdfPCell cel1Dados5 = new PdfPCell(new Phrase("  "));
                PdfPCell cel1Dados6 = new PdfPCell(new Phrase("  "));
                PdfPCell cel1Dados7 = new PdfPCell(new Phrase("  "));
                PdfPCell cel1Dados8 = new PdfPCell(new Phrase("  "));

                tableDados.addCell(cel1Dados1);
                tableDados.addCell(cel1Dados2);
                tableDados.addCell(cel1Dados3);
                tableDados.addCell(cel1Dados4);
                tableDados.addCell(cel1Dados5);
                tableDados.addCell(cel1Dados6);
                tableDados.addCell(cel1Dados7);
                tableDados.addCell(cel1Dados8);
            }
            doc.add(tableDados);

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        doc.close();
    }

}
