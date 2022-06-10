package com.complaint.services;

import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.complaint.model.Complaint;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class LoadComplaints {

	public List<Complaint> loadCompalintsFromCsv() {
		List<Complaint> complaints = new ArrayList<>();

		try {
			ClassLoader classLoader = this.getClass().getClassLoader();
			File file = new File(classLoader.getResource("complaints.csv").getFile());
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			
			for (String[] row : allData) {
				Complaint complaint = new Complaint();
				complaint.setComplaintID(Integer.parseInt(row[13]));
				complaint.setDateReceived(LocalDate.parse(row[0], formatter));
				complaint.setProduct(row[1]);
				complaint.setSubProduct(row[2]);
				complaint.setIssue(row[3]);
				complaint.setSubIssue(row[4]);
				complaint.setCompany(row[5]);
				complaint.setState(row[6]);
				complaint.setZipCode(row[7]);
				complaint.setSubmittedVia(row[8]);
				complaint.setDateClosed(LocalDate.parse(row[9], formatter));
				complaint.setCompanyResponse(row[10]);
				complaint.setTimelyResponse((row[11].equals("Yes")) ? true : false);
				complaint.setConsumerDispute((row[12].equals("Yes")) ? true : false);

				complaints.add(complaint);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complaints;
	}

}
