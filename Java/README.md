# Java Application

### Installation
1. Download the repository<br />
`git clone https://github.com/pfuchs-tgm/terminreservierungssystem.git`
2. Create project<br />
It is highly recommended to use JetBrains's IntelliJ but this project should work on any
development environment.<br />
Since Eclipse and Intellij are the most common IDEs in terms of Java development
this README will for now only contain set-up guides for those two IDEs.
(right now just IntelliJ, Eclipse will probably be added in the future)
    1. IntelliJ<br />
    To set up this project in IntelliJ simply choose "Import project" on the startup-menu.
    Import a gradle repository with automatic settings.
    If you get asked to overwrite the .idea-Folder, just press yes. It won't affect the program.
    When you are using IntelliJ, you can also simply run gradle by right clicking it and
    executing the `run "build"` option. Gradle is implemented in IntelliJ, so you don't need to install it manually.
    You can continue with point 4.
    2. Eclipse<br /> 
    _Since Eclipse isn't being tested too well right now, I recommend you to just use
    IntelliJ while developing._
    <!--When you are using Eclipse, please ensure to use a version that supports JavaEE.
    First start it on your go-to-workspace. Then under `File` select `Import...`
    Choose `Gradle` and select `Existing Gradle Project`. Under Project root directory
    select the "Java"-Folder from your cloned git-repository.
    After that you can simply click `Finish`.-->

3. Run from console<br />
To run gradle from console you need gradle installed and added to your PATH variable.
Therefore, I recommend [this tutorial](https://gradle.org/install/?_ga=2.178919654.35539380.1525637070-460619871.1525637070).<br />
When gradle is installed and configured, you need to navigate to the folder
you cloned the git repository to.
Go into the `Java`-Folder and execute one of the following commands:<br />
`gradlew build && java -jar build/libs/trs-0.1.0.jar`<br />
`gradlew bootRun`<br />
This should successfully build and run the Spring Boot Application.

4. Run in IntelliJ<br />
To run the program in IntelliJ, it is recommended to enable auto-update.

