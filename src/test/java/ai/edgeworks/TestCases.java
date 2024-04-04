package ai.edgeworks;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVRecord;

import BaseClass.BaseClass;

public class TestCases {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		{

			FrontPage frontPage = new FrontPage();

			frontPage.UstEmployeeSignIn().UserLogin().UserRoleChangePage();

			ApprovedRRS ApprRRS = new ApprovedRRS();

			BaseClass bse = new BaseClass();

			Set<String> RRlist = bse.readFromCSV();

			for (String RRItem : RRlist) {

				ApprRRS.enterSearchText(RRItem);

				ApprRRS.clickSearchButton();

				ApprRRS.clickOnRRId(RRItem);

				ApprRRS.swichToRRMatchingSupplies();

				ApprRRS.clearSearchText();

				System.out.println(RRItem);
			}

		}
	}
}
