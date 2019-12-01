package common.metadata;

public class MetaModel {
	private String contentType = null ; 
	private String metaType = null ;
	private String imageLength = null ; 
	private String width = null ;
	private String height = null ; 
	private String duration = null ;
	private String audioSampleRate = null ; 
	
	public String getMetaType() {
		return metaType;
	}
	public void setMetaType(String metaType) {
		this.metaType = metaType;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getAudioSampleRate() {
		return audioSampleRate;
	}
	public void setAudioSampleRate(String audioSampleRate) {
		this.audioSampleRate = audioSampleRate;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getImageLength() {
		return imageLength;
	}
	public void setImageLength(String imageLength) {
		this.imageLength = imageLength;
	} 
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("AudioSampleRate : ");
		sb.append(this.getAudioSampleRate());
		sb.append("\n");
		sb.append("ContentType : ");
		sb.append(this.getContentType());
		sb.append("\n");
		sb.append("Duration : ");
		sb.append(this.getDuration());
		sb.append("\n");
		sb.append("Height : ");
		sb.append(this.getHeight());
		sb.append("\n");
		sb.append("ImageLength : ");
		sb.append(this.getImageLength());
		sb.append("\n");
		sb.append("MetaType : ");
		sb.append(this.getMetaType());
		sb.append("\n");
		sb.append("Width : ");
		sb.append(this.getWidth());
		
		return sb.toString();
	}
}
