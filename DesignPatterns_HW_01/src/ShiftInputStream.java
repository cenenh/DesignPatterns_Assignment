import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ShiftInputStream extends FilterInputStream {
	
	private int offset;
	
	protected ShiftInputStream(InputStream in) {
		// TODO Auto-generated constructor stub
		super(in);
		this.offset = 0;
	}
	
	protected ShiftInputStream(InputStream in, int offset) {
		// TODO Auto-generated constructor stub
		super(in);
		this.offset = offset;
	}
	
	public int read(){
		int c = 0;
		try {
			c = super.read();
			if(c != -1){
				if (Character.isAlphabetic((char) c)){
					if (offset >= 0){
						if (Character.isUpperCase((char) c)) {
							c = ((c - 'A' + offset) % 26 + 'A');
						} else {
							c = ((c - 'a' + offset) % 26 + 'a');
						}
					}
					else{
						if (Character.isUpperCase((char) c)) {
							c = ((c - 'Z' + offset) % 26 + 'Z');
						} else {
							c = ((c - 'z' + offset) % 26 + 'z');
						}
					}
				}	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public int read(byte [] b){
		int result = 0;
		try {
			result = super.read(b);
			for(int i = 0; i < b.length; i++){
				if (Character.isAlphabetic((char) b[i])){
					if (offset >= 0){
						if (Character.isUpperCase((char) b[i])) {
							b[i] = (byte) ((b[i] - 'A' + offset) % 26 + 'A');
						} else {
							b[i] = (byte) ((b[i] - 'a' + offset) % 26 + 'a');
						}
					}
					else{
						if (Character.isUpperCase((char) b[i])) {
							b[i] = (byte) ((b[i] - 'Z' + offset) % 26 + 'Z');
						} else {
							b[i] = (byte) ((b[i] - 'z' + offset) % 26 + 'z');
						}
					}
				}	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
