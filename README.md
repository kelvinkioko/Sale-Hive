# Sale-Hive

[![Actions Status](https://github.com/kelvinkioko/Sale-Hive/workflows/SaleHive%20CI/badge.svg)](https://github.com/kelvinkioko/Sale-Hive/actions)
[![Kotlin Version](https://img.shields.io/badge/kotlin-1.3.71-blue.svg)](http://kotlinlang.org/)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

**Sale Hive**
<p align="center">
    <a href="#business-description">Business Description</a> •
    <a href="#about-save-hive">About Save Hive</a> •
    <a href="#how-does-sale-hive-work">How does Sale Hive work?</a> •
    <a href="#screenshots">Screenshots</a> •
    <a href="#built-instructions">Built Instructions</a> •
    <a href="#features">Features</a> •
    <a href="#documentation">Documentation</a> •
    <a href="#automation">Automation</a> •
    <a href="#contact">Contact</a>
</p>

## Business Description
SaleHive is an android application that provides a centralized platform for users to discover and share information about products with the best discounts and the retail stores where they are sold. SaleHive is designed to help both consumers and retailers save time and money by providing a convenient and user-friendly solution to find and promote discounts.

SaleHive allows users to search for products by category, brand, or store and filter search results based on factors such as discount percentage, location, and availability. Users can create posts with information about discounted products, including product name, brand, retail store, price, discount percentage, and any other relevant details. They can also upload photos of the product and share their experiences or reviews. The application features a social element, allowing users to follow each other, like and comment on posts, and share posts on other social media platforms.

Retailers can partner with SaleHive and promote their discounts and promotions to users, helping them to reach new customers and increase sales. To ensure the accuracy and relevance of the information posted on the platform, SaleHive implements a moderation system where posts are reviewed and approved by moderators before being published. Users can also report inaccurate or misleading posts to moderators.

The success of SaleHive depends on its ability to attract and retain a significant user base and foster a vibrant and engaged community. SaleHive aims to be user-friendly, visually appealing, and feature-rich to ensure a positive user experience. With regular data analysis of user behavior and engagement, SaleHive will continuously improve and optimize the platform to provide maximum value to its users and retail partners.


## About Save Hive
### Problem Statement:
There is a lack of a convenient and centralized platform for users to discover and share information about products with the best discounts and the retail stores where they are sold, resulting in missed opportunities for savings and frustration for consumers.

### Why it is a problem:
Consumers are often faced with the challenge of finding the best deals on products they want to purchase. In addition, retailers face the challenge of reaching customers with their latest discounts and promotions. Without a centralized platform to share and discover information about products with the best discounts and where they are sold, both consumers and retailers miss out on potential savings and sales.

### Why it's critical to solve the problem:
With the ever-increasing cost of living, consumers are always looking for ways to save money. Retailers, on the other hand, are looking for ways to increase sales and customer loyalty. By providing a convenient and centralized platform for users to discover and share information about discounted products and where they are sold, the solution can help both consumers and retailers save time and money, ultimately increasing customer satisfaction and loyalty.

### How to measure the success of the solution:
The success of the solution can be measured by various metrics, such as the number of users who download and use the app, the number of posts created by users, the number of retailers that partner with the platform to promote their discounts, and the overall savings achieved by users. Additionally, user feedback and ratings can provide valuable insights into the effectiveness and usefulness of the platform.


## How does Sale Hive work?
The proposed solution would be an android application that allows users to post and share information about products with the best discounts and the retail stores where they are sold. The application would allow users to search for products by category, brand, or store and filter search results based on factors such as discount percentage, location, and availability.

Users would be able to create posts with information about discounted products, including product name, brand, retail store, price, discount percentage, and any other relevant details. They would also be able to upload photos of the product and share their experiences or reviews.

The application would feature a social element, allowing users to follow each other, like and comment on posts, and share posts on other social media platforms. Retailers would also be able to partner with the platform and promote their discounts and promotions to users.

To ensure the accuracy and relevance of the information posted on the platform, the solution could implement a moderation system where posts are reviewed and approved by moderators before being published. Additionally, users could report inaccurate or misleading posts to moderators.

The success of the solution would depend on its ability to attract and retain a significant user base and foster a vibrant and engaged community. The application would need to be user-friendly, visually appealing, and feature-rich to ensure a positive user experience. Retailers would also need to see value in partnering with the platform and promoting their discounts to users.

Regular data analysis of user behavior and engagement would provide insights into the effectiveness of the platform and inform future improvements and optimizations.

## Screenshots


## Built Instructions
1. Download Android Studio. Public holidays was built using Android Studio Electric Eel | 2022.1.1 Patch 1 | Build #AI-221.6008.13.2211.9514443, built on January 21, 2023 Gradle version 7.5
2. Clone project in the folder of your preference
    ```bash
    git clone https://github.com/kelvinkioko/Sale-Hive.git
    ```
3. Once cloning is complete, the project will download the necessary dependencies and it will be ready to run.


## Features
- Uses [date.nager.at](https://date.nager.at/Api) to fetch holiday and country data
- Get upcoming world wide public holidays
- Get country based public holidays based on country code and specific year
- Get long weekends based on country code and specific year
- Offline mode - Application caches holidays and countries locally and can show them even when the application is offline
- Ability to filter holidays and countries locally


## Documentation
- [Architecture]()
  Model View ViewModel. This separates our views from business logic. It makes the different code component testable, loosely coupled and maintainable.
- [Kotlin](https://kotlinlang.org/)
  The project is native android and has been developed with 95.9% kotlin
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
  Coroutines were used to allow asynchronous request with the ability to manage the different threads available
- [Flow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
  Used stateFlow to facilitate state updated from the ViewModel and state observation and consumption on the fragment side
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    View models have been used to stores UI-related data that isn't destroyed on UI changes and manage communication with the data layer through the domain
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding)
    Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
  - [Room](https://developer.android.com/topic/libraries/architecture/room)
    SQLite object mapping library that allows us to do local caching, reduce number of API calls in future and improve overall data fetch speeds for duplicate requests
- [Dependency Injection](https://developer.android.com/training/dependency-injection) -
  Public Holiday uses [Hilt-Dagger](https://dagger.dev/hilt/) to manage its dependencies.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Coding Guidelines]()
  - [Coding Style](https://developer.android.com/kotlin/style-guide)
    In the development process, there was a high emphasis on following the standard recommended coding structure guideline, naming conventions and resource management (Styling, themes, custom fonts and strings)
  - [ktlint](https://github.com/pinterest/ktlint)
    ktlint aims to enforce the official Kotlin coding conventions and Android Kotlin Style Guide
  - [lint](https://developer.android.com/studio/write/lint)
    Checks your Android project source files for potential bugs and optimization improvements for correctness, security, performance, usability, accessibility, and internationalization
- [Testing]()
  - [UI Testing]()
    In [androidTest](app/src/androidTest/java/com/sale/hive) you'll find a suite of UI tests that test different aspects of the fragments, and local cache
  - [Unit Testing]()
    In [test](app/src/test/java/com/sale/hive) you'll find a suite of unit tests that tests multiple sections of the app such as ViewModels and data class mappers


## Automation
### Github Actions
The Sale Hive project uses [Github Actions](https://github.com/kelvinkioko/Sale-Hive/actions) for continuous integration.

**Contributed By:** [Kelvin Kioko](https://github.com/kelvinkioko/)


## Contact
If you need any help, you can connect with me.