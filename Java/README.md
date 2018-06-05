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


### Database
#### H2
The used database here is h2. This is a file based database. It is installed on your system automatically, so you don't need 
to add a special driver or something. That's also been the reason for us to implement this database.

#### Spring JPA
The connection to the database runs with Springs' JPA - what it does ist basically
the same as hibernate: In the given Spring repositories (you can modify them with the `scanBasePackages`-annotation in the
`@SpringBootApplication`-annotation), it searches all classes for `@Entity`-tags and saves them to the database.<br />
In the Spring JPA there are several tags that specify different things for the database - the most important
here are the `@Id` and the `@GeneratedValue` annotations which create an automatically increasing identifier for each entity
it get's used with (you should assign it to an integer/long to work).

##### JpaRepository
Saving data to the database and getting it out of it is done with the JpaRepository - it is an 
repository which has some methods (like saving the object or deleting it) implemented. By extending
from the interface, you can implement your own methods for selecting, saving or removing data from the database
with giving different information. It's very important to tag a repository with the `@Component`-annotation!


### User
The user is based on the [User](src/main/java/trs/data/User.java) class.<br />
The functionality for the user on the other hand (e.g. registering a new user or logging him in) is added in the
[UserController](src/main/java/trs/controller/UserController.java). GUI-Implementations can be found
in the [MappingController](src/main/java/trs/view/MappingController.java)
#### Register User
Registering a new user uses the template [register.html](src/main/resources/templates/register.html)
and the method `register()` in both the [UserController](src/main/java/trs/controller/UserController.java) and the 
[MappingController](src/main/java/trs/view/MappingController.java) (in this case also the `confirm_register()`)
to add a new User to the Database.
Note that the [UserRepository](src/main/java/trs/repositories/UserRepository.java) is used here as well.


### Comment
The comment is based on the [Comment](src/main/java/trs/data/Comment.java) class.<br />
The functionality for the user on the other hand (e.g. posting a new comment) is added in the
[EventController](src/main/java/trs/controller/EventController.java). GUI-Implementations can be found
in the [MappingController](src/main/java/trs/view/MappingController.java)
#### Add new comment
This functionality is added in the [EventController](src/main/java/trs/controller/EventController.java)'s 
`comment()`. It uses the [PollRepository](src/main/java/trs/repositories/PollRepository.java) to persist to the database.
#### Delete new comment
This functionality is added in the [EventController](src/main/java/trs/controller/EventController.java)'s 
`remove_comment()`. It uses the [PollRepository](src/main/java/trs/repositories/PollRepository.java) to persist to the database.


### Event
The event is based on the [Event](src/main/java/trs/data/Event.java) class.<br />
The functionality for the user on the other hand (e.g. creating a new event or adding users to it) is added in the
[EventController](src/main/java/trs/controller/EventController.java). GUI-Implementations can be found
in the [MappingController](src/main/java/trs/view/MappingController.java).
#### Add Location
A location gets added via the [EventControler](src/main/java/trs/controller/EventController.java)'s
`addLocation()` and persist with the [PollRepository](src/main/java/trs/repositories/PollRepository.java).
#### Add Description
A description gets added via the [EventControler](src/main/java/trs/controller/EventController.java)'s
`addDescription()` and persist with the [PollRepository](src/main/java/trs/repositories/PollRepository.java).


