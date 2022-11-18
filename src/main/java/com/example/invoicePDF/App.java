package com.example.invoicePDF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import model.BilledProduct;
import model.BilledProductDao;
import model.Product;

public class App {
	public static void main(String[] args) throws IOException {
		ArrayList<BilledProduct> items = new com.example.complete_project.ProductCard().billItems;
		String title = "Gully Momo"; 
		int marginTop = 30; 
		Calendar cal = new GregorianCalendar();
        int  HH = cal.get(Calendar.HOUR_OF_DAY);
        int  MIN = cal.get(Calendar.MINUTE);
        int  DD = cal.get(Calendar.DAY_OF_MONTH);
        int MXN= cal.get(Calendar.MONTH);	
        int YY = cal.get(Calendar.YEAR);	
        int MON = MXN+1;
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		PDPage mypage = document.getPage(0);
		BilledProductDao bpdao = new BilledProductDao();
		ArrayList<BilledProduct> bp = new ArrayList<>();
		PDPageContentStream stream = new PDPageContentStream(document, mypage);
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 20);
		stream.newLineAtOffset(250, 750);
		stream.showText(title);
		stream.endText();
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 16);
		stream.newLineAtOffset(160, 720);
		stream.showText("Indradev Hall Marg , Narayanghat , Chitwan");
		stream.endText();
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(10+100, 690);
		stream.showText("SN");
		stream.endText();
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(90+100, 690);
		stream.showText("ITEM");
		stream.endText();
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(140+180, 690);
		stream.showText("PRICE");
		stream.endText();
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(220+180, 690);
		stream.showText("QUANTITY");
		stream.endText();
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(500, 690);
		stream.showText("AMOUNT");
		stream.endText();
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(50, 735);
		stream.showText("PAN No : 109737522");
		stream.endText();
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(450, 740);
		stream.showText("Phone No : 9847767153");
		stream.endText();
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(500, 710);
		stream.showText("Date : "+String.valueOf(DD)+"-"+String.valueOf(MON)+"-"+String.valueOf(YY));
		stream.endText();
		
		int sn=1;
		int y=670;
		for(BilledProduct bpp  : items) {
			stream.beginText();
			stream.setFont(PDType1Font.TIMES_ROMAN, 10);
			stream.newLineAtOffset(10+100, y);
			stream.showText(String.valueOf(sn));
			stream.endText();
			
			stream.beginText();
			stream.setFont(PDType1Font.TIMES_ROMAN, 10);
			stream.newLineAtOffset(90+100, y);
			stream.showText(bpp.getName());
			stream.endText();
			
			stream.beginText();
			stream.setFont(PDType1Font.TIMES_ROMAN, 10);
			stream.newLineAtOffset(140+180, y);
			stream.showText(String.valueOf(bpp.getPrice()));
			stream.endText();
			
			stream.beginText();
			stream.setFont(PDType1Font.TIMES_ROMAN, 10);
			stream.newLineAtOffset(220+180, y);
			stream.showText(String.valueOf(bpp.getQuantity()));
			stream.endText();
			
			stream.beginText();
			stream.setFont(PDType1Font.TIMES_ROMAN, 10);
			stream.newLineAtOffset(500, y);
			stream.showText(String.valueOf(bpp.getPrice()*bpp.getQuantity()	));
			stream.endText();	
			y-=20;
			sn++;
		}
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(0, y-40);
		stream.showText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		stream.endText();
		y-=100;
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(400, y);
		stream.showText("By : "+com.example.paymentMethod.paymentPanel.method);
		stream.endText();
		y-=20;
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(400, y);
		stream.showText("Total : "+com.example.discount.discountButtons.total);
		stream.endText();
		y-=20;
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(400, y);
		stream.showText("Discount : "+com.example.discount.discountButtons.disAmount);
		stream.endText();
		y-=20;
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(400, y);
		stream.showText("VAT (13%) included in menu price.");
		stream.endText();
		y-=20;
		
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 10);
		stream.newLineAtOffset(400, y);
		stream.showText("GRAND TOTAL : "+com.example.discount.discountButtons.gTotal);
		stream.endText();
		y-=20;
		
		stream.close();
		document.save("Bill.pdf");
	}
}
