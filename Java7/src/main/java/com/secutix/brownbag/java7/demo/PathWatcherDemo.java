package com.secutix.brownbag.java7.demo;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * Watches file creation/deletion in a given folder.
 * <p>
 * 
 * @author Sebastien Caille (SCA)
 */
public class PathWatcherDemo {

    public static void main(final String[] args) throws IOException, InterruptedException {

        final Path path = Paths.get(System.getProperty("java.io.tmpdir"));

        System.out.println("Watching in " + path);

        final WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

        while (true) {
            final WatchKey entry = watchService.take();

            System.out.println(entry.watchable().toString());
            for (final WatchEvent<?> event : entry.pollEvents()) {
                System.out.println(event.kind().name() + ": " + event.context());
            }
            entry.reset();
        }
        // watchService.close();
    }
}
