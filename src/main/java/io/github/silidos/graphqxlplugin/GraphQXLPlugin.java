package io.github.silidos.graphqxlplugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Mojo(name = "graphqxl")
public class GraphQXLPlugin extends AbstractMojo {

    @Parameter(property = "graphqxl.inputFile", required = true)
    private String inputFile;

    @Override
    public void execute() throws MojoExecutionException {
        try {
            // Create a ProcessBuilder instance with the graphqxl command and inputFile
            ProcessBuilder processBuilder = new ProcessBuilder("graphqxl", inputFile);

            // Redirect the error stream to the output stream to display errors in the Maven log
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Capture the output using an InputStream and log it
            try (InputStream inputStream = process.getInputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    getLog().info(line);
                }
            }

            // Wait for the process to complete and get the exit code
            int exitCode = process.waitFor();

            // Throw an exception if the exit code is non-zero
            if (exitCode != 0) {
                throw new MojoExecutionException("graphqxl command execution failed with exit code " + exitCode);
            }
        } catch (InterruptedException | IOException e) {
            throw new MojoExecutionException("Error running graphqxl command", e);
        }
    }
}
