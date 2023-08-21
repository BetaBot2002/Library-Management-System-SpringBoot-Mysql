package com.lms.librarymanagementsystem.Handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileHandler {
	public static boolean saveFile(MultipartFile file, String path) {
		try {
			InputStream is = file.getInputStream();
			byte[] fileArray = new byte[is.available()];
			is.read(fileArray);

			FileOutputStream fos = new FileOutputStream(path);
			fos.write(fileArray);
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void deleteFile(String filePath) {
		File file = new File(filePath);

		if (file.exists()) {
			boolean isDeleted = file.delete();

			if (isDeleted) {
				System.out.println("File deleted successfully.");
			} else {
				System.out.println("Failed to delete the file.");
			}
		} else {
			System.out.println("File does not exist.");
		}
	}
}
