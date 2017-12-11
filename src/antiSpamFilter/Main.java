package antiSpamFilter;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		AntiSpamFilterManualConfiguration a = new AntiSpamFilterManualConfiguration();
		AntiSpamFilterAutomaticConfiguration b = new AntiSpamFilterAutomaticConfiguration();
		a.init();
	}

}
