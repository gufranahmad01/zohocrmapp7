package com.zoho.pdf;
import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.zoho.entities.Billing;

public class UserPDFExporter {
    private Billing listUsers;
     
    public UserPDFExporter(Billing listUsers) {
        this.listUsers = listUsers;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);
         
        cell.setPhrase(new Phrase("ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Amount", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("First Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Last Name", font));
        table.addCell(cell);
        
       
         
        cell.setPhrase(new Phrase("Mobile", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("Product", font));
        table.addCell(cell);
         
        
    }
     
    private void writeTableData(PdfPTable table) {

    	  table.addCell(String.valueOf(listUsers.getInvoiceNumber()));
	      table.addCell(String.valueOf(listUsers.getAmount()));
	      table.addCell(listUsers.getEmail());
	      table.addCell(listUsers.getFirstName());
	      table.addCell(listUsers.getLastName());
	      table.addCell(String.valueOf(listUsers.getMobile()));
	      table.addCell(listUsers.getProduct());
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Billing ", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1f, 2f, 3f, 3f, 2f, 3f, 3f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
