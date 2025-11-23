#Project Name : URL Shortener
A simple, fast, and reliable service to shorten long, unwieldy URLs into concise, memorable links.

##Features
Custom Short Links: Allows users to specify a custom slug for their shortened link.
Redirect: High-speed redirection from the short link to the original long URL.

##Getting Started
Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.
Prerequisites
    You will need the following software installed on your system:
    Language : Java 22 (SpringBoot)
    Database : MySQL
Installation
    1.Clone the repository
    2.Install dependencies
    3.Setup Environment Variables
    4.Run the application

##Usage
Shortening a URL
    To shorten a link, send a POST request to the /api/v1/shorten endpoint with the original URL.
Accessing the Original URL
    To redirect to the original URL, simply navigate to the short link in your browser.