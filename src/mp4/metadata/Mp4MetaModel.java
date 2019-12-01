package mp4.metadata;

import org.apache.tika.metadata.Metadata;

import common.metadata.MetaModel;

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
public class Mp4MetaModel extends MetaModel {

	public Mp4MetaModel() {

	}

	public Mp4MetaModel(Metadata metadata) {
		String[] metadataNames = metadata.names();

		for (String name : metadataNames) {
			String meta = metadata.get(name);
			// System.out.println(name + " : " + meta);
			switch (name) {
			case "Content-Type":
				this.setContentType(meta);
				break;
			case "xmpDM:duration":
				this.setDuration(meta);
				break;
			case "xmpDM:audioSampleRate":
				this.setAudioSampleRate(meta);
				break;
			case "tiff:ImageWidth":
				this.setWidth(meta);
				break;
			case "tiff:ImageLength":
				this.setImageLength(meta);
				break;
			default:
				break;
			}
		}
	}
}
