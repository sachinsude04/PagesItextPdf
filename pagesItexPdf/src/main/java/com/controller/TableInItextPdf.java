package com.controller;

import java.io.FileOutputStream;



import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class TableInItextPdf {

	      static String file = "C:\\Users\\Sachin Sude\\Desktop\\\\temp/barcode786.pdf"; 

	

	      public static void main(String[] args) throws DocumentException {
	          try {
	              Document document = new Document();
	              PdfWriter.getInstance(document, new FileOutputStream(file));
	              document.open();
	             
	              addContent(document);
	              document.close();
	          } catch (Exception e) {
	              e.printStackTrace();
	          }
	      }

	     	    
	      private static void addContent(Document document) throws DocumentException {
	    	  Paragraph paragraph = new Paragraph();
				paragraph.add("Date:4/4/2018");
				paragraph.setAlignment(Element.ALIGN_RIGHT);
				Paragraph subpara=new Paragraph();
				subpara.add("#425689");
				subpara.setAlignment(Element.ALIGN_RIGHT);
				

	        	// add a table
				createTableToFrom(paragraph);
	          createTable(paragraph);
	          
	           Paragraph paragraph2 = new Paragraph();
				paragraph2.add("Subtotal	$1,000\r\n" + 
						"Tax	$70\r\n" + 
						"Shipping	$30\r\n" + 
						"Total\r\n" + 
						"$1,100\r\n" + 
						"");
				paragraph2.setAlignment(Element.ALIGN_RIGHT);

				Paragraph paragraph3=new Paragraph();
				paragraph3.setAlignment(Element.ALIGN_LEFT);
			paragraph3.add("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede. Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis.");
	          // now add all this to the document
	          document.add(subpara);
	          document.add(paragraph);
	          document.add(paragraph2);	
	          document.add( Chunk.NEWLINE );
	          document.add(new Paragraph("Note:"));
	          document.add(paragraph3);
	      }

	      private static void createTableToFrom(Paragraph paragraph)
	              throws BadElementException {
	          PdfPTable table = new PdfPTable(2);
	          PdfPCell c1 = new PdfPCell(new Phrase("To"));
	          c1.setBorder(Rectangle.NO_BORDER);
	          
	          c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	          table.addCell(c1);
	          c1 = new PdfPCell(new Phrase("From"));
	          c1.setBorder(Rectangle.NO_BORDER);
	          c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	          
	          table.addCell(c1);
	          table.setHeaderRows(1);
	          table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
	          table.addCell("John Smith Corp.\r\n" + 
	          		"\r\n" + 
	          		"1234 Main Street\r\n" + 
	          		"Suite 37\r\n" + 
	          		"Washington, D.C. 20007\r\n" + 
	          		"202.555.5555\r\n" + 
	          		"johnsmith@gmail.com");
	          table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
	          table.addCell("Sharp & Nimble\r\n" + 
	          		"\r\n" + 
	          		"1234 Main Street\r\n" + 
	          		"Floor 2\r\n" + 
	          		"Baltimore, MD 30010\r\n" + 
	          		"301.555.5555\r\n" + 
	          		"sharpandnimble@gmail.com");
	          table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
	          paragraph.add(table);
	          paragraph.add(Chunk.NEWLINE);
	          
	      }
	      
	      private static void createTable(Paragraph paragraph)
	              throws BadElementException {
	          PdfPTable table = new PdfPTable(5);

	          // t.setBorderColor(BaseColor.GRAY);
	          // t.setPadding(4);
	          // t.setSpacing(4);
	          // t.setBorderWidth(1);

	          PdfPCell c1 = new PdfPCell(new Phrase("Total_items"));
	          c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	          table.addCell(c1);
	          
	          c1 = new PdfPCell(new Phrase("Product"));
	          c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	          table.addCell(c1);

	          c1 = new PdfPCell(new Phrase("Qty"));
	          c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	          table.addCell(c1);

	          c1 = new PdfPCell(new Phrase("Unit Price"));
	          c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	          table.addCell(c1);
	          
	          c1 = new PdfPCell(new Phrase("Total"));
	          c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	          table.addCell(c1);
	          table.setHeaderRows(1);

	          table.addCell("1");
	          table.addCell("Product_Name");
	          table.addCell("2");
	          table.addCell("50");
	          table.addCell("100");
	          table.addCell("2");
	          table.addCell("PD");
	          table.addCell("4");
	          table.addCell("150");
	          table.addCell("600");
	          paragraph.add(table);

	      }

	     
}
