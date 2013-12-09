package com.secutix.brownbag.java7.exercises;

import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * Exercising try-with-resources
 * <p>
 * The goal is to change the method readFont.
 * <p>
 * Inspired by TnPD drivers.
 * 
 * @author Sebastien Caille (SCA)
 */
public class TryWithResources {

	/**
	 * Change this method to use try-with-resources.
	 * <p>
	 * 
	 * @param font
	 * @throws IOException
	 */
	private void readFont(final Font font) throws IOException {

		InputStream is = null;
		final ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {

			// the "if" is required. So please find a way to keep it.
			// Please do _not_ use the (bool)?a:b operator. It would make the code hard to read
			if (font.getURL() == null) {
				is = new BufferedInputStream(getClass().getResourceAsStream("/bbl/exercises/" + font.getName()));
			} else {
				is = new ByteArrayInputStream(("Hello world from url <" + font.getURL() + ">").getBytes());
			}
			// Read the data
			final byte[] buf = new byte[4096];
			while (true) {
				final int size = is.read(buf);
				if (size == -1) {
					break;
				}
				os.write(buf, 0, size);
			}
			// copy content into data object
			font.setData(os.toByteArray());
		} finally {
			closeStream(is);
			closeStream(os);
		}
	}

	/**
	 * A font
	 * <p>
	 * 
	 * @author Sebastien Caille (SCA)
	 */
	public class Font {

		private final String name;
		private byte[] data;
		private String url;

		public String getName() {
			return name;
		}

		public Font(final String name) {
			this.name = name;
		}

		public String getURL() {
			return url;
		}

		public void setUrl(final String url) {
			this.url = url;
		}

		public void setData(final byte[] data) {
			this.data = data;
		}

	}

	private void closeStream(final Closeable toClose) throws IOException {
		toClose.close();
	}

	/**
	 * A test case. DO NOT CHANGE IT. Only change readFont
	 * 
	 * @throws IOException
	 */
	@Test
	public void testResource() throws IOException {
		final Font font = new Font("SomeData.txt");
		readFont(font);
		assertEquals("File content does not match", "Hello world from file", new String(font.data));
	}

	/**
	 * A test case. DO NOT CHANGE IT. Only change readFont
	 * 
	 * @throws IOException
	 */
	@Test
	public void testResourceURL() throws IOException {
		final Font font = new Font("SomeData.txt");
		font.setUrl("some URL");
		readFont(font);
		assertEquals("File content does not match", "Hello world from url <some URL>", new String(font.data));
	}

}
