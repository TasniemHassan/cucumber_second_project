In this project, I created a BDD Framework to test Smartbear website functionalities. I utilized maven as the project build tool,
Java as the programming language,Selenium WebDriverManager as the UI web application  automation tool and 
JUnit for its assertions, annotations and generating reports.
I used a page object model to centralize, maintain and reuse Web Elements and any related methods in object repositories. 
I used a singleton design pattern to provide a single instance driver to be used for the scripts.
I have a runner class to run steps classes, execute my suites and save reports. 
I have an utils package to store all my commonly used action methods as well as driver and Waiter class. 
I also utilize maven commands to run my smoke and regression suites and store HTML surefire reports in the target folder and can be easily emailed and accessed.
I also used my runner class to execute my smoke and regression tests by adding an @Regression or @Smoke annotation to each scenario in the feature file.
