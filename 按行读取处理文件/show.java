package fristJave;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class show {

	public static void main(String[] args) throws IOException {
		File file = new File("/Users/hugb/Desktop/danci.txt");
		File file1 = new File("/Users/hugb/Desktop/danci1.txt");

		// 写入中文字符时解决中文乱码问题
		FileOutputStream fos = new FileOutputStream(file1);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		ArrayList<String> strArray = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			String str = line;
			String pattern = "^\\d+\\.";
			Pattern r = Pattern.compile(pattern);
			// 现在创建 matcher 对象
			Matcher m = r.matcher(str);
			String tempStr = "";
			if (m.find()) {
				tempStr = m.group(0);
				if ((line = br.readLine()) != null) {
					line = line.replaceAll("/.+/", "");
					tempStr = tempStr.concat(line);
				}

				strArray.add(tempStr);
			} else {

			}
		}
		sort(strArray);
		for (int i = 0; i < strArray.size(); i++) {
			if (i >= 30) {
				break;
			}
			String str = strArray.get(i);
			bw.write(str);
			bw.write("\n");
		}
		br.close();
		bw.close();
	}

	public static void sort(ArrayList<String> array) {
		Random random = new Random();
		for (int i = 0; i < array.size(); i++) {
			int p = random.nextInt(i + 1);
			System.out.println("i===" + i + "p===" + p);
			String tmp = array.get(i);
			array.set(i, array.get(p));
			array.set(p, tmp);
		}
		printArr(array);
	}

	public static void printArr(ArrayList<String> array) {
		for (String str : array) {
			System.out.print(str);
		}
	}
}

