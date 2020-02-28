package tk.springmvc.controller;

import com.google.protobuf.ByteString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
    private static String uploadPath = "/fileupload";

    @GetMapping
    public String getUpload(){
        return "upload";
    }

    @PostMapping
    public String postUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, ModelMap model) throws IOException {
        String path = request.getServletContext().getRealPath(uploadPath);
        uploadSingleFile(file,path);
        model.addAttribute("msg","File is uploaded!");
        return "upload";
    }

    @GetMapping("/batch")
    public String getBatchUpload(){
        return "batchUpload";
    }

    @PostMapping("/batch")
    public String postBatchUpload(@RequestParam("files") CommonsMultipartFile[] files, HttpServletRequest request, ModelMap model) throws IOException {
        String path = request.getServletContext().getRealPath(uploadPath);
        for(int i=0;i<files.length;i++){
            uploadSingleFile(files[i],path);
        }

        model.addAttribute("msg","Files are uploaded!");
        return "batchUpload";
    }

    private int uploadSingleFile(CommonsMultipartFile file, String path) throws IOException {
        String filename = file.getOriginalFilename();
        try(InputStream is = file.getInputStream();
            OutputStream os = new FileOutputStream(new File(path,filename));){
            byte[] buffer = new byte[400];
            int len=0;
            while((len=is.read(buffer)) != -1){
                os.write(buffer);
            }
        }catch (Exception e){
            return -1;
        }

        return 0;
    }
}
