package tk.springmvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("download")
public class DownloadController {
    private static String downloadPath = "/fileupload";

    @GetMapping
    public String getDownload(HttpServletRequest req, HttpServletResponse resp, ModelMap model){
        String path = req.getServletContext().getRealPath(downloadPath);
        File fileDir = new File(path);
        List<String> files = Arrays.asList(fileDir.list());
        model.addAttribute("filelist",files);
        return "download";
    }

    @GetMapping("/file")
    public void downloadFile(String filename, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置响应流文件进行下载
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        try(ServletOutputStream sos = resp.getOutputStream();){
            File file = new File(req.getServletContext().getRealPath(downloadPath), filename);
            byte[] bytes = FileUtils.readFileToByteArray(file);
            sos.write(bytes);
            sos.flush();
        }
    }
}
