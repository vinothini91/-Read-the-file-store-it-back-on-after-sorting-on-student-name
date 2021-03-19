package hello;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortingOnStudentName {

	public static void main(String[] args) {
		try {

			File file = new File("F:/vino--programs-2021/student4.txt");

			Path path = Paths.get(file.toString());
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
			BufferedReader reader = new BufferedReader(new FileReader(file));

			Map<String, String> hashmap = new HashMap<String, String>();
			ArrayList<String> studentlist = new ArrayList<String>();

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] studentarray = line.split(" "); 

				Collections.addAll(studentlist, studentarray);

				for (int i = 0; i < studentlist.size(); i++) {

					String studentdata = studentlist.get(i);

					String[] spliteddata = studentdata.split("-");

					for (int j = 0; j < spliteddata.length; j++) {

						String studentname = spliteddata[1];

						hashmap.put(studentname, studentdata);

					}

				}

			}

			System.out.println("Before Sorting student Report:");
			for (Map.Entry studenthashmap : hashmap.entrySet()) {
				System.out.println(studenthashmap.getKey() + " : " + studenthashmap.getValue());
			}

			Map<String, String> map = new TreeMap<String, String>(hashmap);

			System.out.println("After Sorting student Report:");

			for (Map.Entry treemap : map.entrySet()) {
				System.out.println(treemap.getKey() + " : " + treemap.getValue());
			}

			OutputStream student_overwrite = new BufferedOutputStream(Files.newOutputStream(path)); // overwrite in existing file
																									
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (Map.Entry treemap : map.entrySet()) {
				writer.write(treemap.getKey() + " : " + treemap.getValue());
				writer.write("\n");

			}

			writer.close();

			InputStream input = Files.newInputStream(path);
			BufferedReader student_read = new BufferedReader(new InputStreamReader(input));

			String student_line = null;
			System.out.println("READ NEW STUDENT RECORD:");
			while ((student_line = student_read.readLine()) != null) {
				System.out.println(student_line);

			}

		}

		catch (Exception e) {

		}

	}

}
