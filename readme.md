### What I did
- Add springSecurity class to protect api interface
- Create default user in memory
- Add log configuration(create info and error log), which can trace what you operated on the program
- Difine global ExceptionHandler so that catch the Exceptions from anywhere.
- Change all the api return value to "Result" object.Using the same object makes it easier for developers to understand and use the api.
- create test code
- Using synchronized to protect the thread.

※There can be many enhancement which haven't been done.(I haven't more time to enhance the program)
For example,It can create the Interceptor.Before running the Controller,we can do validation check and put the login information to the cache in the preHandler method.

### My experience in Java
- Most of the systems I have worked on in the past ten years have been Java-based. However, not all of my experience is in development; some of it includes web interface design,some document work,etc.Coding work experience is around 20%.
- I have been involved in framework construction and, during the Proof of Concept phase, I worked on migrating an existing system's framework to SpringMVC
- I have not had any work experience with the SpringBoot framework yet, and this is my first attempt to work on a project within the SpringBoot framework.