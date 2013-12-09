package com.secutix.brownbag.java7.demo;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

import org.apache.commons.lang.mutable.MutableInt;

import com.google.common.collect.Maps;

/**
 * Counts the number of jar files using a File Visitor.
 * <p>
 * 
 * @author Sebastien Caille (SCA)
 */
public class PathWalkTreeDemo {

	public static void main(final String[] args) throws IOException {

		final Path path = Paths.get("D:\\sca\\wars");
		final String extension = ".jar";

		Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
			/**
			 * Count of file in each folder being currently scanned
			 */
			private final Map<Path, MutableInt> filesPerFolder = Maps.newHashMap();

			@Override
			public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs)
					throws IOException {
				// Start counting the files of dir
				filesPerFolder.put(dir, new MutableInt(0));
				return super.preVisitDirectory(dir, attrs);
			}

			@Override
			public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) throws IOException {
				// stop counting the files of dir
				final MutableInt count = filesPerFolder.remove(dir);
				if (count.intValue() > 0) {
					System.out.println("Folder " + dir + ": " + count);
				}
				return super.postVisitDirectory(dir, exc);
			}

			@Override
			public java.nio.file.FileVisitResult visitFile(final Path file,
					final java.nio.file.attribute.BasicFileAttributes attrs) throws java.io.IOException {
				// filters and count the files
				if (file.toString().endsWith(extension)) {
					filesPerFolder.get(file.getParent()).increment();
				}
				return FileVisitResult.CONTINUE;
			}
		});

	}
}
