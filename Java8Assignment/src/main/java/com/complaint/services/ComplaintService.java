package com.complaint.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.complaint.model.Complaint;

public class ComplaintService {

	public void displayComplaintsByID(List<Complaint> complaints) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Enter 1 to get Complaint details, 0 to Exit");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Enter Complaint ID:");
				int id = scanner.nextInt();
				Optional<Complaint> optionalComplaint = getByComplaintID(complaints, id);
				if (optionalComplaint.isPresent()) {
					System.out.println(optionalComplaint.get());
				} else {
					System.out.println("Complaint not found");
				}
			} else {
				break;
			}
		} while (choice != 0);
	}

	public void displayComplaintsByYear(List<Complaint> complaints) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Enter 1 to get Complaint details, 0 to Exit");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Enter Complaint Year:");
				int year = scanner.nextInt();
				Optional<List<Complaint>> optionalComplaint = getComplaintsByYear(complaints, year);
				if (optionalComplaint.isPresent()) {
					System.out.println(optionalComplaint.get());
				} else {
					System.out.println("Complaint not found");
				}
			} else {
				break;
			}
		} while (choice != 0);
	}

	public void displayComplaintsByBankName(List<Complaint> complaints) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Enter 1 to get Complaint details, 0 to Exit");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Choose Bank Name among these:");
				System.out.println(getListOfBankNames(complaints));
				String bankName = scanner.next();
				Optional<List<Complaint>> optionalComplaint = getByBankName(complaints, bankName);
				if (optionalComplaint.isPresent()) {
					System.out.println(optionalComplaint.get());
				} else {
					System.out.println("Complaint not found");
				}
			} else {
				break;
			}
		} while (choice != 0);
	}

	public void displayTimeTakenByComplaintID(List<Complaint> complaints) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Enter 1 to get Complaint details, 0 to Exit");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Enter Complaint ID:");
				int id = scanner.nextInt();
				Optional<Complaint> optionalComplaint = complaints.stream().filter(comp -> comp.getComplaintID() == id)
						.findFirst();
				if (optionalComplaint.isPresent()) {
					Complaint complaint = optionalComplaint.get();
					LocalDate from = complaint.getDateReceived();
					LocalDate to = complaint.getDateClosed();

					Period period = Period.between(from, to);

					System.out.print(period.getYears() + " years,");
					System.out.print(period.getMonths() + " months,");
					System.out.println(period.getDays() + " days");
				} else {
					System.out.println("Complaint not found");
				}
			} else {
				break;
			}
		} while (choice != 0);
	}

	public Optional<Complaint> getByComplaintID(List<Complaint> complaints, int id) {
		return complaints.stream().filter(comp -> comp.getComplaintID() == id).findFirst();
	}

	public Optional<List<Complaint>> getComplaintsByYear(List<Complaint> complaints, int year) {
		return Optional.ofNullable(complaints.stream().filter(comp -> comp.getDateReceived().getYear() == year)
				.collect(Collectors.toList()));
	}

	public Optional<List<Complaint>> getByBankName(List<Complaint> complaints, String bankName) {
		return Optional.ofNullable(complaints.stream().filter(comp -> comp.getCompany().equalsIgnoreCase(bankName))
				.collect(Collectors.toList()));
	}

	public List<String> getListOfBankNames(List<Complaint> complaints) {
		return complaints.stream().map(cust -> cust.getCompany()).distinct().sorted().collect(Collectors.toList());
	}
}
