package main;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp4.MP4Parser;
import org.apache.tika.sax.BodyContentHandler;

import mp4.metadata.Mp4MetaModel;
import mp4.metadata.Mp4MetaReader;


public class Main {
//	private static String path = "C:\\Users\\kingrome\\Downloads\\È£ÅÚ µ¨·ç³ª.E11.190817.720p-NEXT.mp4";
	private static String path = "C:\\Users\\kingrome\\Downloads\\È£ÅÚ µ¨·ç³ª.E06.190728.1080p-MreD.mp4";
	
	public static void main(String[] args) {
		Mp4MetaReader reader = new Mp4MetaReader(path);
		Metadata metadata = reader.getMetadata();
		
		Mp4MetaModel model = new Mp4MetaModel(metadata);
		System.out.println(model.toString());
	}

	public static void getMetadata() {
		try {
			File f = new File(path);
			// detecting the file type
			BodyContentHandler handler = new BodyContentHandler();
			Metadata metadata = new Metadata();
			FileInputStream inputstream = new FileInputStream(f);
			ParseContext pcontext = new ParseContext();

			// Html parser
			MP4Parser MP4Parser = new MP4Parser();
			MP4Parser.parse(inputstream, handler, metadata, pcontext);
			System.out.println("Contents of the document:  :" + handler.toString());
			System.out.println("Metadata of the document:");
			String[] metadataNames = metadata.names();

			for (String name : metadataNames) {
				System.out.println(name + ": " + metadata.get(name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mimeType() {
		try {

			Path source = Paths.get(path);

			String mimeType = Files.probeContentType(source);

			System.out.println(mimeType);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
