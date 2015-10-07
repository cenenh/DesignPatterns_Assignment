import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c;
		int offset = 1;
		byte [] buffer = new byte[4096];
		System.out.println("Using read() method...");
		try {
			InputStream in = new ShiftInputStream(
								new BufferedInputStream(
									new FileInputStream("datafiles.txt")), offset);
			try {
				while((c = in.read()) >= 0){
					System.out.print((char)c);
				}
				System.out.println();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println();
		System.out.println("Using read(byte[] b) method...");
		try {
			InputStream byte_in = new ShiftInputStream(
									new BufferedInputStream(
											new FileInputStream("datafiles.txt")), offset);
			try {
				while (byte_in.read(buffer) >= 0){
					String result = new String(buffer);
					System.out.println(result);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
