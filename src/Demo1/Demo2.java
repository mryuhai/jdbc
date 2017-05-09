package Demo1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		fun();
		
//		fun1();
	}

	private static void fun1() throws FileNotFoundException, IOException {
		BufferedReader br= new BufferedReader(new FileReader("F:\\自我练习\\dya_23\\MyUils\\db.properties"));
		BufferedWriter  bw= new BufferedWriter(new FileWriter("d.properties"));
		String lens;
		while((lens=br.readLine())!=null){
			bw.write(lens);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
		System.out.println("复制完成成功！");
	}

	private static void fun() throws FileNotFoundException, IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\自我练习\\dya_23\\MyUils\\db.properties"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("c.properties"));
		byte[] b=new byte[1024];
		int len;
		while((len=bis.read(b))!=-1){
//			System.out.println(new String(b,0,len));
			bos.write(b, 0, len);
		}
		bis.close();
		bos.close();
		System.out.println("复制完成成功！");
	}
}
