# Voodoo Technical Test

## Versioning

Project is versioned under Git.

## Building

Project uses gradle for building and for dependency management

## Architectures Principles:  Clean architecture

Application is split in modules, each one with clearly stated and limited in scope.
Each module should have the smallest possible number of reasons to change.

Modules that can be pure java, shouldn't be android. Everything is smoother and easier, compilation, testing...
And it offers opportunities to create standalone java apps, to bench or do integration tests easily runnable by every CI server.
Lastly it open a door on a shared multiplatform library extraction.

## What's missing :(

Due to a lack of time, the features are not fully implemented. I tried to implement some bricks in order to show the way I would have done it.
I'm aware that the architecture is not fully implemented due to a lack of time and I'm really sorry for that.
If I had more time, I would wire the bricks together and implement the missing features. I would add a presentation layer
in sdk in order to show the ads.
I would add unit tests (I didn't test the usecases/ repositories : shame on me)  
I would add a Watchdog which is a java application that uses api to operate some sanity checks. It checks parts of the contract with server, that cannot be checked only by type checking :
- Non empty fields
- items unicity
- and every implicit contract ...

## Possible next steps

__Using precompiled gradle plugins__

__Entities builders in domain module__  
Let the domain choose default values on construction and have a chance to reconcile data.

__Kotlin Multiplatform__  
A shared module including presentation.

