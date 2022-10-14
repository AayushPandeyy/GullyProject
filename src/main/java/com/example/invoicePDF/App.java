package com.example.invoicePDF;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class App {
	public static void main(String[] args) throws IOException {
		PDDocument myPDF = new PDDocument();
		PDPage newpage = new PDPage();
		myPDF.addPage(newpage);
		PDPage mypage = myPDF.getPage(0);
		PDPageContentStream cs = new PDPageContentStream(myPDF , mypage);
		cs.beginText();
		cs.setFont(PDType1Font.TIMES_ROMAN	, 18);
		cs.newLineAtOffset(150, 750);
		cs.showText("Gully Momo");
		cs.endText();
		cs.close();
		myPDF.save("hello.pdf");
		
	}
}
