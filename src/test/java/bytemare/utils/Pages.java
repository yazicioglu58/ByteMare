package bytemare.utils;

import bytemare.pages.MyTeamPage;
import bytemare.pages.SignInPage;

public class Pages {
	private SignInPage signInPage;
	private MyTeamPage myTeamPage;

	public SignInPage signin() {
		if (signInPage == null) {
			signInPage = new SignInPage();
		}
		return signInPage;
	}

	public MyTeamPage myTeam() {
		if (myTeamPage == null) {
			myTeamPage = new MyTeamPage();
		}
		return myTeamPage;
	}

}
