# 🚀 Conditional Navigation in Android with Kotlin

## Introduction
Conditional navigation in Android allows developers to dynamically navigate between different screens based on certain conditions or user actions. This README provides an overview and guide on implementing conditional navigation in Android using Kotlin.

## Table of Contents
1. [Setup](#setup)
2. [Basic Usage](#basic-usage)
3. [Conditional Navigation Techniques](#conditional-navigation-techniques)
    - [Using if-else Statements](#using-if-else-statements)
    - [Using when Expression](#using-when-expression)
    - [Using Sealed Classes](#using-sealed-classes)
4. [Examples](#examples)
5. [Conclusion](#conclusion)
6. [Contributing](#contributing)

## Setup
Ensure you have Kotlin set up in your Android project. You can add Kotlin to your project by adding the Kotlin Gradle plugin to your build.gradle file.

```gradle
// Add Kotlin plugins
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

Basic Usage
In Android, navigation between screens is typically handled using navigation components. Conditional navigation involves making decisions at runtime to navigate to different destinations based on certain conditions.

// Sample code demonstrating conditional navigation using Navigation component
val directions = if (condition) {
    FragmentDirections.actionFragmentAtoFragmentB()
} else {
    FragmentDirections.actionFragmentAtoFragmentC()
}
findNavController().navigate(directions)

Conditional Navigation Techniques

There are various techniques to implement conditional navigation in Android. Here are a few common ones:


Examples
For practical examples and implementations, please refer to the sample code provided in the examples/ directory of this repository.

Conclusion
Conditional navigation is a powerful feature in Android development that allows developers to create dynamic and user-centric navigation flows. By using Kotlin and Android navigation components, you can easily implement conditional navigation in your applications.

Contributing
Contributions are welcome! Feel free to submit issues and pull requests to help improve this project.
