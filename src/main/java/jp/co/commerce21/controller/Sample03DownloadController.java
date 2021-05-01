package jp.co.commerce21.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.commerce21.dto.MemberDownloadDto;
import jp.co.commerce21.form.PostForm;
import jp.co.commerce21.service.MemberService;
import jp.co.commerce21.service.PostService;
import jp.co.commerce21.util.MyStringUtils;

@Controller
public class Sample03DownloadController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/sample03/index", method=RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "sample03/index";
	}
	
	@RequestMapping(value="/sample03/csvDownload", method=RequestMethod.POST)
	public void csvDownload(HttpServletResponse response) throws IOException {
        response.setContentType(MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE + ";charset=windows-31j");
        response.setHeader("Content-Disposition", "attachment; filename=\"member.csv\"");
        
        // 全件取得
        List<MemberDownloadDto> memberList = memberService.findAllForDownload();
        
        PrintWriter pw = response.getWriter();
        
        for(MemberDownloadDto memberDto : memberList) {
            StringBuilder sb = new StringBuilder();
            sb.append(MyStringUtils.setCsvStr(memberDto.getId().toString()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getText()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getPass()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getEmail()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getCalendar()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getArea()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getCheckBox()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getChecksBox()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getRadioBox()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getSelectBox()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getSelectsBox()) + ",");
            sb.append(MyStringUtils.setCsvStr(memberDto.getRegDate().toString()));
            sb.append(MyStringUtils.setCsvStr(memberDto.getUpDate().toString()));
            sb.append("\r\n");

            pw.print(sb);
        }
	}
	
	@RequestMapping(value="/sample03/pdfDownload")
	public void pdfDownload(HttpServletResponse response) throws IOException, Exception {    
		// テンプレートの読み込み
//		File jasperFile = new File("C:\\sts-bundle\\sts-3.8.4.RELEASE\\workspace-sts-3.8.4.RELEASE\\TestJasperReports\\test.jasper");
//		
//		// 帳票レイアウトのロード
//		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(jasperFile.getAbsoluteFile());
//		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//
//		// データの設定
//		JasperPrint print = JasperFillManager.fillReport(jasperReport, paramMap, new JREmptyDataSource());
//         
//		// PDFファイル作成
//		File pdf = new File("test.pdf");
//         
//		// PDF出力
//		JasperExportManager.exportReportToPdfFile(print,  pdf.getAbsolutePath());

	}
	
	@RequestMapping(value="/sample03/csvUpload", method=RequestMethod.POST)
	public String csvUpload(RedirectAttributes redirectAttributes, HttpServletResponse response, @RequestParam MultipartFile file) throws IOException {	
		
	    if (file.isEmpty()) {
	    	redirectAttributes.addFlashAttribute("upload_empty", "ng");
			return "redirect:index";
	    }
	    
	    List<PostForm> posts = new ArrayList<PostForm>();
	    
	    // csv読み込み
	    InputStream csvStream = file.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(csvStream, "SJIS"));
        
        br.lines().forEach(line -> {
        	PostForm post = new PostForm();
            String[] str = line.split(",");
            
            post.setZipCode(MyStringUtils.csvDqDel(str[2]));
            post.setZipCodeOld(MyStringUtils.csvDqDel(str[1]));
            post.setPrefCode(MyStringUtils.csvDqDel(str[0]));
            post.setPrefNameKana(MyStringUtils.csvDqDel(str[3]));
            post.setCityNameKana(MyStringUtils.csvDqDel(str[4]));
            post.setTownareaNameKana(MyStringUtils.csvDqDel(str[5]));
            post.setPrefName(MyStringUtils.csvDqDel(str[6]));
            post.setCityName(MyStringUtils.csvDqDel(str[7]));
            post.setTownareaName(MyStringUtils.csvDqDel(str[8]));
            post.setRemarks01(MyStringUtils.csvDqDel(str[9]));
            post.setRemarks02(MyStringUtils.csvDqDel(str[10]));
            post.setRemarks03(MyStringUtils.csvDqDel(str[11]));
            post.setRemarks04(MyStringUtils.csvDqDel(str[12]));
            post.setRemarks05(MyStringUtils.csvDqDel(str[13]));
            post.setRemarks06(MyStringUtils.csvDqDel(str[14]));
            
            posts.add(post);
            str = null;
            post = null;
        });     
        
        // 更新処理
        postService.updatePost(posts);
        
        redirectAttributes.addFlashAttribute("upload_ok", "ok");
		
		return "redirect:index";
	}
	
	@RequestMapping(value = "/sample03/importCsv", method = RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam MultipartFile file, HttpServletResponse response) throws InterruptedException, IOException {
		
	    if (file.isEmpty()) {
			return toJson("error");
	    }
	    
	    List<PostForm> posts = new ArrayList<PostForm>();
	    
	    // csv読み込み
	    InputStream csvStream = file.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(csvStream, "SJIS"));
        
        br.lines().forEach(line -> {
        	PostForm post = new PostForm();
            String[] str = line.split(",");
            
            post.setZipCode(MyStringUtils.csvDqDel(str[2]));
            post.setZipCodeOld(MyStringUtils.csvDqDel(str[1]));
            post.setPrefCode(MyStringUtils.csvDqDel(str[0]));
            post.setPrefNameKana(MyStringUtils.csvDqDel(str[3]));
            post.setCityNameKana(MyStringUtils.csvDqDel(str[4]));
            post.setTownareaNameKana(MyStringUtils.csvDqDel(str[5]));
            post.setPrefName(MyStringUtils.csvDqDel(str[6]));
            post.setCityName(MyStringUtils.csvDqDel(str[7]));
            post.setTownareaName(MyStringUtils.csvDqDel(str[8]));
            post.setRemarks01(MyStringUtils.csvDqDel(str[9]));
            post.setRemarks02(MyStringUtils.csvDqDel(str[10]));
            post.setRemarks03(MyStringUtils.csvDqDel(str[11]));
            post.setRemarks04(MyStringUtils.csvDqDel(str[12]));
            post.setRemarks05(MyStringUtils.csvDqDel(str[13]));
            post.setRemarks06(MyStringUtils.csvDqDel(str[14]));
            
            posts.add(post);
            str = null;
            post = null;
        });    
        
        // 更新処理
        postService.updatePost(posts);
		
		return toJson("success");
	}

	private String toJson(Object dt){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(dt);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
