package in.zubairshaikh.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.zubairshaikh.model.BankCard;
import in.zubairshaikh.model.BankCardData;
import in.zubairshaikh.service.BankProcesserService;
import in.zubairshaikh.utility.Utility;

@RestController
@CrossOrigin

@RequestMapping("/api")
public class BankProcessorController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BankProcesserService service;

	@PostMapping("/post-data")

	public List<BankCard> postData(@RequestBody BankCardData data) {

		String cardDetails = data.getBankDetails();

		return service.getBankData(cardDetails);
	}

	@PostMapping("/upload-csv-file")
	public List<BankCard> uploadCSVFile(@RequestParam("file") MultipartFile file) throws IOException {

		File fileData = Utility.convertMultiPartToFile(file);
		String cardDetails = new String(Files.readAllBytes(Paths.get(fileData.getPath())));
		fileData.delete();

		return service.getBankData(cardDetails);

	}

}