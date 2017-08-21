# MitL-support

Utilities of general use, both general and metaheuristic specific. The former include extensions to functionality from java.lang, java.math and java.util. The latter includes random selection and sampling.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

To use this library you need Java 8 JDK, [Scala](https://www.scala-lang.org/download/) and [sbt](http://www.scala-sbt.org/download.html/) installed.

If you want to use an IDE rather than running everything from the command line, the below mentioned IDEs have been checked to work:
- [Scala IDE for eclipse](http://scala-ide.org/download/sdk.html)
- [IntelliJ Idea](https://www.jetbrains.com/idea/) with the Scala plugin [downloaded and enabled](https://www.jetbrains.com/help/idea/enabling-and-disabling-plugins.html) 

(Where IntelliJ is probably slightly simpler to set up.)

### Installing

Once you have this repository downloaded, you can either work directly from the terminal, or using and an IDE. These instructions present how to run the library using IntelliJ and Eclipse.

#### IntelliJ

Before proceding, make sure you have the Scala plugin [downloaded and enabled](https://www.jetbrains.com/help/idea/enabling-and-disabling-plugins.html).

Select **Import Project** on the Welcome screen, or select **File | Open** and specify project location.

Depending on your operating system, a **Use auto-import** opion might apper. If it does, check the box to allow auto-import. Otherwise, you'll have to refresh the IDE every time you edit sbt build - related files.

#### Scala IDE for Eclipse

Once you download [Scala IDE for eclipse](http://scala-ide.org/download/sdk.html) and have sbt installed, you should be able to run ```sbt eclipse``` in the command line, in the project's root directory (.../mitlproblems). The output of the command should look similar to this:

```
[info] Loading project definition from /Users/username/MitL/mitl-support/project
[info] Set current project to MitLware-problems (in build file:/Users/username/MitL/mitl-support/)
[info] About to create Eclipse project files for your project(s).
[info] Successfully created Eclipse project files for project(s):
[info] MitLware-problems
```

The command creates .classpath and .project files, which eclipse recognises as its own project files. Now you can fire up eclipse, go to **File** -> **Open Projects from File System...** and enter the path to the project's root directory (/Users/username/MitL/mitl-support/). Eclipse should see the files created by sbt. Click finish and you're done! 

If you are unable to run ```sbt eclipse```, see <https://github.com/typesafehub/sbteclipse>.

## Built With

* [sbt](http://www.scala-sbt.org/) - Scala Build Tool
* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [releases](https://github.com/MitLware/mitl-support/releases). 

## Authors

* Jerry Swan
* Faustyna Krawiec
* David R. White

See <http://www.mitlware.org/> for more infromation on the project.

Related repositories can be found at <https://github.com/MitLware>.

See also the list of [collaborators](COLLABORATORS.md) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
