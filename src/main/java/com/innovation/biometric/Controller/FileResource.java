package com.innovation.biometric.Controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/file")
public class FileResource {

    public static final String DIRECTORY = "D:/NOTES/";


    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") List<MultipartFile> multipartFiles) {
        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            String fileName = file.getOriginalFilename();
            try {
                Path fileStorage = Path.of(DIRECTORY).resolve(fileName).toAbsolutePath().normalize();
                Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
                filenames.add(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        }
        return ResponseEntity.ok().body(filenames);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
        Path filePath = Path.of(DIRECTORY).resolve(filename).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            // Handle file not found exception
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; File-Name=" + resource.getFilename());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders)
                .body(resource);
    }

    @GetMapping("/display/{filename}")
    public ResponseEntity<byte[]> displayFile(@PathVariable("filename") String filename) throws IOException {
        Path filePath = Path.of(DIRECTORY).resolve(filename).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            // Handle file not found exception
            throw new FileNotFoundException(filename + " was not found on the server");
        }

        // Read the file content into a byte array
        byte[] fileContent = Files.readAllBytes(filePath);

        // Determine the media type of the file
        String contentType = Files.probeContentType(filePath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));
        headers.setContentDispositionFormData("inline", filename);

        return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
    }
}
