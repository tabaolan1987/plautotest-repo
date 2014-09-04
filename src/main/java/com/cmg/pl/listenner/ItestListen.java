package com.cmg.pl.listenner;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.c_mg.pl.selenium.PLAUTOTEST.PropertiesHelper;
import com.c_mg.pl.selenium.PLAUTOTEST.TakeScreenShot;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItestListen implements ITestListener {

	/**
	 * Document
	 */
	private Document document = null;

	/**
	 * PdfPTables
	 */
	PdfPTable successTable = null;

	/**
	 * PdfPTables
	 */
	PdfPTable failTable = null;

	/**
	 * PdfPTables
	 */
	PdfPTable skipTable = null;

	/**
	 * throwableMap
	 */
	private HashMap<Integer, Throwable> throwableMap = null;

	/**
	 * nbExceptions
	 */
	private int nbExceptions = 0;


	public void onTestSuccess(ITestResult result) {
		PdfPCell cell = new PdfPCell(new Paragraph(result.getTestClass()
				.toString()));
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(""
				+ (result.getEndMillis() - result.getStartMillis())));
		this.successTable.addCell(cell);

		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;
			Paragraph excep = new Paragraph(
					new Chunk(throwable.toString(), new Font(Font.TIMES_ROMAN,
							Font.DEFAULTSIZE, Font.UNDERLINE)).setLocalGoto(""
							+ throwable.hashCode()));
			cell = new PdfPCell(excep);
			this.successTable.addCell(cell);
		} else {
			this.successTable.addCell(new PdfPCell(new Paragraph("")));
		}
	}

	public void onTestFailure(ITestResult result) {
		String path = "";
		try {
			File file = TakeScreenShot.takeSnapshot();
			if (file != null && file.exists()) {
				System.out.println("file not null");
				path = file.getAbsolutePath();
			}
		} catch (Exception e) {
		}
		System.out.println("path file : " + path);

		PdfPCell cell = new PdfPCell(new Paragraph(result.getTestClass()
				.toString()));
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(""
				+ (result.getEndMillis() - result.getStartMillis())));
		this.failTable.addCell(cell);
		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;
			Chunk imdb = new Chunk("[SCREEN SHOT]", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.UNDERLINE));
			imdb.setAction(new PdfAction("file:///" + path));
			Paragraph excep = new Paragraph(throwable.toString());
			excep.add(imdb);
			cell = new PdfPCell(excep);
			this.failTable.addCell(cell);
		} else {
			this.failTable.addCell(new PdfPCell(new Paragraph("")));
		}

	}

	public void onTestSkipped(ITestResult result) {
		String path = "";
		try {
			File file = TakeScreenShot.takeSnapshot();
			if (file != null) {
				path = file.getAbsolutePath();
			}
		} catch (Exception e) {
		}

		PdfPCell cell = new PdfPCell(new Paragraph(result.getTestClass()
				.toString()));
		this.skipTable.addCell(cell);
		cell = new PdfPCell(new Paragraph(""
				+ (result.getEndMillis() - result.getStartMillis())));
		this.skipTable.addCell(cell);
		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
			this.nbExceptions++;
			Chunk imdb = new Chunk("[SCREEN SHOT]", new Font(Font.TIMES_ROMAN,
					Font.DEFAULTSIZE, Font.UNDERLINE));
			imdb.setAction(new PdfAction("file:///" + path));
			Paragraph excep = new Paragraph(throwable.toString());
			excep.add(imdb);
			cell = new PdfPCell(excep);
			this.skipTable.addCell(cell);
		} else {
			this.skipTable.addCell(new PdfPCell(new Paragraph("")));
		}

	}

	public void onFinish(ITestContext context) {
		try {
			
			if (this.successTable != null) {
				this.successTable.setSpacingBefore(20f);
				this.document.add(this.successTable);
				this.successTable.setSpacingBefore(20f);
			}
			
			if (this.failTable != null) {
				this.failTable.setSpacingBefore(20f);
				this.document.add(this.failTable);
				this.failTable.setSpacingAfter(20f);
			}
			
			if(this.skipTable!=null){
				this.skipTable.setSpacingBefore(20f);
				this.document.add(this.skipTable);
				this.successTable.setSpacingBefore(20f);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		Set<Integer> keys = this.throwableMap.keySet();
		
		if(keys.size() > 0){
			Paragraph p = new Paragraph("EXCEPTIONS SUMMARY", FontFactory.getFont(
					FontFactory.HELVETICA, 16, Font.BOLD, new Color(255, 0, 0)));
			try {
				this.document.add(p);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
			
			assert keys.size() == this.nbExceptions;

			for (Integer key : keys) {
				Throwable throwable = this.throwableMap.get(key);

				Chunk chunk = new Chunk(throwable.toString(), FontFactory.getFont(
						FontFactory.HELVETICA, 12, Font.BOLD, new Color(255, 0, 0)));
				chunk.setLocalDestination("" + key);
				Paragraph throwTitlePara = new Paragraph(chunk);
				try {
					this.document.add(throwTitlePara);
				} catch (DocumentException e3) {
					e3.printStackTrace();
				}

				StackTraceElement[] elems = throwable.getStackTrace();
				for (StackTraceElement ste : elems) {
					Paragraph throwParagraph = new Paragraph(ste.toString());
					try {
						this.document.add(throwParagraph);
					} catch (DocumentException e2) {
						e2.printStackTrace();
					}
				}
			}
		}
		
		System.out.println("close doc : " + context.getName());
		this.document.close();

	}

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		
		this.document = new Document();
		this.throwableMap = new HashMap<Integer, Throwable>();
		System.out.println("start create " + context.getName());
		String name = context.getName();
		System.out.println("create new pdf for : " + name);
		String pathFilePDF = PropertiesHelper.getKey(TakeScreenShot.PROP_PROJECT_BUILD_DIR)
				+ File.separator + "PDF Report";
		File f = new File(pathFilePDF);
		if (!f.exists() || !f.isDirectory()) {
			f.mkdirs();
		}
		System.out.println("pathFilePDF : " + pathFilePDF);
		try {
			PdfWriter.getInstance(this.document, new FileOutputStream(pathFilePDF +File.separator+ name + ".pdf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.document.open();

		Paragraph p = new Paragraph(name + " RESULTS",
				FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD,
						new Color(0, 0, 255)));

		try {
			this.document.add(p);
			this.document.add(new Paragraph(new Date().toString()));
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		
		//init success table
		createSuccessTable();
		//init fail table
		createFailTable();
		//init skipped table
		createSkippTable();
		this.nbExceptions = 0;
	}
	public void createSkippTable(){
		this.skipTable = new PdfPTable(new float[] { .3f, .2f, .2f, .3f });
		this.skipTable.setTotalWidth(20f);
		Paragraph p = new Paragraph("Skipped TESTS", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		p.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell = new PdfPCell(p);
		cell.setColspan(4);
		cell.setBackgroundColor(Color.YELLOW);
		this.skipTable.addCell(cell);

		cell = new PdfPCell(new Paragraph("Class"));
		cell.setBackgroundColor(Color.BLUE);
		this.skipTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("Time (ms)"));
		cell.setBackgroundColor(Color.BLUE);
		this.skipTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("Exception"));
		cell.setBackgroundColor(Color.BLUE);
		this.skipTable.addCell(cell);
	}
	public void createFailTable(){
		this.failTable = new PdfPTable(new float[] { .3f, .2f, .2f, .3f });
		this.failTable.setTotalWidth(20f);
		Paragraph p = new Paragraph("FAILED TESTS", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		p.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell = new PdfPCell(p);
		cell.setColspan(4);
		cell.setBackgroundColor(Color.RED);
		this.failTable.addCell(cell);

		cell = new PdfPCell(new Paragraph("Class"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("Time (ms)"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		this.failTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("Exception"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		this.failTable.addCell(cell);
	}
	
	public void createSuccessTable(){
		this.successTable = new PdfPTable(
				new float[] { .3f, .2f, .2f, .3f });
		Paragraph p = new Paragraph("PASSED TESTS", new Font(
				Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD));
		p.setAlignment(Element.ALIGN_CENTER);
		PdfPCell cell = new PdfPCell(p);
		cell.setColspan(4);
		cell.setBackgroundColor(Color.GREEN);
		this.successTable.addCell(cell);

		cell = new PdfPCell(new Paragraph("Class"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("Time (ms)"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		this.successTable.addCell(cell);
		cell = new PdfPCell(new Paragraph("Exception"));
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		this.successTable.addCell(cell);
	}

}
