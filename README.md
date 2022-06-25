
# Summarizer Maven Plugin

Summarizer plugin extracts project details including project info, developers, release date, dependencies, and plugins from `pom.xml` and reports to `summary.txt` file. By default, it is executed in the compile phase.
## Installation

Clone the project

```bash
  git clone https://github.com/eneskacan/summarizer-maven-plugin.git
```

Go to the project directory

```bash
  cd summarizer-maven-plugin
```

Install plugin

```bash
  mvn clean install
```

## Usage

Go to the project directory to be summarized

```bash
  mvn com.eneskacan:summarizer-maven-plugin:0.0.1:summarize
```


## Example Output File

```bash
Project Info: com.eneskacan.summarizer-maven-plugin.0.0.1 
Developers: 
	- Enes 
	- Ahmet 
Release date: 06.26.2022 
Dependencies: 
	- org.apache.maven.maven-plugin-api.3.6.3 
	- org.apache.maven.plugin-tools.maven-plugin-annotations.3.6.0 
	- org.apache.maven.maven-project.2.2.1 
	- junit.junit.3.8.1 
	- org.apache.maven.plugin-testing.maven-plugin-testing-harness.3.3.0 
Plugins: 
	- org.apache.maven.plugins.maven-clean-plugin.2.5 
	- org.apache.maven.plugins.maven-resources-plugin.2.6 
	- org.apache.maven.plugins.maven-jar-plugin.2.4 
	- org.apache.maven.plugins.maven-plugin-plugin.3.2 
	- org.apache.maven.plugins.maven-compiler-plugin.3.1 
	- org.apache.maven.plugins.maven-surefire-plugin.2.12.4 
	- org.apache.maven.plugins.maven-install-plugin.2.4 
	- org.apache.maven.plugins.maven-deploy-plugin.2.7 
	- org.apache.maven.plugins.maven-site-plugin.3.3 

```

## Acknowledgements

- [How to Create a Maven Plugin](https://www.baeldung.com/maven-plugin)
- [Patika.dev](https://www.patika.dev/tr)

