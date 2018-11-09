package com.hemant.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class FileUtility {

	public static void copyFile(final File srcPath, final File dstPath) throws IOException {

		if (srcPath.isDirectory()) {
			if (!dstPath.exists()) {
				dstPath.mkdir();
			}

			String[] files = srcPath.list();
			for (String file : files) {
				copyFile(new File(srcPath, file), new File(dstPath, file));
			}
		} else {
			if (!srcPath.exists()) {
				throw new IOException("Directory Not Found ::: " + srcPath);
			} else {
				InputStream in = null;
				OutputStream out = null;
				try {
					if (!dstPath.getParentFile().exists()) {
						dstPath.getParentFile().mkdirs();
					}

					in = new FileInputStream(srcPath);
					out = new FileOutputStream(dstPath);

					// Transfer bytes
					byte[] buf = new byte[1024];
					int len;

					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
				} finally {
					if (in != null) {
						try {
							in.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					if (out != null) {
						try {
							out.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public static void copyFile(final String srcPath, final String dstPath) throws IOException {
		copyFile(new File(srcPath), new File(dstPath));
	}

	public static boolean deleteDirectory(final File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					deleteDirectory(file);
				} else {
					file.delete();
				}
			}
		}

		return path.delete();
	}

	public static boolean deleteDirectory(final String dir) {
		return deleteDirectory(new File(dir));
	}

	public static String readFromFile(final File path) throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			return readFromFile(fis);
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}

	public static String readFromFile(final InputStream path) throws IOException {
		InputStreamReader fr = null;
		BufferedReader br = null;
		StringBuilder stringBuilder = new StringBuilder();

		try {
			fr = new InputStreamReader(path);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return stringBuilder.toString();
	}

	public static void writeToFile(final String path, final String content) throws IOException {

		System.gc();

		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedWriter bw = null;
		try {
			File parentDir = new File(path).getParentFile();
			if (!parentDir.exists()) {
				parentDir.mkdirs();
			}

			fileOutputStream = new FileOutputStream(path);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF8");
			bw = new BufferedWriter(outputStreamWriter);
			bw.write(content);
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (outputStreamWriter != null) {
				try {
					outputStreamWriter.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getLatestFile(final String folder) {
		String file = null;
		File folderFile = new File(folder);
		if (folderFile.exists() && folderFile.isDirectory()) {
			File[] files = folderFile.listFiles();
			long date = 0;

			for (int i = 0; i < files.length; i++) {
				if (files[i].lastModified() > date) {
					date = files[i].lastModified();
					file = files[i].getAbsolutePath();
				}
			}
		}

		return file;
	}

	public static String decodePath(final String path) throws UnsupportedEncodingException {
		return URLDecoder.decode(path, "UTF-8");
	}
}
