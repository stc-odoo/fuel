package com.reitano.carburanti.TXTSer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TextFileExporter implements FileExporter {

	private static final String export_directory = "/Carburante";
	private Logger logger = LoggerFactory.getLogger(TextFileExporter.class);
	
	@Override
	public Path export(String fcontent, String fname) {
		// TODO Auto-generated method stub
		Path filePath = Paths.get(export_directory, fname);
		try {
			Path expFilePath= Files.write(filePath, fcontent.getBytes(), StandardOpenOption.CREATE);
			return expFilePath;
		}catch(IOException e) {
			logger.error(e.getMessage());
		}
		
		return null;
	}

}
