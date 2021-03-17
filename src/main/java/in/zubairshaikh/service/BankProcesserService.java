package in.zubairshaikh.service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.zubairshaikh.model.BankCard;
import in.zubairshaikh.utility.Utility;

@Service
public class BankProcesserService {

	
	public List<BankCard> getBankData(String cardDetails) {
		String lines[] = cardDetails.split("\\r?\\n");

		List<String> rows = Arrays.asList(lines);

		List<BankCard> bankCards = rows.stream().map(mapper -> {
			String[] arr = mapper.split(",");

			String cardNumber = arr[1];

			if (cardNumber.contains("-")) {
				String[] cardDigitArr = cardNumber.split("-");
				String firstFourDigits = cardDigitArr[0];

				StringBuilder sb = new StringBuilder(firstFourDigits);

				for (int i = 1; i < cardDigitArr.length; i++) {
					sb.append("-");
					sb.append(cardDigitArr[i].replaceAll("[0-9]", "x"));

				}

				return new BankCard(arr[0], sb.toString(), arr[2]);
			} else {

				return new BankCard(arr[0], "", arr[2]);
			}

		}).filter(predicate -> {

			return !predicate.getCardNumber().isEmpty();
		}).sorted((a, b) -> {

			try {
				return Utility.getDate(b.getExpiryDate()).compareTo(Utility.getDate(a.getExpiryDate()));
			} catch (ParseException e) {
				return 0;
			}

		}).collect(Collectors.toList());

		return bankCards;
	}
}
