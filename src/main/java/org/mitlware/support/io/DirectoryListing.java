package org.mitlware.support.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.*;

public final class DirectoryListing extends SimpleFileVisitor<Path> {

	private static final Logger LOGGER = Logger.getLogger( DirectoryListing.class.getName() );

    private final List< Path > files = new ArrayList< Path >();
    private final String fileExtension;
    private final boolean isRecursive;

    ///////////////////////////////

    /**
     * Method returns the list of paths to files in directoryName and any of its
     * subdirectories, which end with the specified file extension
     *
     * @param directoryName name of root directory to search in
     * @param fileExtension extension files must have to be returned in the list
     * @return list of paths to files
     */
    public static List<Path> listFiles(String directoryName, String fileExtension,boolean isRecursive)
    throws IOException {
        DirectoryListing temp = new DirectoryListing(directoryName, fileExtension,isRecursive);
        return temp.files;
    }

    ///////////////////////////////

    public DirectoryListing( String directoryName,
    		String fileExtension,
    		boolean isRecursive ) throws IOException {
    	this.fileExtension = fileExtension;
    	this.isRecursive = isRecursive;
        Files.walkFileTree(Paths.get(directoryName), this);
    }

    ///////////////////////////////

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
        if( file.toString().regionMatches(true,file.toString().length()-fileExtension.length(), fileExtension, 0, fileExtension.length()) )
        	files.add(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attributes)
    throws IOException {
      return isRecursive ? FileVisitResult.CONTINUE : FileVisitResult.SKIP_SUBTREE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException e) {
        // System.err.println(e);
    	LOGGER.warning( e.getMessage() );
        return FileVisitResult.CONTINUE;
    }
}

// End ///////////////////////////////////////////////////////////////

