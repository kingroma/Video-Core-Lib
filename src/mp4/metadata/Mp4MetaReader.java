package mp4.metadata;

import java.io.File;
import java.io.FileInputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp4.MP4Parser;
import org.apache.tika.sax.BodyContentHandler;

/**
	Contents of the document:  :MH ENCODER
	Metadata of the document:
	date: 1904-01-01T00:00:00Z
	xmp:CreatorTool: MH ENCODER
	meta:creation-date: 1904-01-01T00:00:00Z
	Creation-Date: 1904-01-01T00:00:00Z
	tiff:ImageLength: 720
	dcterms:created: 1904-01-01T00:00:00Z
	dcterms:modified: 1904-01-01T00:00:00Z
	Last-Modified: 1904-01-01T00:00:00Z
	Last-Save-Date: 1904-01-01T00:00:00Z
	xmpDM:audioSampleRate: 1000
	meta:save-date: 1904-01-01T00:00:00Z
	modified: 1904-01-01T00:00:00Z
	tiff:ImageWidth: 1280
	xmpDM:duration: 4701.89
	Content-Type: application/mp4
 */
public class Mp4MetaReader {
	private String path = null;
	
	public Mp4MetaReader(String path){
		this.path = path ; 
	}
	
	public Metadata getMetadata(){
		Metadata metadata = null ;
		try {
			File f = new File(path);
			 
			BodyContentHandler handler = new BodyContentHandler();
			metadata = new Metadata();
			FileInputStream inputstream = new FileInputStream(f);
			ParseContext pcontext = new ParseContext();

			MP4Parser MP4Parser = new MP4Parser();
			MP4Parser.parse(inputstream, handler, metadata, pcontext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return metadata;
	}
	
	public void printMeatadata(String path){
		try {
			File f = new File(path);
 
			BodyContentHandler handler = new BodyContentHandler();
			Metadata metadata = new Metadata();
			FileInputStream inputstream = new FileInputStream(f);
			ParseContext pcontext = new ParseContext();

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
}
