package com.secutix.brownbag.java7.exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

/**
 * Using Path, Paths and Files
 * 
 * @author Sebastien Caille (SCA)
 */
public class PathTest {

    @Test
	public void testListFolders() throws IOException {
	    final String tempFolder = System.getProperty("java.io.tmpdir")
		// Create a Path to tempFolder using a factory method in Paths. 
		final Path path = Paths.;
		System.out.println(path + ": depth = " + path.getNameCount());

		// Create a Path to c:\windows\temp\testcase.log using path.resolve(...) 
		final Path myLogFile = path.;
		
		assertEquals("c:\\windows\\temp", path.toString());
		assertEquals("c:\\windows\\temp\\testcase.log", myLogFile.toString());

		try {
			// create a file using a method of Files (do not use the one with the permissions)
			final Files. ;
			// Open a buffered writer using a method of Files. Use charset Charset.forName("ISO8859-1")
			try (BufferedWriter out = Files.)) {
				out.write("Hello world");
			}

			final DirectoryStream.Filter<Path> logFilter = new DirectoryStream.Filter<Path>() {

				@Override
				public boolean accept(final Path aPath) throws IOException {
					return aPath.toString().endsWith(".log");
				}

			};
			
			// open a stream on the directory (to read it's content), using a method in Files. Call it with the filter logFilter
			final DirectoryStream<Path> directoryContent = Files.;
			
			// The directoryContent is an Iterable. So you can use "for" or guava FluentIterable.from(...) to iterate.
			// Use FluentIterable.from + a guava Function to create a list of String with the format <FileName>: <File size>
			// 
			final ImmutableList<String> filesList =
					FluentIterable.
					
			assertNotNull(filesList);
			assertFalse(filesList.isEmpty());
			System.out.println(filesList);
		} finally {
			// At the end we delete the file
			Files.deleteIfExists(myLogFile);
		}
	}
}
