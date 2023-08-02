package Prctise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

	public static void main(String[] args) {
		// FileCreation();
		// FileDelete();
		// FileRename();
		// ListAllFilesAndFolders();
		// ListFilesOnly();
		// FileFormat();
		// FileLength() ;
		// Filewriting();
		// filereader();
		// FileReadusingarray();
		FileOperationusingbuff();

	}

	public static void FileCreation() {
		File file = new File("C:\\Users\\admin\\Desktop\\saravanan\\Basics\\practise.txt");
		boolean folder = file.exists();
		if (folder == false) {
			try {
				file.createNewFile();
				System.out.println("file is created successfully");
			} catch (IOException e) {

				System.out.println("file is present with same name");
			}
			System.out.println("file already exists");
		}

	}

	public static void FileDelete() {
		File file = new File("C:\\Users\\admin\\Desktop\\saravanan\\Basics\\practise.txt");

		boolean folder = file.exists();
		file.delete();
		System.out.println("file is deleted" + folder);
	}

	public static void SubFolderCreation() {
		File file = new File("C:\\Users\\admin\\Desktop\\saravanan\\Basics");
		boolean folder = file.exists();
		System.out.println(folder);

		if (folder == false) {
			file.mkdirs();
			System.out.println("subfolder is created");
		} else
			System.out.println("file already exists");
	}

	public static void FileRename() {
		File file = new File("C:\\Users\\admin\\Desktop\\saravanan\\Basics\\practise.txt");
		File rename = new File("C:\\Users\\admin\\Desktop\\saravanan\\Basics\\practise1.txt");
		boolean created = file.renameTo(rename);
		System.out.println("file is renamed " + created);
	}

	public static void ListAllFilesAndFolders() {
		File file = new File("C:\\Users\\admin\\Desktop");
		String[] files = file.list();
		for (String i : files) {
			System.out.println(i);
		}
	}

	public static void ListFilesOnly() {
		File file = new File("C:\\Users\\admin\\Desktop");
		File[] name = file.listFiles();
		for (File i : name)
			if (file.isDirectory())// file.isDirectory();-- to print only folders in the given path

				System.out.println(i);
			else
				System.out.println("it is not present");

	}

	public static void FileFormat() {
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\javaCore\\src\\saravanan04");
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				String name = f.getName();
				int last = name.lastIndexOf(".");
				String extension = name.substring(last + 1);
				if (extension.equals("java"))
					System.out.println(extension);
			}
		}

	}

	public static void FileLength() {
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\javaCore\\src\\saravanan04");
		File f[] = file.listFiles();
		for (File f1 : f) {
			if (f1.isFile()) {

				String name = f1.getName();
				int last = name.indexOf(".");
				String extension = name.substring(last + 1);
				if (extension.equals("java"))
					// also can be used to delete a file with an .delete();
					if (f1.length() > 500)
						System.out.println("file name :" + extension + "size : " + f1.length());

			}
		}

	}
	/*
	 * File reading and File Writing
	 * autocloseable(interface)--->closeable(subinterface)--->input stream and
	 * outputstream it again classified into filterinputstream and file
	 * fileinputstream for filterinputstream alone comes under bufferedinputstream
	 * which reads the file in byte manner writing and reading -.txt files Stream
	 * -raw data nothing but the audio or video files
	 */

	public static void Filewriting() {
		File file = new File("D:\\filehandling\\name.txt");
		try {
			file.createNewFile();
			FileWriter write = new FileWriter(file);

			write.write("my name is saravanan");
			write.flush();
			write.close();

			boolean name = file.exists();
			// System.out.println(name);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void filereader() {
		File file = new File("D:\\filehandling\\name.txt");
		FileReader reader;
		try {
			reader = new FileReader(file);

			try {
				int output = reader.read();
				while (output != -1) {
					System.out.println((char) output);
					output = reader.read();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static void FileReadusingarray() {

		File file = new File("D:\\filehandling\\name.txt");
		char[] ch = new char[(int) file.length()];

		try {
			FileReader reader = new FileReader(file);

			reader.read(ch);
			for (char ch1 : ch)
				System.out.print(ch1);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

// file reader and file writer are used only to read and char by char to overcome this we use buffer reader
//
	public static void FileOperationusingbuff() {
		File file = new File("D:\\filehandling\\name.txt");
		FileWriter write;
		try {
			write = new FileWriter(file,true);
			BufferedWriter bwriter = new BufferedWriter(write);
			bwriter.write("name");

			bwriter.newLine();
			bwriter.write("saravanan");
			bwriter.newLine();
			bwriter.write("saravanan1");
			bwriter.flush();
			bwriter.close();
			FileReader freader = new FileReader(file);
			BufferedReader breader = new BufferedReader(freader);
			String line = breader.readLine();
			int count=0;
			int sentencecount=0;
			while (line != null) {
				count++;
			String [] sent=	line.split("[.]");
			sentencecount=sent.length+sentencecount;
				System.out.println(line);
				line = breader.readLine();
			}
			System.out.println( );
		} catch (IOException e) {
 
			e.printStackTrace();
		}

	}
	 

}
