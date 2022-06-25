package com.eneskacan.summarizer_maven_plugin;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Developer;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Mojo(name = "summarize", defaultPhase = LifecyclePhase.COMPILE)
public class Summarizer extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        String projectSummary = getProjectSummary(project);
        File outputFile = new File(project.getBasedir().getAbsolutePath() + "/summary.txt");

        try {
            writeToFile(projectSummary, outputFile);
        } catch (IOException e) {
            throw new MojoFailureException(String.format("Failed to write summary file: %s", e.getMessage()));
        }
    }

    private String getProjectSummary(MavenProject p) {
        StringBuilder builder = new StringBuilder();

        // Project info
        builder.append(
                String.format("Project Info: %s.%s.%s %n", p.getGroupId(), p.getArtifactId(), p.getVersion())
        );

        // Developers
        builder.append("Developers: \n");
        for(Developer dev : (List<Developer>) p.getDevelopers()) {
            builder.append(String.format("\t- %s %n", dev.getName()));
        }

        // Release date
        builder.append(String.format("Release date: %s %n", p.getProperties().get("release.date")));

        // Dependencies
        builder.append("Dependencies: \n");
        for(Dependency dep : (List<Dependency>) p.getDependencies()) {
            builder.append(String.format("\t- %s.%s.%s %n", dep.getGroupId(), dep.getArtifactId(), dep.getVersion()));
        }

        // Plugins
        builder.append("Plugins: \n");
        for(Plugin plugin : (List<Plugin>) p.getBuildPlugins()) {
            builder.append(String.format("\t- %s.%s.%s %n", plugin.getGroupId(), plugin.getArtifactId(), plugin.getVersion()));
        }

        return builder.toString();
    }

    private void writeToFile(String msg, File file) throws IOException {
        try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(msg);
        }
    }
}
