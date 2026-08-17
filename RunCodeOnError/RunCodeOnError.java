package RunCodeOnError;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class RunCodeOnError {

	@FunctionalInterface
	public interface CatchErrorRunnable {
		public void runWithError(Throwable e);
	}

	public static Process newProcess(List<String> command, CatchErrorRunnable onError) {
		Process process = null;

		if (command == null || command.size() < 1 || command.get(0).isEmpty()) {
			onError.runWithError(new IllegalArgumentException("Invalid Command"));
			return process;
		}

		try {
			process = new ProcessBuilder(command).start();
		} catch (Exception e) {
			onError.runWithError(e);
		}

		return process;
	}

	public static StringBuffer captureStdout(Process p) {
		StringBuffer buffer = new StringBuffer();
		try (
				BufferedReader in = new BufferedReader(
						new InputStreamReader(p.getInputStream()))) {
			String line;
			while ((line = in.readLine()) != null) {
				buffer.append(line + "\n");
			}
		} catch (IOException ioe) {
			System.out.println("ERROR: Could not get output from process");
		}
		return buffer;
	}

	public static void main(String[] args) {
		Process lsProc = RunCodeOnError.newProcess(Arrays.asList("ls"), error -> {
			System.out.println("Could not run 'ls': " + error.getMessage());
			throw new RuntimeException(error);
		});
		System.out.println(RunCodeOnError.captureStdout(lsProc).toString());

		Process nullProc = RunCodeOnError.newProcess(null, error -> {
			System.out.println("Command Error: " + error.getMessage());
			throw new RuntimeException(error);
		});
		System.out.println(RunCodeOnError.captureStdout(nullProc).toString());
	}
}
