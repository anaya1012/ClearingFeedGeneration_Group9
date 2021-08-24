package com.service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	private final Path upload_root = Paths.get("uploads");

	private final Path download_root = Paths.get("downloads");
	
	@Override
	public void init() {
		try {
			if(!Files.exists(upload_root))
			{
				Files.createDirectory(upload_root);
			}
			else
			{
				System.out.println("File already created!");
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	@Override
	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.upload_root.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	
	@Override
	public Resource load(String filename) {
		try {
			Path file = download_root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}


	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.upload_root, 1).filter(path -> !path.equals(this.upload_root)).map(this.upload_root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
		}
	}
}