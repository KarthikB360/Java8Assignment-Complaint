package com.complaint;

import java.util.List;
import java.util.Scanner;

import com.complaint.model.Complaint;
import com.complaint.services.ComplaintService;
import com.complaint.services.LoadComplaints;

public class Application {
	public static void main(String[] args) {

		LoadComplaints complaint = new LoadComplaints();
		List<Complaint> complaints = complaint.loadCompalintsFromCsv();
		ComplaintService complaintService = new ComplaintService();

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("----------Complaint Menu----------");
			System.out.println(
					"1. Get Complaint details by Complaint ID\n2. Get Complaints by year\n3. Get Complaints by Bank name\n4. Get the total time taken by Complaint ID\n0. Exit ");
			System.out.println("------------------------------");
			System.out.println("Enter desired function to perform or 0 to exit");

			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				complaintService.displayComplaintsByID(complaints);
				break;
			case 2:
				complaintService.displayComplaintsByYear(complaints);
				break;
			case 3:
				complaintService.displayComplaintsByBankName(complaints);
				break;
			case 4:
				complaintService.displayTimeTakenByComplaintID(complaints);
				break;

			default:
				break;
			}
		} while (choice != 0);

	}
}
